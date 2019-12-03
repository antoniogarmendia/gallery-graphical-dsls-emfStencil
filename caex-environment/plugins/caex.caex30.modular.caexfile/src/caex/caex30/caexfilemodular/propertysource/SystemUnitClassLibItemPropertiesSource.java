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

import caex.caex30.caex.SystemUnitClassLib;

public class SystemUnitClassLibItemPropertiesSource implements IPropertySource { 
	
	private XMI_File property_file;

	public SystemUnitClassLibItemPropertiesSource(XMI_File property_file) throws IOException{
		this.property_file = property_file;		
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		
		if(id.equals("changeMode"))
			try {
				((SystemUnitClassLib)property_file.Get_Root()).
				eSet(((SystemUnitClassLib)property_file.Get_Root()).eClass().getEStructuralFeature("changeMode"),
					value.toString());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
		else
		if(id.equals("iD"))
			try {
				((SystemUnitClassLib)property_file.Get_Root()).
				eSet(((SystemUnitClassLib)property_file.Get_Root()).eClass().getEStructuralFeature("iD"),
					value.toString());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
		else
		if(id.equals("name"))
			try {
				((SystemUnitClassLib)property_file.Get_Root()).
				eSet(((SystemUnitClassLib)property_file.Get_Root()).eClass().getEStructuralFeature("name"),
					value.toString());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
		try {
			property_file.Save_XMI();			
			
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
				strObject = ((SystemUnitClassLib)property_file.Get_Root()).eGet(((SystemUnitClassLib)property_file.Get_Root()).eClass().getEStructuralFeature("changeMode"));
				//getChangeMode().toString();				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
		
		else
		if(id.equals("iD"))
			try {
				strObject = ((SystemUnitClassLib)property_file.Get_Root()).eGet(((SystemUnitClassLib)property_file.Get_Root()).eClass().getEStructuralFeature("iD"));
				//getID().toString();				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
		
		else
		if(id.equals("name"))
			try {
				strObject = ((SystemUnitClassLib)property_file.Get_Root()).eGet(((SystemUnitClassLib)property_file.Get_Root()).eClass().getEStructuralFeature("name"));
				//getName().toString();				
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
		return new IPropertyDescriptor[]{
				attr_changeMode
				,				
				attr_iD
				,				
				attr_name
								
		};
	}
	
	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}
		
	}

