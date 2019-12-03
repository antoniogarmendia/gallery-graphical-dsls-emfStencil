package caex.caex30.caexfilemodular;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IStartup;
import caex.caex30.caexfilemodular.Activator;
import caex.caex30.caexfilemodular.preferences.PreferenceOptions;
import caex.caex30.caexfilemodular.wizard.CAEXFileNewProjectNature;
import org.mondo.generate.index.project.execute.EvaluateExecuteIndexedAttributeContributor;
import org.mondo.modular.references.ext.EvaluateCrossReferencesContributor;

public class Init implements IStartup {

	@Override
	public void earlyStartup() {
		
		String IdExtension = Activator.getDefault().getPreferenceStore().getString(PreferenceOptions.FeatureEditor_CHOICE);
		if(!IdExtension.equals("CAEXFileCrossReferences")) {
			
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			EvaluateCrossReferencesContributor eval = new EvaluateCrossReferencesContributor();
			List<String> listMetamodelURIs = new ArrayList<String>();
			listMetamodelURIs.add("http://www.eclipse.org/emf/2002/Ecore");
			getDependencies ("http://www.dke.de/CAEX/300", listMetamodelURIs);
			listMetamodelURIs.add("http://www.dke.de/CAEX/300");
			eval.executeInit(registry, IdExtension, CAEXFileNewProjectNature.ID, listMetamodelURIs);
			//Initialize Indexed Attributes
			new EvaluateExecuteIndexedAttributeContributor().ExecIndexAttribute(registry);
		}		
	}
	
	public void getDependencies (String modelURI, List<String> listMetamodelURIs) {
		
		ResourceSet reset = new ResourceSetImpl();
		Resource res = reset.getResource(URI.createURI(modelURI),true);
		
		Map<EObject, Collection<Setting>>  mapCrossReferences = EcoreUtil.ProxyCrossReferencer.find(res);
		for(Map.Entry<EObject, Collection<Setting>> entry : mapCrossReferences.entrySet()) {
			EObject eObject = entry.getKey();
			if (eObject.eIsProxy()) {
				
				URI eProxy = ((InternalEObject) eObject).eProxyURI();
				if (eProxy.toString().contains("http://www.eclipse.org/emf/2002/Ecore") == false) {
					
					String proxyURI = eProxy.scheme() +":"+ eProxy.devicePath();
					if (listMetamodelURIs.indexOf(proxyURI) == -1) {
					
						getDependencies(proxyURI, listMetamodelURIs);
						listMetamodelURIs.add(proxyURI);						
					}
				}				
			}
		}		
	}

}

