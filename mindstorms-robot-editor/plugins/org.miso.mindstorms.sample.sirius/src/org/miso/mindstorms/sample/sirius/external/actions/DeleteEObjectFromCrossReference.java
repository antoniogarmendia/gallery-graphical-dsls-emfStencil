package org.miso.mindstorms.sample.sirius.external.actions;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

public class DeleteEObjectFromCrossReference implements IExternalJavaAction {

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		
		EObject elementView = (EObject) parameters.get("elementView");
		EObject currentObject = getTargetEObject(elementView);
		EObject parentEObject = getTargetEObject(elementView.eContainer());
		String feature = getFeature(elementView);
		
		EStructuralFeature structuralFeature = parentEObject.eClass().getEStructuralFeature(feature);
		
		Object featureObject = parentEObject.eGet(structuralFeature, true);
				
		if (featureObject instanceof EList<?>) {
			
			EList<?> listOfObjects = (EList<?>) featureObject;
			
			Iterator<?> itObjects = listOfObjects.iterator();
			while (itObjects.hasNext()) {
				Object object = itObjects.next();
				if (object.equals(currentObject)) {					
					EcoreUtil.remove(parentEObject,structuralFeature, currentObject);
					break;
				}				
			}			
		}	
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		
		return true;
	}
	
	private String getFeature(Object nodeObject) {
		
		if (nodeObject instanceof DNode) {
			DNode node = (DNode) nodeObject;
			String semanticCandidate =  node.getActualMapping().getSemanticCandidatesExpression();
			String feature = semanticCandidate.substring(semanticCandidate.indexOf(":") + 1, semanticCandidate.length());
			return feature;			
		}
		
		return null;
	}
	
	private EObject getTargetEObject(EObject element) {
		
		if (element instanceof DDiagramElement) {
			DDiagramElement parentNode = (DDiagramElement) element;
			return parentNode.getTarget();
		} 	
		
		return null;
	} 
}

