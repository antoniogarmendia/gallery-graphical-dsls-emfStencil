package caex.caex30.caexfilemodular.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.osgi.service.prefs.BackingStoreException;
import java.io.IOException;
import caex.caex30.caexfilemodular.ModularModel;
import caex.caex30.caexfilemodular.ext.EvaluateModularListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;

public class CAEXFileNewProjectWizard extends Wizard implements INewWizard {

	protected CAEXFileNewProjectCreationPage mainpage;
	protected CAEXFileNewProjectInfo projectInfo;
	 
	
	/**
     * Use this method to add pages to the wizard.
     * The one-time generated version of this class will add a default new project page to the wizard.
     */
	public void addPages() {
		
		mainpage = new  CAEXFileNewProjectCreationPage("basicNewProjectPage");
		mainpage.setTitle("CAEXFile Project");
		mainpage.setDescription("Create a new CAEXFile project");
		addPage(mainpage);
	}	
	
	public CAEXFileNewProjectWizard() {
		
		setWindowTitle("New CAEXFile Project");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
		
	}

	public IWizardPage getNextPage(IWizardPage page) {
		return mainpage;		
	}
	
	@Override
	public boolean performFinish() {
		
		projectInfo = new CAEXFileNewProjectInfo(mainpage.getRoot());
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
		
		//new EvaluateModularListener().executeProject(Platform.getExtensionRegistry(),"PPU_reverse");
	}

}

