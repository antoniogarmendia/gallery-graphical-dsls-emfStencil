package caex.caex30.caexfilemodular.decorator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import caex.caex30.caexfilemodular.wizard.CAEXFileNewProjectNature;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ModularProjectDecorator implements ILightweightLabelDecorator {

	@Override
	public void addListener(ILabelProviderListener arg0) {
	
	}

	@Override
	public void dispose() {
	
	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {

		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	
	}
	
	private static final ImageDescriptor PACKAGE_InterfaceClassLib;  
	private static final ImageDescriptor PACKAGE_InterfaceFamily;  
	private static final ImageDescriptor PACKAGE_RoleClassLib;  
	private static final ImageDescriptor PACKAGE_SystemUnitClassLib;  
	static {  
	 	PACKAGE_InterfaceClassLib = AbstractUIPlugin.imageDescriptorFromPlugin("caex.caex30.modular.caexfile", "icons/InterfaceClassLib.gif");
	 	PACKAGE_InterfaceFamily = AbstractUIPlugin.imageDescriptorFromPlugin("caex.caex30.modular.caexfile", "icons/InterfaceFamily.gif");
	 	PACKAGE_RoleClassLib = AbstractUIPlugin.imageDescriptorFromPlugin("caex.caex30.modular.caexfile", "icons/RoleClassLib.gif");
	 	PACKAGE_SystemUnitClassLib = AbstractUIPlugin.imageDescriptorFromPlugin("caex.caex30.modular.caexfile", "icons/SystemUnitClassLib.gif");
	}  	
	
	
	@Override
	public void decorate(Object element, IDecoration decoration) {
		
		if(element instanceof IFolder)
		{
			try{
				IFolder folder = (IFolder)element;
				IProjectNature nature = folder.getProject().getNature(CAEXFileNewProjectNature.ID);
				if(nature != null){
					//Search XMI
					for (int i = 1; i <= 4; i++) {
						IFile file = folder.getFile(folder.getName().concat("." + i));
						if (file.exists() == true) {
							if (i == 1)
								decoration.addOverlay(PACKAGE_InterfaceClassLib, IDecoration.BOTTOM_LEFT);
							else if(i == 2)
								decoration.addOverlay(PACKAGE_InterfaceFamily, IDecoration.BOTTOM_LEFT);	
							else if(i == 3)
								decoration.addOverlay(PACKAGE_RoleClassLib, IDecoration.BOTTOM_LEFT);	
							else if(i == 4)
								decoration.addOverlay(PACKAGE_SystemUnitClassLib, IDecoration.BOTTOM_LEFT);	
							break;
						}					
					}										
				}
				
			}catch(Throwable th){
					//Ignore if file is not found 
			}
		}
		
	}
}
