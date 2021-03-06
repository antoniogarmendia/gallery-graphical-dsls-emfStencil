package caex.caex30.modular.concordance;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.concordance.clients.xref.MarkerManager;
import org.eclipse.epsilon.concordance.dt.ConcordancePlugin;
import org.eclipse.epsilon.concordance.model.CrossReference;
import org.eclipse.epsilon.concordance.model.CrossReferenceVisitor;

public class DeleteCrossReferences implements CrossReferenceVisitor{

	@Override
	public void visit(CrossReference crossReference) {
		
		try {
						
			String path = crossReference.source.model.getUri().toPlatformString(true);			
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));			
			
			if (file.exists() == true) {
			
				Resource resource = crossReference.source.model.getEmfResource(false);
				EObject eObject = resource.getEObject(crossReference.source.uriFragment);
				
				if (eObject.eIsProxy() == true)	{			
					EcoreUtil.remove(eObject);	
				} else {
					deleteCrossReference(crossReference, eObject);						
				}				
				// save resource
				resource.save(null);							
				// update concordance Database
				ConcordancePlugin.getDefault().getModelChangeReporter().reportChange(crossReference.source.model);
				// delete the marker
				new MarkerManager(crossReference.source.getResource()).removeErrorMarker(crossReference);	
			}	
				
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
		
	}
	
	
	public void deleteCrossReference(CrossReference crossReference, EObject eObject) {
		
		// cross references
		EStructuralFeature feature = eObject.eClass().getEStructuralFeature(crossReference.label);		
		if (feature.isMany() == true) {
			@SuppressWarnings("unchecked")
			EList<EObject> listOfObject = (EList<EObject>) eObject.eGet(feature);
			Iterator<EObject> itObjects = listOfObject.iterator();
			while (itObjects.hasNext()) {
				
				EObject currentEObject = (EObject) itObjects.next();
				if (currentEObject.eIsProxy() == true) {
					InternalEObject internalEObject = (InternalEObject) currentEObject;
					if (internalEObject.eProxyURI().toString().equals(crossReference.target.getUri())) {
						listOfObject.remove(currentEObject);
						return;
					}					
				}				
			}			
		} else {
			//TODO
			/*
			 * when the cross reference only has one element
			 * */
			Object object = eObject.eGet(feature);
			System.out.println("Croos reference is not many fix me!");
		}		
	}
}

