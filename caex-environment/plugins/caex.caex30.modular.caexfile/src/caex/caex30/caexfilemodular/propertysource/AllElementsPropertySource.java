package caex.caex30.caexfilemodular.propertysource;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import caex.caex30.caexfilemodular.XMI_File;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;


import caex.caex30.caex.InterfaceClassLib;
import caex.caex30.caex.InterfaceFamily;
import caex.caex30.caex.RoleClassLib;
import caex.caex30.caex.SystemUnitClassLib;
import caex.caex30.caex.InstanceHierarchy;
import caex.caex30.caex.InterfaceClass;
import caex.caex30.caex.ExternalInterface;
import caex.caex30.caex.RoleClass;
import caex.caex30.caex.SystemUnitClass;
import caex.caex30.caex.InternalElement;
import caex.caex30.caex.SystemUnitFamily;



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
						return new CAEXFileItemPropertiesSource(new XMI_File(fileURI));
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
				if(root instanceof InterfaceClassLib){	
					try {
						return new InterfaceClassLibItemPropertiesSource(folder_file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(root instanceof InterfaceFamily){	
					try {
						return new InterfaceFamilyItemPropertiesSource(folder_file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(root instanceof RoleClassLib){	
					try {
						return new RoleClassLibItemPropertiesSource(folder_file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(root instanceof SystemUnitClassLib){	
					try {
						return new SystemUnitClassLibItemPropertiesSource(folder_file);
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
				if(root instanceof InstanceHierarchy){	
				try {
					return new InstanceHierarchyItemPropertiesSource(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if(root instanceof InterfaceClass){	
				try {
					return new InterfaceClassItemPropertiesSource(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if(root instanceof ExternalInterface){	
				try {
					return new ExternalInterfaceItemPropertiesSource(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if(root instanceof RoleClass){	
				try {
					return new RoleClassItemPropertiesSource(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if(root instanceof SystemUnitClass){	
				try {
					return new SystemUnitClassItemPropertiesSource(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if(root instanceof InternalElement){	
				try {
					return new InternalElementItemPropertiesSource(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if(root instanceof SystemUnitFamily){	
				try {
					return new SystemUnitFamilyItemPropertiesSource(file);
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
	
	public static String Project_Nature = "caex.caex30.modular.caexfile.ModularNature";

}

