package org.miso.cloud.robotic.modular.wizard;	

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.miso.cloud.robotic.modular.nature.GeneralProjectNature;
import org.miso.cloud.robotic.cloudsystemmodular.wizard.CloudSystemNewProjectNature;
import org.mondo.generate.modular.project.general.create.project.main.api.CopierReverseEngineering;

import cloudRobotics.CloudSystem;

public class GeneralModularProjectWizard extends Wizard implements INewWizard {

	private GeneralModularCreationPage mainPage;
	public List<String> allNatures;
	
	public GeneralModularProjectWizard() {
		setWindowTitle("Create a container project");
		allNatures = new ArrayList<String>();
		initAllNatures();
	}
	
	private void initAllNatures() {		
		
		this.allNatures.add(GeneralProjectNature.ID);
		this.allNatures.add(CloudSystemNewProjectNature.ID);
		this.allNatures.add("org.eclipse.epsilon.concordance.nature.ConcordanceNature");				
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {		

	}
	
	@Override
	public void addPages() {

		super.addPages();
		mainPage = new GeneralModularCreationPage("Create General Modular Project");
		mainPage.setTitle("Create Container Project");
		mainPage.setDescription("Project that can contain several root");
		addPage(mainPage);
	}
	
	@Override
	public boolean performFinish() {

		String modelUri = mainPage.getDiagramUri();

		if (modelUri.equals("") == false) {

			URI fileUri = URI.createFileURI(modelUri);
			String name = fileUri.trimFileExtension().lastSegment();
			createProject(name);

			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(fileUri, true);
			reverseEngineering(name, resource);

		} else {
			createProject(mainPage.getProjectName());
		}
		return true;
	}
	
	public void createProject(String name) {

		final IWorkspaceRunnable create = new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {

				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
				if (project.exists() == false) {

					project.create(null);
					project.open(null);

					//Add Natures
					addAllProjectNatures(project);	
				}
			}

		};

		try {

			ResourcesPlugin.getWorkspace().run(create, null);

		} catch (CoreException e) {

			e.printStackTrace();
		}
	}
	
	public void addAllProjectNatures(IProject project) {
		
		try {
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + allNatures.size()];
			
			for (int i = 0; i < allNatures.size(); i++) {
				newNatures[natures.length + i] = allNatures.get(i);
			}
			
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
			
		} catch (CoreException e) {
			
			e.printStackTrace();
		}		
	}
	
	// join methods
	public static void reverseEngineering(String name, Resource resource) {
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		
		Iterator<EObject> itContents = resource.getContents().iterator();
		
		CopierReverseEngineering copier = new CopierReverseEngineering(true, true);		
		ResourceSet reset = new ResourceSetImpl();
		
		while (itContents.hasNext()) {
			EObject eObject = (EObject) itContents.next();
			
			if(eObject instanceof CloudSystem){
				
				org.miso.cloud.robotic.cloudsystemmodular.ModularModel createProject = 
						new org.miso.cloud.robotic.cloudsystemmodular.ModularModel();
						createProject.reverseEngineeringContainer((CloudSystem) eObject,project,copier,reset);
			}
			
		}
		
		copier.copyReferences();
		copier.copyIds();
		//save
		saveAll(reset);
		copier.clear();		
	}
	
	public static void saveAll(ResourceSet reset) {
		
		Iterator<Resource> itAllResources = reset.getResources().iterator();

		while (itAllResources.hasNext()) {
				
			Resource resource = itAllResources.next();
			try {
					
				resource.save(null);
				resource.unload();
					
			} catch (IOException e) {
					
				e.printStackTrace();
			}			
		}		
	}

}


