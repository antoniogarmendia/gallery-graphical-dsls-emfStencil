package org.miso.cloud.robotic.cloudsystemmodular.preferences;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.mondo.modular.references.ext.EvaluateCrossReferencesContributor;
import org.mondo.modular.constraint.ext.def.EvaluateConstraintEngineContributor;
import org.miso.cloud.robotic.cloudsystemmodular.wizard.CloudSystemNewProjectNature;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceOptions {

	/*Tree Editor Options*/
	
	public static final String FeatureEditor_CHOICE = "choiceFeatureEditor";
	public static final String DefaultFeatureEditorDialog = "DefaultFeatureEditorDialog";
	
	public static final List<String> GetTreeEditorFeatureOptions()
	{
		EvaluateCrossReferencesContributor eval = new EvaluateCrossReferencesContributor();
		List<String> listOfValues = eval.ListNames(Platform.getExtensionRegistry(),CloudSystemNewProjectNature.ID);
		listOfValues.add(DefaultFeatureEditorDialog);
		return listOfValues;
	}
	
	/*Engine to Execute Constraint in a Fragmented Model*/
	
	public static final String ENGINE_CHOICE = "choiceEngine";
	public static final String DEFAULT_ENGINE = "DefaultEolEngine";
	
	public static final List<String> getEngineOptions()
	{
		EvaluateConstraintEngineContributor eval = new EvaluateConstraintEngineContributor();
		List<String> listOfValues = eval.listContributors(Platform.getExtensionRegistry());
		return listOfValues;
	}
	
}

