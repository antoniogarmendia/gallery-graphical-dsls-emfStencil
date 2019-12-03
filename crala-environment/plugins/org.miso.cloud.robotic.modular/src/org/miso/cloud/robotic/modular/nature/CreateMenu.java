package org.miso.cloud.robotic.modular.nature;

import java.util.HashMap;

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

public class CreateMenu extends ExtensionContributionFactory {

	public CreateMenu() {
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		
		ISelectionService serv = (ISelectionService) serviceLocator.getService(ISelectionService.class);
		ISelection selection = serv.getSelection();
		if (selection instanceof TreeSelection) {

			TreeSelection treeselection = (TreeSelection)selection;
			Object firstelement = treeselection.getFirstElement();
				
			if(firstelement instanceof IProject){
		
				IProject pro = null;
				if(firstelement instanceof IProject)
					pro = (IProject)firstelement;	
				if(firstelement instanceof IFolder)
					pro = ((IFolder)firstelement).getProject();			
				try {
					if (pro.isOpen() == true)
					{
						IProjectNature nature = pro.getNature(GeneralProjectNature.ID);
						if(nature==null)
							return;
					} else 
						return;
				} catch (CoreException e) {
					
					e.printStackTrace();
				}
	
				MenuManager menu = new MenuManager();
				menu.setMenuText("New General Modular Project");
	
				{
						CommandContributionItemParameter pcommand = new CommandContributionItemParameter(serviceLocator,
															"", "org.eclipse.ui.newWizard", CommandContributionItem.STYLE_PUSH);
															pcommand.parameters = new HashMap<String,String>();
								
		
						pcommand.parameters.put("newWizardId", "org.miso.cloud.robotic.cloudsystem.general.cloudsystemNewPackage");
						CommandContributionItem item = new CommandContributionItem(pcommand);
						menu.add(item);
				}			
	
				additions.addContributionItem(menu, null);			
			}
		}			
	}

}

