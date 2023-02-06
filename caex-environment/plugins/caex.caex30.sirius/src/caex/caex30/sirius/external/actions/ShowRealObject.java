package caex.caex30.sirius.external.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.ui.business.api.view.SiriusGMFHelper;
import org.eclipse.sirius.diagram.ui.part.SiriusDiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.ui.ide.IGotoMarker;

import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class ShowRealObject implements IExternalJavaAction{

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			
		if (selections.size() >= 1) {
			
			EObject eObject = selections.iterator().next();
			EObject showEObject = null;
			if (eObject instanceof DNode) {
				DNode node = (DNode) eObject;				
				EList<EObject> list = node.getSemanticElements();
				if (list.size() >= 1) {
					
					EObject realEObject = list.get(0);
					EObject parentEObject = realEObject.eContainer();
					ArrayList<EObject> references = new ArrayList<EObject>(new EObjectQuery(realEObject).
							getInverseReferences(ViewpointPackage.Literals.DSEMANTIC_DECORATOR__TARGET));
					
					for (int i = 0; i < references.size(); i++) {
						
						EObject currentEObject = references.get(i);
						EObject currentContainerEObject = currentEObject.eContainer();
						if (currentContainerEObject instanceof AbstractDNode) {
							
							int index = ((AbstractDNode)currentContainerEObject).getSemanticElements().indexOf(parentEObject);
							if (index != -1)
								showEObject = currentEObject;
						}						
						if (currentContainerEObject instanceof DSemanticDiagram) {
							
							 if (((DSemanticDiagram)currentContainerEObject).getTarget().equals(parentEObject))
								showEObject = currentEObject;	
						}
						
					}					
				}
			}		
			
			if (showEObject instanceof DDiagramElement) {				
				IGraphicalEditPart partToSelect = getEditPart((DDiagramElement) showEObject);
	            if (partToSelect != null) {
	            	if (editorPart instanceof SiriusDiagramEditor) {	    
	            		SiriusDiagramEditor editor = (SiriusDiagramEditor) editorPart;
	 	                editor.getDiagramGraphicalViewer().select(partToSelect);
	 	                editor.getDiagramGraphicalViewer().reveal(partToSelect);
	        		}
	            }
			}
		}		
		
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}
	
	private IGraphicalEditPart getEditPart(final DDiagramElement diagramElement, final IEditorPart editorPart) {
        IGraphicalEditPart result = null;
        final View gmfView = getGmfView(diagramElement);

        if (gmfView != null && editorPart instanceof DiagramEditor) {
            final Map<?, ?> editPartRegistry = ((DiagramEditor) editorPart).getDiagramGraphicalViewer().getEditPartRegistry();
            final Object editPart = editPartRegistry.get(gmfView);
            if (editPart instanceof IGraphicalEditPart) {
                result = (IGraphicalEditPart) editPart;
            }
        }
        return result;
    }
	
	private View getGmfView(final DDiagramElement diagramElement) {
        final Session session = SessionManager.INSTANCE.getSession(diagramElement.getTarget());
        return SiriusGMFHelper.getGmfView(diagramElement, session);
    }
	
	 protected IGraphicalEditPart getEditPart(final DDiagramElement diagramElement) {
	        final IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	        return getEditPart(diagramElement, editorPart);
	 }

}

