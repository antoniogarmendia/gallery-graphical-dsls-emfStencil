package caex.caex30.sirius.editor.dialog;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

public class ViewpointRepresentationDialog extends Dialog {

	private Set<Viewpoint> selectedViewpoints;
	private TreeViewer viewer;
	private Viewpoint selectedViewpoint;
	private RepresentationDescription selectedDescriptor;
	
	public ViewpointRepresentationDialog(Shell parentShell, Set<Viewpoint> selectedViewpoints) {
		super(parentShell);		
		this.selectedViewpoints = selectedViewpoints;
		this.viewer = null;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		
		Composite container = (Composite) super.createDialogArea(parent);	
		
		viewer = new TreeViewer(container);		
		viewer.setContentProvider(new ViewPointContentProvider());
        viewer.getTree().setHeaderVisible(false);
        viewer.getTree().setLinesVisible(false);
		
        TreeViewerColumn viewerColumn = new TreeViewerColumn(viewer, SWT.NONE);
        viewerColumn.getColumn().setWidth(300);
        viewerColumn.setLabelProvider(new ViewPointLabelProvider());
        
        viewer.setInput(selectedViewpoints.toArray());
		        
        GridLayoutFactory.fillDefaults().generateLayout(container);
        
        viewer.expandToLevel(2);
        
        return container;
	}
	
	 @Override
	    protected void configureShell(Shell newShell) {
	        super.configureShell(newShell);
	        newShell.setText("Select Representation within Viewpoints");
	}
	 
	 
	@Override
	protected void okPressed() {
		
		ISelection selection = viewer.getSelection();
		if (selection instanceof TreeSelection) {
			
			TreeSelection treeSelection = (TreeSelection) selection;
			Object object = treeSelection.getFirstElement();
			if (object instanceof RepresentationDescription) {
				this.selectedDescriptor = (RepresentationDescription) object;
				EObject eObject = this.selectedDescriptor.eContainer();
				if (eObject instanceof Viewpoint)
					this.selectedViewpoint = (Viewpoint) eObject;
				
				super.okPressed();
			} else {
				MessageDialog dialog = new MessageDialog(getShell(), "Error", null,
					    "You must select the RepresentationDescription within the Viewpoint", MessageDialog.ERROR, new String[] { "OK" }, 0);
				dialog.open();
			}			
		}			
	} 
	
	public Viewpoint getSelectedViewPoint() {		
		return this.selectedViewpoint;	
	}
	
	public RepresentationDescription getRepresentationDescriptor() {
		return this.selectedDescriptor;
	}
	
	@Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }	
}
