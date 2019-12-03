package org.miso.cloud.robotic.cloudsystemmodular.editors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class ModularPropertySource extends PropertySource{

	public ModularPropertySource(Object object, IItemPropertySource itemPropertySource) {

		super(object, itemPropertySource);		
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		
		Collection<IPropertyDescriptor> result = new ArrayList<IPropertyDescriptor>();
	    List<IItemPropertyDescriptor> itemPropertyDescriptors = itemPropertySource.getPropertyDescriptors(object);
	    if (itemPropertyDescriptors != null)
	    {
	      for (IItemPropertyDescriptor itemPropertyDescriptor : itemPropertyDescriptors)
	      {
	    	result.add(createCustomPropertyDescriptor(itemPropertyDescriptor));	    	
	      }
	    }

	    return result.toArray(new IPropertyDescriptor [result.size()]);
	}

	public IPropertyDescriptor createCustomPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
		// TODO Auto-generated method stub
		return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
	}

}

