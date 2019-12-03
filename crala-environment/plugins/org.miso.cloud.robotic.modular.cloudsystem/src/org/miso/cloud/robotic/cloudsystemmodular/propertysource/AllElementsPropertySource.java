package org.miso.cloud.robotic.cloudsystemmodular.propertysource;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.miso.cloud.robotic.cloudsystemmodular.XMI_File;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;


import cloudRobotics.Configuration;
import cloudRobotics.ArchitectureSpecification;
import cloudRobotics.ConfigurationSystem;



public class AllElementsPropertySource implements IPropertySourceProvider {

	public AllElementsPropertySource() {
		
		super();		
	}

	@Override
	public IPropertySource getPropertySource(Object object) {
		
		URI fileURI = null;
		//Select a Project
		if(object instanceof IProject){
			IProject pro = (IProject)object;
			if(!isProject(pro))
				return null;
			//Get project address
			fileURI = URI.createPlatformResourceURI(((IProject)object).getFullPath().toString().concat("/"+((IProject)object).getFullPath().lastSegment().toString()).concat(".xmi"),true);
			IResource resource = pro.findMember(pro.getName()+".xmi");
			if(resource!=null){						
				try {
						return new CloudSystemItemPropertiesSource(new XMI_File(fileURI));
					} catch (IOException e) {
						e.printStackTrace();
					}
			}	
			else	
				return null;				
		}	
		//Select a Folder
		if(object instanceof IFolder){
			IFolder fol = (IFolder)object;
			//Get folder address
			if(!isProject(fol.getProject()))
				return null;
			fileURI = URI.createPlatformResourceURI(((IFolder)object).getFullPath().toString().concat("/"+fol.getName()+".xmi"),true);
			IResource resource = fol.findMember(fol.getName()+".xmi");
			if(resource!=null){
				XMI_File folder_file = new XMI_File(fileURI);
				EObject root = null;
				try {
					root = folder_file.Get_Root();
				} catch (IOException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//For with all folders
				if(root instanceof Configuration){	
					try {
						return new ConfigurationItemPropertiesSource(folder_file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
						
				}
				else 
					return null;
				}
		//Select a File
		if(object instanceof IFile){
			IFile fil = (IFile)object;
			//Get folder address
			if(!isProject(fil.getProject()))
				return null;
			fileURI = URI.createPlatformResourceURI(((IFile)object).getFullPath().toString(),true);
			if(fil.exists()){
				XMI_File file = new XMI_File(fileURI);
				EObject root = null;
				try {
					root = file.Get_Root();
				} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				//For with all folders
				if(root instanceof ArchitectureSpecification){	
				try {
					return new ArchitectureSpecificationItemPropertiesSource(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if(root instanceof ConfigurationSystem){	
				try {
					return new ConfigurationSystemItemPropertiesSource(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
					
			}
			else 
				return null;
			}

		return null;	
	}

	public static boolean isProject(IProject pro) 
	{
		if(pro.isOpen() == true) {
			IProjectNature modularNature = null;
			try {
				modularNature = pro.getNature(Project_Nature);
			} catch (CoreException e) {
				
				e.printStackTrace();
			}
	
			if(modularNature==null)
				return false;
			else
				return true;	
		}
		return false;	
	}
	
	public static String Project_Nature = "org.miso.cloud.robotic.modular.cloudsystem.ModularNature";

}

