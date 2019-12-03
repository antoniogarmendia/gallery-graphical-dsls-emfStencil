package org.miso.cloud.robotic.sirius.editor.dialog;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSelector;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;

public class ModularAnalysisSelector implements DAnalysisSelector{

	private URI pickedResourceUri;
	private URI sessionUri;
	
	public ModularAnalysisSelector(URI sessionUri, URI pickedResourceUri) {
		this.sessionUri = sessionUri;
		this.pickedResourceUri = pickedResourceUri;
	}

	@Override
	public DAnalysis selectSmartlyAnalysisForAddedRepresentation(DRepresentation representation, Collection<DAnalysis> allAnalysis) {
				
		return selectAnalysis(allAnalysis);
	}

	@Override
	public DAnalysis selectSmartlyAnalysisForAddedResource(Resource resource, Collection<DAnalysis> allAnalysis) {
		
		return selectAnalysis(allAnalysis);
	}

	private DAnalysis selectAnalysis(Collection<DAnalysis> allAnalysis) {
		
		Iterator<DAnalysis> itallAnalysis = allAnalysis.iterator();
		DAnalysis sessionAnalysis = null;		
		while (itallAnalysis.hasNext()) {
			DAnalysis dAnalysis = (DAnalysis) itallAnalysis.next();
			if (dAnalysis.eResource().getURI().equals(this.pickedResourceUri))
				return dAnalysis;
			else if (dAnalysis.eResource().getURI().equals(this.sessionUri))
				sessionAnalysis = dAnalysis;
		}		
		return sessionAnalysis;
	}
}

