package caex.caex30.caexfilemodular.preferences;


import java.util.List;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import caex.caex30.caexfilemodular.Activator;

/**
 * Class used to initialize default preference values.
 */

public class CAEXFilePreferenceInitializer extends AbstractPreferenceInitializer {

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
			num = listvalues.indexOf("CAEXFileModularCrossReferences");
			if(num.equals(-1))
				defId = PreferenceOptions.DefaultFeatureEditorDialog;
			else
				defId = "CAEXFileModularCrossReferences";
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

