package caex.caex30.caexfilemodular.propertysource;

import java.io.File;
import java.io.IOException;

import caex.caex30.caexfilemodular.XMI_File;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.ui.IPackagesViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import caex.caex30.caex.SystemUnitClass;

public class SystemUnitClassItemPropertiesSource implements IPropertySource { 
	
	private XMI_File property_file;

	public SystemUnitClassItemPropertiesSource(XMI_File property_file) throws IOException{
		this.property_file = property_file;		
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		
		if(id.equals("changeMode"))
			try {
				((SystemUnitClass)property_file.Get_Root()).
				eSet(((SystemUnitClass)property_file.Get_Root()).eClass().getEStructuralFeature("changeMode"),
					value.toString());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
		else
		if(id.equals("iD"))
			try {
				((SystemUnitClass)property_file.Get_Root()).
				eSet(((SystemUnitClass)property_file.Get_Root()).eClass().getEStructuralFeature("iD"),
					value.toString());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
		else
		if(id.equals("name"))
			try {
				((SystemUnitClass)property_file.Get_Root()).
				eSet(((SystemUnitClass)property_file.Get_Root()).eClass().getEStructuralFeature("name"),
					value.toString());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
		else
		if(id.equals("refBaseClassPath"))
			try {
				((SystemUnitClass)property_file.Get_Root()).
				eSet(((SystemUnitClass)property_file.Get_Root()).eClass().getEStructuralFeature("refBaseClassPath"),
					value.toString());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
		try {
			property_file.Save_XMI();			
				//Rename the file
				if(id.equals("name")){
				Path xmiPath = new Path(CommonPlugin.resolve(property_file.getFileURI()).toFileString());
				IPath newxmiPath = xmiPath.removeLastSegments(1).append(value.toString()).addFileExtension(xmiPath.getFileExtension());
				File src = new File(xmiPath.toFile().getPath());	
				File trg = new File(newxmiPath.toFile().getPath());
				src.renameTo(trg);
				
				//Change File
				property_file = new XMI_File(URI.createPlatformResourceURI(newxmiPath.makeRelativeTo(ResourcesPlugin.getWorkspace().getRoot().getLocation()).toString(),true));
				property_file.setRoot(null);
				
				//Refresh folder
				IFolder fol = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(trg.getParent()));				
				try {
					fol.getProject().refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Refresh Package Explorer
				final IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.jdt.ui.PackageExplorer");
				if (activePart != null && activePart instanceof IPackagesViewPart) {
					
				    ((IPackagesViewPart) activePart).selectAndReveal(trg);
				    ((IPackagesViewPart) activePart).getTreeViewer().refresh();				   
				}
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	@Override
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isPropertySet(Object id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Object getPropertyValue(Object id) {
		// TODO Auto-generated method stub
		Object strObject = null;
		if(id.equals("changeMode"))
			try {
				strObject = ((SystemUnitClass)property_file.Get_Root()).eGet(((SystemUnitClass)property_file.Get_Root()).eClass().getEStructuralFeature("changeMode"));
				//getChangeMode().toString();				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
		
		else
		if(id.equals("iD"))
			try {
				strObject = ((SystemUnitClass)property_file.Get_Root()).eGet(((SystemUnitClass)property_file.Get_Root()).eClass().getEStructuralFeature("iD"));
				//getID().toString();				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
		
		else
		if(id.equals("name"))
			try {
				strObject = ((SystemUnitClass)property_file.Get_Root()).eGet(((SystemUnitClass)property_file.Get_Root()).eClass().getEStructuralFeature("name"));
				//getName().toString();				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
		
		else
		if(id.equals("refBaseClassPath"))
			try {
				strObject = ((SystemUnitClass)property_file.Get_Root()).eGet(((SystemUnitClass)property_file.Get_Root()).eClass().getEStructuralFeature("refBaseClassPath"));
				//getRefBaseClassPath().toString();				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
		
		if(strObject!=null)
			return strObject.toString();
		return "";
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		// TODO Auto-generated method stub

		TextPropertyDescriptor attr_changeMode = new TextPropertyDescriptor("changeMode", "changeMode");
		attr_changeMode.setCategory("Attributes");
		TextPropertyDescriptor attr_iD = new TextPropertyDescriptor("iD", "iD");
		attr_iD.setCategory("Attributes");
		TextPropertyDescriptor attr_name = new TextPropertyDescriptor("name", "name");
		attr_name.setCategory("Attributes");
		TextPropertyDescriptor attr_refBaseClassPath = new TextPropertyDescriptor("refBaseClassPath", "refBaseClassPath");
		attr_refBaseClassPath.setCategory("Attributes");
		return new IPropertyDescriptor[]{
				attr_changeMode
				,				
				attr_iD
				,				
				attr_name
				,				
				attr_refBaseClassPath
								
		};
	}
	
	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}
		
	}

