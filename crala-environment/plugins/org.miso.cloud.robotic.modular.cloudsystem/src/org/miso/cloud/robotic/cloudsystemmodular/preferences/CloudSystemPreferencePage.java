package org.miso.cloud.robotic.cloudsystemmodular.preferences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.mondo.generate.index.project.execute.EvaluateExecuteIndexedAttributeContributor;
import org.mondo.modular.constraint.ext.def.EvaluateConstraintEngineContributor;
import org.mondo.modular.references.ext.EvaluateCrossReferencesContributor;

import org.eclipse.ui.IWorkbench;
import org.miso.cloud.robotic.cloudsystemmodular.Activator;
import org.miso.cloud.robotic.cloudsystemmodular.wizard.CloudSystemNewProjectNature;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class CloudSystemPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public static final String ecoreURI = "http://www.eclipse.org/emf/2002/Ecore";

	public CloudSystemPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("");
	}
	
	/*Tree Editor Wizard*/
	protected RadioGroupFieldEditor TreeEditorWizard;
	protected String previously;

	/*Engine to execute constraint*/
	protected RadioGroupFieldEditor engine;
	protected String previouslyEngine;
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */

	public void createFieldEditors() {
		
		List<String> listOfValues = PreferenceOptions.GetTreeEditorFeatureOptions();
		int count = listOfValues.size();
		previously = Activator.getDefault().getPreferenceStore().getString(PreferenceOptions.FeatureEditor_CHOICE);		
		
		String[][] labelAndvalues = new String[count][2];
		for (int i = 0; i < count; i++)
			for (int j = 0; j < 2; j++) 
				labelAndvalues[i][j] = listOfValues.get(i);			
		
		addField(new RadioGroupFieldEditor(
				PreferenceOptions.FeatureEditor_CHOICE,
				"Tree Editor Feature Wizard",
				1,
				labelAndvalues, 
				getFieldEditorParent()));	

		/*Select the Engine to execute constraint*/
		
		List<String> listOfEngines = PreferenceOptions.getEngineOptions();
		int countEngines = listOfEngines.size();		
		
		if (listOfEngines.size() != 0) {
			
			previouslyEngine = Activator.getDefault().getPreferenceStore().getString(PreferenceOptions.ENGINE_CHOICE);
			
			String[][] labelAndvaluesEngine = new String[countEngines][2];
			for (int i = 0; i < countEngines; i++)
				for (int j = 0; j < 2; j++) 
					labelAndvaluesEngine[i][j] = listOfEngines.get(i);
				
			addField(new RadioGroupFieldEditor(
					PreferenceOptions.ENGINE_CHOICE,
					"Engine for the execution of constraints",
					1,
					labelAndvaluesEngine, 
					getFieldEditorParent()));			
		}	
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
	@Override
	public boolean performOk() {
		
		boolean performOk =  super.performOk();
		String current = Activator.getDefault().getPreferenceStore().getString(PreferenceOptions.FeatureEditor_CHOICE);
		
		if(!current.equals(previously)){
			
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			EvaluateCrossReferencesContributor eval = new EvaluateCrossReferencesContributor();
			
			if(!previously.equals(PreferenceOptions.DefaultFeatureEditorDialog)){
				eval.executeFinish(registry, previously, CloudSystemNewProjectNature.ID);
			}
			
			if(!current.equals(PreferenceOptions.DefaultFeatureEditorDialog)){
				List<String> listMetamodelURIs = new ArrayList<String>();
				listMetamodelURIs.add(ecoreURI);
				getDependencies ("http://miso.es/cloudRobotics", listMetamodelURIs);
				listMetamodelURIs.add("http://miso.es/cloudRobotics");
				eval.executeInit(registry, current, CloudSystemNewProjectNature.ID, listMetamodelURIs);
				//Initialize Indexed Attributes
				new EvaluateExecuteIndexedAttributeContributor().ExecIndexAttribute(registry);
			}			
		}	

		/*Engine*/
		String currentEngine = Activator.getDefault().getPreferenceStore().getString(PreferenceOptions.ENGINE_CHOICE);
		
		if(!currentEngine.equals(previouslyEngine)) {
			
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			EvaluateConstraintEngineContributor eval = new EvaluateConstraintEngineContributor(); 
						
			if(!currentEngine.equals(PreferenceOptions.DEFAULT_ENGINE)){
				
				List<String> listMetamodelURIs = new ArrayList<String>();
				listMetamodelURIs.add(ecoreURI);
				getDependencies ("http://miso.es/cloudRobotics", listMetamodelURIs);
				listMetamodelURIs.add("http://miso.es/cloudRobotics");
				eval.executeInit(registry, currentEngine, CloudSystemNewProjectNature.ID, listMetamodelURIs);				
			}			
		}
			
		return performOk;
	}

	public void getDependencies (String modelURI, List<String> listMetamodelURIs) {
		
		ResourceSet reset = new ResourceSetImpl();
		Resource res = reset.getResource(URI.createURI(modelURI),true);
		
		Map<EObject, Collection<Setting>>  mapCrossReferences = EcoreUtil.ProxyCrossReferencer.find(res);
		for(Map.Entry<EObject, Collection<Setting>> entry : mapCrossReferences.entrySet()) {
			EObject eObject = entry.getKey();
			if (eObject.eIsProxy()) {
				
				URI eProxy = ((InternalEObject) eObject).eProxyURI();
				if (eProxy.toString().contains(ecoreURI) == false) {
					
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
