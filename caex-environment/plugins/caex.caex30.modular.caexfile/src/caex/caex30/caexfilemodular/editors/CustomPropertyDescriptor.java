package caex.caex30.caexfilemodular.editors;

import java.util.List;

import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import caex.caex30.caexfilemodular.Activator;
import caex.caex30.caexfilemodular.preferences.PreferenceOptions;

public class CustomPropertyDescriptor extends PropertyDescriptor{

	public CustomPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor) {
		
		super(object, itemPropertyDescriptor);		
	}

	@Override
	public CellEditor createPropertyEditor(Composite composite) {
		CellEditor result =  super.createPropertyEditor(composite);
		if(result instanceof ExtendedDialogCellEditor){
			
			String IdExtension = Activator.getDefault().getPreferenceStore().getString(PreferenceOptions.FeatureEditor_CHOICE);
			if(IdExtension.equals(PreferenceOptions.DefaultFeatureEditorDialog))
				return result;
			else {				
			Object genericFeature = itemPropertyDescriptor.getFeature(object);
			final EStructuralFeature feature = (EStructuralFeature)genericFeature;						
			return new ExtendedDialogCellEditor(composite, getEditLabelProvider()){

				@Override
				protected Object openDialogBox(Control cellEditorWindow) {
					ModularFeatureEditorDialog dialog = new ModularFeatureEditorDialog(
							cellEditorWindow.getShell(), 
							(EObject) object, 
							feature, IdExtension,
							getEditLabelProvider());
					
					dialog.open();
					return dialog.getResult();
					}			
				};				
			}
		}			
		else if (result instanceof ExtendedComboBoxCellEditor) {
			String IdExtension = Activator.getDefault().getPreferenceStore().getString(PreferenceOptions.FeatureEditor_CHOICE);
			if(IdExtension.equals(PreferenceOptions.DefaultFeatureEditorDialog))
				return result;
			else {
				Object genericFeature = itemPropertyDescriptor.getFeature(object);
				final EStructuralFeature feature = (EStructuralFeature)genericFeature;
				ModularPossibleValues modularPossible = new ModularPossibleValues(IdExtension, feature, (EObject) object);
				List<?> getChoicesOfValues = modularPossible.getChoicesofValues();		
				result = new ExtendedComboBoxCellEditor
			                (composite, getChoicesOfValues, getEditLabelProvider(), itemPropertyDescriptor.isSortChoices(object), SWT.READ_ONLY, null, true);
				return result;
			}
		} else
			return result;		
	}

}

