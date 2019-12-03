package org.miso.cloud.robotic.cloudsystemmodular;

import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

public class OpenWithMenu extends ExtensionContributionFactory {

	
	private static final String IModularHandler = "org.mondo.generate.modular.project.OpenWithExtension";
	
	public OpenWithMenu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		// TODO Auto-generated method stub
		MenuManager menu = new MenuManager();
		menu.setMenuText("Open With");
		
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(IModularHandler);
		
		for (IConfigurationElement iConfigurationElement : config) {

			CommandContributionItemParameter pcommand = new CommandContributionItemParameter(serviceLocator,
					"", iConfigurationElement.getAttribute("commandId"), CommandContributionItem.STYLE_PUSH);
						pcommand.parameters = new HashMap<String,String>();
												
						CommandContributionItem itemsubsystems = new CommandContributionItem(pcommand);
						menu.add(itemsubsystems);
		}		
		
		additions.addContributionItem(menu, null);
		
	}

}

