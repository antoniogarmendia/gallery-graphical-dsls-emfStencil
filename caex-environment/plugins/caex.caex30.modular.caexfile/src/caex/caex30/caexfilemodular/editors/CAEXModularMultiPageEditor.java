package caex.caex30.caexfilemodular.editors;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.mondo.modular.filterui.ext.EvaluateFilterUIContributor;
import org.mondo.modular.filterui.ext.FilterAttribute;
import org.mondo.modular.filterui.ext.IFilterTabItem;

import caex.caex30.caex.presentation.CAEXEditor;

public class CAEXModularMultiPageEditor extends CAEXEditor implements IFilterTabItem{

	@Override
	public void createPages() {
		
		super.createPages();
		
		if (!getEditingDomain().getResourceSet().getResources().isEmpty())
		// Create a page for the Filter view.
		{
			FilterAttribute anFilterAttribute = new FilterAttribute(getSite().getPage(),
												CAEXModularMultiPageEditor.this, getSite().getShell().getDisplay(),
												selectionViewer,editingDomain.getResourceSet().getResources().get(0),
												getContainer());			
			new EvaluateFilterUIContributor().execute(Platform.getExtensionRegistry(),anFilterAttribute);			
		}	
	}

	@Override
	public int AddItemPage(Control control) {
		
		return addPage(control);		
	}

	@Override
	public void SetPageItemText(int pageCount, String name) {
		
		setPageText(pageCount, name);
	}

	@Override
	public IPropertySheetPage getPropertySheetPage() {
		
		PropertySheetPage propertySheetPage =
				new ExtendedPropertySheetPage(editingDomain) {					

					@Override
					public void setSelectionToViewer(List<?> selection) {
						setSelectionToViewer(selection);
						setFocus();
						
					}

					@Override
					public void setActionBars(IActionBars actionBars) {
						super.setActionBars(actionBars);
						getActionBarContributor().shareGlobalActions(this, actionBars);
					}					
				};

		propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory) {

			@Override
			protected IPropertySource createPropertySource(final Object object, final IItemPropertySource itemPropertySource) {
				
				IItemPropertySource wrappedSource = new IItemPropertySource() {					
					
					@Override
					public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
						
						return itemPropertySource.getPropertyDescriptors(object);
					}
					
					@Override
					public IItemPropertyDescriptor getPropertyDescriptor(Object object, Object propertyID) {
						
						IItemPropertyDescriptor item = itemPropertySource.getPropertyDescriptor(object, propertyID);
						return item;					
					}					
					
					@Override
					public Object getEditableValue(Object object) {
						
						return itemPropertySource.getEditableValue(object);
					}				
				};
								
				return new ModularPropertySource(object, wrappedSource);
			}
			
		});
		
		propertySheetPages.add(propertySheetPage);		

		return propertySheetPage;
	}
	
}
