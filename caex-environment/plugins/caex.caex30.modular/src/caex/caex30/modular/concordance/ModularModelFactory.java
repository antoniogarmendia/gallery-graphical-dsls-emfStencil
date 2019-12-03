package caex.caex30.modular.concordance;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.model.IConcordanceModelFactory;

public class ModularModelFactory implements IConcordanceModelFactory {

	public ModularModelFactory() {
		
	}

	@Override
	public IConcordanceModel createModel(IResource resource) {
		
		return createModel(resource.getFullPath());
	}

	@Override
	public IConcordanceModel createModel(IPath path) {
		
		return new ModularDomain(path);
	}

	@Override
	public IConcordanceModel createModel(URI uri) {
		
		return new ModularDomain(uri);
	}

}

