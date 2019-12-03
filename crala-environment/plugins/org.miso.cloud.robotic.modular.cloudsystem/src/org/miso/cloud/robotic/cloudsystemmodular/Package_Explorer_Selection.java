package org.miso.cloud.robotic.cloudsystemmodular;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

import org.miso.cloud.robotic.cloudsystemmodular.propertysource.*;


public class Package_Explorer_Selection extends ViewerFilter {
	
	public Package_Explorer_Selection() {
		
		IViewPart view_proper = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.jdt.ui.PackageExplorer");
		
		view_proper.getViewSite().getSelectionProvider().addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				
				ISelection selection = event.getSelection();
				
				if(selection instanceof TreeSelection){
					
					TreeSelection element = (TreeSelection)selection;
					Object object = element.getFirstElement();
					
					if(object instanceof IResource){
						
						IProject project = ((IResource) object).getProject();
						if(AllElementsPropertySource.isProject(project))
							addElementsPropertySource();							
					} 				
				}					
			}
		});		
	}

	private void addElementsPropertySource() {
	
		IViewPart view_proper = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.ui.views.PropertySheet");
		if(view_proper == null){
			try {
				view_proper = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.ui.views.PropertySheet");

			} catch (PartInitException e) {
				
				e.printStackTrace();
			}
						
		}

		try	{
			PropertySheet sheet_proper = (PropertySheet)view_proper;
			PropertySheetPage curr = (PropertySheetPage)sheet_proper.getCurrentPage();
			
			curr.setPropertySourceProvider(new AllElementsPropertySource());
			curr.refresh();

		} catch(Exception e) {}		
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		
		if(element instanceof IFile){
			IFile file = (IFile)element;
			if(AllElementsPropertySource.isProject(file.getProject())) {
								
				return Parent_Filter_XMI(file);
			}
			else
				return true;
		}		
		return true;
	}	
	
	public boolean Parent_Filter_XMI(IFile fil){
		
		String strIndex = fil.getFileExtension();
		if (strIndex.equals("xmi") && fil.getParent() instanceof IProject && fil.getParent().getName().equals(fil.getFullPath().removeFileExtension().lastSegment())) 
			return false;
		try {
			Integer index = Integer.parseInt(strIndex);
			if (index >= 1 && index <= 1)
		       return false;
	    }
	    catch( Exception e ) {
	        return true;
	    }	
			
		return true;		
	}

}

