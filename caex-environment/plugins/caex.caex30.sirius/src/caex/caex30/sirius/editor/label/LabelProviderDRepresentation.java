package caex.caex30.sirius.editor.label;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.graphics.Image;

public class LabelProviderDRepresentation implements ILabelProvider{

	@Override
	public void addListener(ILabelProviderListener listener) {
		// Do nothing		
	}

	@Override
	public void dispose() {
		// Do nothing		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// Do nothing
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// Do nothing		
	}

	@Override
	public Image getImage(Object element) {
		// Do nothing
		return null;
	}

	@Override
	public String getText(Object element) {
		
		if(element instanceof Viewpoint)
			return ((Viewpoint) element).getName();
		else
			return null;		
	}
}

