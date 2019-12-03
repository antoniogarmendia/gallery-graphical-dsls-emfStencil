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

import caex.caex30.caex.CAEXFile;

public class CAEXFileItemPropertiesSource implements IPropertySource { 
	
	private XMI_File property_file;

	public CAEXFileItemPropertiesSource(XMI_File property_file) throws IOException{
		this.property_file = property_file;		
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		
		if(id.equals("changeMode"))
			try {
				((CAEXFile)property_file.Get_Root()).
				eSet(((CAEXFile)property_file.Get_Root()).eClass().getEStructuralFeature("changeMode"),
					value.toString());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
		else
		if(id.equals("superiorStandardVersion"))
			try {
				((CAEXFile)property_file.Get_Root()).
				eSet(((CAEXFile)property_file.Get_Root()).eClass().getEStructuralFeature("superiorStandardVersion"),
					value.toString());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
		else
		if(id.equals("fileName"))
			try {
				((CAEXFile)property_file.Get_Root()).
				eSet(((CAEXFile)property_file.Get_Root()).eClass().getEStructuralFeature("fileName"),
					value.toString());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
		else
		if(id.equals("schemaVersion"))
			try {
				((CAEXFile)property_file.Get_Root()).
				eSet(((CAEXFile)property_file.Get_Root()).eClass().getEStructuralFeature("schemaVersion"),
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
				strObject = ((CAEXFile)property_file.Get_Root()).eGet(((CAEXFile)property_file.Get_Root()).eClass().getEStructuralFeature("changeMode"));
				//getChangeMode().toString();				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
		
		else
		if(id.equals("superiorStandardVersion"))
			try {
				strObject = ((CAEXFile)property_file.Get_Root()).eGet(((CAEXFile)property_file.Get_Root()).eClass().getEStructuralFeature("superiorStandardVersion"));
				//getSuperiorStandardVersion().toString();				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
		
		else
		if(id.equals("fileName"))
			try {
				strObject = ((CAEXFile)property_file.Get_Root()).eGet(((CAEXFile)property_file.Get_Root()).eClass().getEStructuralFeature("fileName"));
				//getFileName().toString();				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}		
		
		else
		if(id.equals("schemaVersion"))
			try {
				strObject = ((CAEXFile)property_file.Get_Root()).eGet(((CAEXFile)property_file.Get_Root()).eClass().getEStructuralFeature("schemaVersion"));
				//getSchemaVersion().toString();				
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
		TextPropertyDescriptor attr_superiorStandardVersion = new TextPropertyDescriptor("superiorStandardVersion", "superiorStandardVersion");
		attr_superiorStandardVersion.setCategory("Attributes");
		TextPropertyDescriptor attr_fileName = new TextPropertyDescriptor("fileName", "fileName");
		attr_fileName.setCategory("Attributes");
		TextPropertyDescriptor attr_schemaVersion = new TextPropertyDescriptor("schemaVersion", "schemaVersion");
		attr_schemaVersion.setCategory("Attributes");
		return new IPropertyDescriptor[]{
				attr_changeMode
				,				
				attr_superiorStandardVersion
				,				
				attr_fileName
				,				
				attr_schemaVersion
								
		};
	}
	
	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}
		
	}

