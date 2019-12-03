package org.miso.cloud.robotic.modular.concordance;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.concordance.model.ConcordanceModelBase;
import org.eclipse.epsilon.concordance.model.CrossReference;

public class ModularDomain extends ConcordanceModelBase{
	
	public Resource resourceModel;	
	public URI modelURI;	
	
	public ModularDomain(IPath path) {
		this(URI.createPlatformResourceURI(path.toString(),false));
	}

	public ModularDomain(URI uri) {
		this.modelURI = uri;
	}

	@Override
	public IResource getResource() {
		
		return FileUtils.getFileFromURI(getUri());
	}

	@Override
	public URI getUri() {
		
		return this.modelURI;
	}

	@Override
	public Resource getEmfResource(boolean resolve) throws IOException {

		if(this.resourceModel == null) {		
			
			ResourceSet reset = new ResourceSetImpl();
			this.resourceModel = reset.getResource(getUri(),true);			
		}	
		return this.resourceModel;
	}
	
	//Return Cross References and Proxies
	@Override
	public Set<CrossReference> getAllCrossReferences() {
		
		return new ModularProxyAnalyser(this).determineCrossReferences();		
	}
	
	@Override
	public Iterator<EObject> getAllContentsIterator(boolean resolve) throws IOException {
		
		Resource resource = getEmfResource(resolve);
		if(resource == null) {
			// Return an empty iterator
			return Collections.<EObject>emptyList().iterator();
		}
		
		return EcoreUtil.getAllContents(resource,false);
	}	
	
}
