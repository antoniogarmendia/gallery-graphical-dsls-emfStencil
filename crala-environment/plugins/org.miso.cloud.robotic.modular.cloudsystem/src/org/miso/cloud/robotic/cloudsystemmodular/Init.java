package org.miso.cloud.robotic.cloudsystemmodular;

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
import org.miso.cloud.robotic.cloudsystemmodular.Activator;
import org.miso.cloud.robotic.cloudsystemmodular.preferences.PreferenceOptions;
import org.miso.cloud.robotic.cloudsystemmodular.wizard.CloudSystemNewProjectNature;
import org.mondo.generate.index.project.execute.EvaluateExecuteIndexedAttributeContributor;
import org.mondo.modular.references.ext.EvaluateCrossReferencesContributor;

public class Init implements IStartup {

	@Override
	public void earlyStartup() {
		
		String IdExtension = Activator.getDefault().getPreferenceStore().getString(PreferenceOptions.FeatureEditor_CHOICE);
		if(!IdExtension.equals("CloudSystemCrossReferences")) {
			
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			EvaluateCrossReferencesContributor eval = new EvaluateCrossReferencesContributor();
			List<String> listMetamodelURIs = new ArrayList<String>();
			listMetamodelURIs.add("http://www.eclipse.org/emf/2002/Ecore");
			getDependencies ("http://miso.es/cloudRobotics", listMetamodelURIs);
			listMetamodelURIs.add("http://miso.es/cloudRobotics");
			eval.executeInit(registry, IdExtension, CloudSystemNewProjectNature.ID, listMetamodelURIs);
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

