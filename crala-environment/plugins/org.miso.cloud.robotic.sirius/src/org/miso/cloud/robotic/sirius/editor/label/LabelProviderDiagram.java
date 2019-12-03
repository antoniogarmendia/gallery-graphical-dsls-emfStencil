package org.miso.cloud.robotic.sirius.editor.label;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.swt.graphics.Image;

public class LabelProviderDiagram implements ILabelProvider{

	@Override
	public void addListener(ILabelProviderListener listener) {
		// Nothing to do		
	}

	@Override
	public void dispose() {
		// Nothing to do		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// Nothing to do
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// Nothing to do		
	}

	@Override
	public Image getImage(Object element) {
		// Nothing to do
		return null;
	}

	@Override
	public String getText(Object element) {
		
		if(element instanceof DRepresentation)
			return ((DRepresentation) element).getName();
		return null;
	}

}

