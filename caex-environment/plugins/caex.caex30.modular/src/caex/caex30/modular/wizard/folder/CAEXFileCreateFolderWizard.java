package caex.caex30.modular.wizard.folder;	

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbench;
import caex.caex30.caexfilemodular.wizard.CAEXFileNewProjectWizard;
import caex.caex30.caexfilemodular.ModularModel;
import caex.caex30.caexfilemodular.wizard.CAEXFileNewProjectInfo;

public class CAEXFileCreateFolderWizard extends CAEXFileNewProjectWizard {

	public IProject project;

	public CAEXFileCreateFolderWizard() {
		super();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		
		// obtain current project selection
		TreeSelection treeselection = (TreeSelection)selection;
		Object firstelement = treeselection.getFirstElement();
		if(firstelement instanceof IProject)
			this.project = (IProject) firstelement;
	}

	@Override
	public boolean performFinish() {
		
		projectInfo = new CAEXFileNewProjectInfo(mainpage.getRoot());
		String addr = mainpage.getDiagram_address();
		if(addr != null) {
			
			URI addrURI = URI.createFileURI(addr);
			if(addrURI.isFile()){
				
				ModularModel createProject = new ModularModel();
				createProject.reverseEngineeringContainer(addrURI,project);				
			}
			
		} else {
			projectInfo.setProject(project);
			projectInfo.createFolder();
		}
		
		evaluateSiriusProjectCreation();
		return true;
	}

}

