package org.miso.cloud.robotic.cloudsystemmodular;

import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

import org.miso.cloud.robotic.cloudsystemmodular.wizard.CloudSystemNewProjectNature;

public class CreateMenu extends ExtensionContributionFactory {

	public CreateMenu() {	
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator,
			IContributionRoot additions) {
		
		ISelectionService serv = (ISelectionService) serviceLocator.getService(ISelectionService.class);
		ISelection selection = serv.getSelection();
		if (selection instanceof TreeSelection) {

			TreeSelection treeselection = (TreeSelection)selection;
			Object firstelement = treeselection.getFirstElement();
				
			if(firstelement instanceof IProject || firstelement instanceof IFolder){
				IProject pro = null;
				if(firstelement instanceof IProject)
					pro = (IProject)firstelement;	
				if(firstelement instanceof IFolder)
					pro = ((IFolder)firstelement).getProject();			
				try {
					
					if (pro.isOpen() == true) {
						IProjectNature nature = pro.getNature(CloudSystemNewProjectNature.ID);
						if(nature==null)
							return;
						
						nature = pro.getNature("org.miso.cloud.robotic.modular.generalmodularnature");
						if(nature != null)
							return;
					} else
						return;				
					
				} catch (CoreException e) {
					
					e.printStackTrace();
				}
	
				MenuManager menu = new MenuManager();
				menu.setMenuText("New CloudSystem");			
				if(firstelement instanceof IProject)
				{
					CommandContributionItemParameter pcommand = new CommandContributionItemParameter(serviceLocator,
				"", "org.eclipse.ui.newWizard", CommandContributionItem.STYLE_PUSH);
					pcommand.parameters = new HashMap<String,String>();

	
					pcommand.parameters.put("newWizardId", "org.miso.cloud.robotic.architecturespecification.architecturespecificationNewFile");
					CommandContributionItem itemarqUnit = new CommandContributionItem(pcommand);
					menu.add(itemarqUnit);
						
	
					pcommand.parameters.put("newWizardId", "org.miso.cloud.robotic.configuration.configurationNewPackage");
					CommandContributionItem itemconfigs = new CommandContributionItem(pcommand);
					menu.add(itemconfigs);
						
				}
				else if(firstelement instanceof IFolder)
				{
					
					IFolder folder = (IFolder)firstelement;
					int index = -1;
					for (int i = 1; i <= 1; i++) { 

						IFile file = folder.getFile(folder.getName().concat("." + i));
						if (file.exists() == true) {
							index = i;
							break;
						}
					}
					
					if (index != -1) {

						if(index == 1) {

							CommandContributionItemParameter pcommand = new CommandContributionItemParameter(serviceLocator,
							"", "org.eclipse.ui.newWizard", CommandContributionItem.STYLE_PUSH);
							pcommand.parameters = new HashMap<String,String>();
							pcommand.parameters.put("newWizardId", "org.miso.cloud.robotic.configurationsystem.configurationsystemNewFile");
							CommandContributionItem itemconfigSystemsFile = new CommandContributionItem(pcommand);
							menu.add(itemconfigSystemsFile);
							
						}
						
					}								
				}
				additions.addContributionItem(menu, null);
			}
		}
	}				
}

