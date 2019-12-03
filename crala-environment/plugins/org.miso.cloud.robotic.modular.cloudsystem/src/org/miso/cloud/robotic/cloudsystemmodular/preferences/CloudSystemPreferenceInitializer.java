package org.miso.cloud.robotic.cloudsystemmodular.preferences;


import java.util.List;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import org.miso.cloud.robotic.cloudsystemmodular.Activator;

/**
 * Class used to initialize default preference values.
 */

public class CloudSystemPreferenceInitializer extends AbstractPreferenceInitializer {

/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		
		/*Tree Editor Options*/
		
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		List<String> listvalues = PreferenceOptions.GetTreeEditorFeatureOptions();
		String defId = null;
		
		Integer num = listvalues.indexOf("Hawk");
		if(num.equals(-1))
		{
			num = listvalues.indexOf("CloudSystemModularCrossReferences");
			if(num.equals(-1))
				defId = PreferenceOptions.DefaultFeatureEditorDialog;
			else
				defId = "CloudSystemModularCrossReferences";
		}
		else
			defId = "Hawk";		
		
		store.setDefault(PreferenceOptions.FeatureEditor_CHOICE, defId);	

		/*Engine to Execute Constraint in a Fragmented Model*/
		List<String> listEngines = PreferenceOptions.getEngineOptions();
		String defEngine = null;
		
		if (listEngines.size() != 0) {
			
			Integer index = listEngines.indexOf(PreferenceOptions.DEFAULT_ENGINE);
			
			if (index.equals(-1)) {
				defEngine = listEngines.get(0);
			} else {
				defEngine = PreferenceOptions.DEFAULT_ENGINE;
			}			
			store.setDefault(PreferenceOptions.ENGINE_CHOICE, defEngine);
		}					
	}

}

