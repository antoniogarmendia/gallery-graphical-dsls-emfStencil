package org.miso.cloud.robotic.cloudsystemmodular.decorator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.miso.cloud.robotic.cloudsystemmodular.wizard.CloudSystemNewProjectNature;
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
	
	private static final ImageDescriptor PACKAGE_Configuration;  
	static {  
	 	PACKAGE_Configuration = AbstractUIPlugin.imageDescriptorFromPlugin("org.miso.cloud.robotic.modular.cloudsystem", "icons/configuration.png");
	}  	
	
	
	@Override
	public void decorate(Object element, IDecoration decoration) {
		
		if(element instanceof IFolder)
		{
			try{
				IFolder folder = (IFolder)element;
				IProjectNature nature = folder.getProject().getNature(CloudSystemNewProjectNature.ID);
				if(nature != null){
					//Search XMI
					for (int i = 1; i <= 1; i++) {
						IFile file = folder.getFile(folder.getName().concat("." + i));
						if (file.exists() == true) {
							if (i == 1)
								decoration.addOverlay(PACKAGE_Configuration, IDecoration.BOTTOM_LEFT);
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
