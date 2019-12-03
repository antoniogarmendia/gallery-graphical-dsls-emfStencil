package caex.caex30.caexfilemodular.editors;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.mondo.generate.scope.project.ext.EvaluateScopeCrossReferences;
import org.mondo.generate.visibility.project.ext.EvaluateVisibilityEClass;
import org.mondo.modular.references.ext.EvaluateCrossReferencesContributor;

import caex.caex30.caexfilemodular.wizard.CAEXFileNewProjectNature;

import ScopeDefinition.ScopeDefinitionEnum;

public class ModularPossibleValues {
	
	private String idExtension;
	private ScopeDefinitionEnum current_scope;
	private EStructuralFeature feature;
	private Resource res;
	private EObject eObject;
	
	public ModularPossibleValues(String idExtension, EStructuralFeature feature, EObject eObject) {
		this.idExtension = idExtension;
		this.current_scope = null;
		this.feature = feature;
		this.res = null;
		this.eObject = eObject;
	}	
	
	public List <?> getChoicesofValues() {

		EvaluateVisibilityEClass evalVisibility = new EvaluateVisibilityEClass();
		evalVisibility.executeEClass(Platform.getExtensionRegistry(), (EClass)feature.getEType());
		evalVisibility.executeEOL(Platform.getExtensionRegistry(), (EClass)feature.getEType());

		ScopeDefinitionEnum scopeEnum = evalVisibility.getDef();
		String eolExp = evalVisibility.getEolExpression();
		
		if(scopeEnum != null)
			if(scopeEnum.getValue() > getCurrentScope().getValue())
				return null;
		
		EvaluateCrossReferencesContributor eval = new EvaluateCrossReferencesContributor();

		if (res == null)
			eval.execute(Platform.getExtensionRegistry(), this.idExtension, CAEXFileNewProjectNature.ID, eObject.eResource(), true, (EClass)feature.getEType(), eolExp);
		else
			eval.execute(Platform.getExtensionRegistry(), this.idExtension, CAEXFileNewProjectNature.ID, res, false, (EClass)feature.getEType(), eolExp);

		return eval.getChoicesofValues();
	}
	
	public ScopeDefinitionEnum getCurrentScope()
	{
		if(current_scope == null)
		{
			EvaluateScopeCrossReferences eval = new EvaluateScopeCrossReferences();
			current_scope = eval.execute(Platform.getExtensionRegistry(), (EReference)feature);		
			if(current_scope == null)
				current_scope = ScopeDefinitionEnum.SAME_WORKSPACE;
		}	
		return current_scope;
	}
}


