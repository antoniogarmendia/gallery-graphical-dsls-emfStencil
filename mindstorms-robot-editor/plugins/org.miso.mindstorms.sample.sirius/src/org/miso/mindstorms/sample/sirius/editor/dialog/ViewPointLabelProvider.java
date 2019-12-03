package org.miso.mindstorms.sample.sirius.editor.dialog;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

public class ViewPointLabelProvider extends ColumnLabelProvider {

	@Override
	public String getText(Object element) {
		
		if(element instanceof Viewpoint)
			return ((Viewpoint) element).getName();	
		
		if(element instanceof RepresentationDescription)
			return ((RepresentationDescription) element).getLabel();
		
		return super.getText(element);
	}
}

