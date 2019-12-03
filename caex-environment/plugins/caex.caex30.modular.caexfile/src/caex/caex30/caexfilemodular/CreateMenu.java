package caex.caex30.caexfilemodular;

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

import caex.caex30.caexfilemodular.wizard.CAEXFileNewProjectNature;

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
						IProjectNature nature = pro.getNature(CAEXFileNewProjectNature.ID);
						if(nature==null)
							return;
						
						nature = pro.getNature("caex.caex30.modular.generalmodularnature");
						if(nature != null)
							return;
					} else
						return;				
					
				} catch (CoreException e) {
					
					e.printStackTrace();
				}
	
				MenuManager menu = new MenuManager();
				menu.setMenuText("New CAEXFile");			
				if(firstelement instanceof IProject)
				{
					CommandContributionItemParameter pcommand = new CommandContributionItemParameter(serviceLocator,
				"", "org.eclipse.ui.newWizard", CommandContributionItem.STYLE_PUSH);
					pcommand.parameters = new HashMap<String,String>();

	
					pcommand.parameters.put("newWizardId", "caex.caex30.instancehierarchy.instancehierarchyNewFile");
					CommandContributionItem iteminstanceHierarchyUnit = new CommandContributionItem(pcommand);
					menu.add(iteminstanceHierarchyUnit);
						
	
					pcommand.parameters.put("newWizardId", "caex.caex30.interfaceclasslib.interfaceclasslibNewPackage");
					CommandContributionItem iteminterfaceClassLib = new CommandContributionItem(pcommand);
					menu.add(iteminterfaceClassLib);
						
	
					pcommand.parameters.put("newWizardId", "caex.caex30.roleclasslib.roleclasslibNewPackage");
					CommandContributionItem itemroleClassLib = new CommandContributionItem(pcommand);
					menu.add(itemroleClassLib);
						
	
					pcommand.parameters.put("newWizardId", "caex.caex30.systemunitclasslib.systemunitclasslibNewPackage");
					CommandContributionItem itemsystemUnitClassLib = new CommandContributionItem(pcommand);
					menu.add(itemsystemUnitClassLib);
						
				}
				else if(firstelement instanceof IFolder)
				{
					
					IFolder folder = (IFolder)firstelement;
					int index = -1;
					for (int i = 1; i <= 4; i++) { 

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
								pcommand.parameters.put("newWizardId", "caex.caex30.interfaceclass.interfaceclassNewFile");
								CommandContributionItem iteminterfaceClassUnit = new CommandContributionItem(pcommand);
								menu.add(iteminterfaceClassUnit);
								//InterfaceClass								
							pcommand.parameters.put("newWizardId", "caex.caex30.interfacefamily.interfacefamilyNewPackage");
							CommandContributionItem itemInterfaceFamilyPackage = new CommandContributionItem(pcommand);
							menu.add(itemInterfaceFamilyPackage);
								//InterfaceClass								
							pcommand.parameters.put("newWizardId", "caex.caex30.externalinterface.externalinterfaceNewFile");
							CommandContributionItem itemExternalInterfaceFile = new CommandContributionItem(pcommand);
							menu.add(itemExternalInterfaceFile);
							
						}
						
						if(index == 2) {

							CommandContributionItemParameter pcommand = new CommandContributionItemParameter(serviceLocator,
							"", "org.eclipse.ui.newWizard", CommandContributionItem.STYLE_PUSH);
							pcommand.parameters = new HashMap<String,String>();
								pcommand.parameters.put("newWizardId", "caex.caex30.interfaceclass.interfaceclassNewFile");
								CommandContributionItem iteminterfaceClassUnit = new CommandContributionItem(pcommand);
								menu.add(iteminterfaceClassUnit);
								//InterfaceClass								
							pcommand.parameters.put("newWizardId", "caex.caex30.interfacefamily.interfacefamilyNewPackage");
							CommandContributionItem itemInterfaceFamilyPackage = new CommandContributionItem(pcommand);
							menu.add(itemInterfaceFamilyPackage);
								//InterfaceClass								
							pcommand.parameters.put("newWizardId", "caex.caex30.externalinterface.externalinterfaceNewFile");
							CommandContributionItem itemExternalInterfaceFile = new CommandContributionItem(pcommand);
							menu.add(itemExternalInterfaceFile);
							
						}
						
						if(index == 3) {

							CommandContributionItemParameter pcommand = new CommandContributionItemParameter(serviceLocator,
							"", "org.eclipse.ui.newWizard", CommandContributionItem.STYLE_PUSH);
							pcommand.parameters = new HashMap<String,String>();
								pcommand.parameters.put("newWizardId", "caex.caex30.roleclass.roleclassNewFile");
								CommandContributionItem itemroleClassUnit = new CommandContributionItem(pcommand);
								menu.add(itemroleClassUnit);
							
						}
						
						if(index == 4) {

							CommandContributionItemParameter pcommand = new CommandContributionItemParameter(serviceLocator,
							"", "org.eclipse.ui.newWizard", CommandContributionItem.STYLE_PUSH);
							pcommand.parameters = new HashMap<String,String>();
								pcommand.parameters.put("newWizardId", "caex.caex30.systemunitclass.systemunitclassNewFile");
								CommandContributionItem itemsystemUnitClassUnit = new CommandContributionItem(pcommand);
								menu.add(itemsystemUnitClassUnit);
								//SystemUnitClass								
							pcommand.parameters.put("newWizardId", "caex.caex30.internalelement.internalelementNewFile");
							CommandContributionItem itemInternalElementFile = new CommandContributionItem(pcommand);
							menu.add(itemInternalElementFile);
								//SystemUnitClass								
							pcommand.parameters.put("newWizardId", "caex.caex30.systemunitfamily.systemunitfamilyNewFile");
							CommandContributionItem itemSystemUnitFamilyFile = new CommandContributionItem(pcommand);
							menu.add(itemSystemUnitFamilyFile);
							
						}
						
					}								
				}
				additions.addContributionItem(menu, null);
			}
		}
	}				
}

