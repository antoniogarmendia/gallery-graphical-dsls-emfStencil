package org.miso.cloud.robotic.cloudsystemmodular.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.osgi.service.prefs.BackingStoreException;
import java.io.IOException;
import org.miso.cloud.robotic.cloudsystemmodular.ModularModel;
import org.miso.cloud.robotic.cloudsystemmodular.ext.EvaluateModularListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;

public class CloudSystemNewProjectWizard extends Wizard implements INewWizard {

	protected CloudSystemNewProjectCreationPage mainpage;
	protected CloudSystemNewProjectInfo projectInfo;
	 
	
	/**
     * Use this method to add pages to the wizard.
     * The one-time generated version of this class will add a default new project page to the wizard.
     */
	public void addPages() {
		
		mainpage = new  CloudSystemNewProjectCreationPage("basicNewProjectPage");
		mainpage.setTitle("CloudSystem Project");
		mainpage.setDescription("Create a new CloudSystem project");
		addPage(mainpage);
	}	
	
	public CloudSystemNewProjectWizard() {
		
		setWindowTitle("New CloudSystem Project");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
		
	}

	public IWizardPage getNextPage(IWizardPage page) {
		return mainpage;		
	}
	
	@Override
	public boolean performFinish() {
		
		projectInfo = new CloudSystemNewProjectInfo(mainpage.getRoot());
		String addr = mainpage.getDiagram_address();
		if(addr!=null)
		{
			URI addrURI = URI.createFileURI(addr);
			if(addrURI.isFile()){
				ModularModel createProject = new ModularModel();
				try {
					createProject.Reverse_Engineering(addrURI);

				} catch (IOException | CoreException | BackingStoreException e) {
					
					e.printStackTrace();
				}
			}
			else
			{
				MessageDialog.openInformation(
						getShell(),
						"Error!",
						"The file address is not valid.");
			}	
			
		}
		else{
		
			try {
				projectInfo.createProject();	
			
			} catch (CoreException | BackingStoreException | IOException e) {				
				e.printStackTrace();
			}	
		}

		evaluateSiriusProjectCreation();
		return true;
	}	
	
	public void evaluateSiriusProjectCreation() {
		
		new EvaluateModularListener().executeProject(Platform.getExtensionRegistry(),projectInfo.getProject().getName());
	}

}

