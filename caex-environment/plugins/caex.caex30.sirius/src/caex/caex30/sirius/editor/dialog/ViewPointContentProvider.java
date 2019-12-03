package caex.caex30.sirius.editor.dialog;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

public class ViewPointContentProvider implements ITreeContentProvider {
	
	@Override
    public boolean hasChildren(Object element) {
		
		if(element instanceof Viewpoint)
			return true;
        return false;
    }

    @Override
    public Object getParent(Object element) {
        return null;
    }

    @Override
    public Object[] getElements(Object inputElement) {
        return ArrayContentProvider.getInstance().getElements(inputElement);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
    	
    	if(parentElement instanceof Viewpoint) {
    		
    		Viewpoint viewPoint = (Viewpoint) parentElement;    		
    		return viewPoint.getOwnedRepresentations().toArray();    		
    	}
    		
        return null;
    }
}

