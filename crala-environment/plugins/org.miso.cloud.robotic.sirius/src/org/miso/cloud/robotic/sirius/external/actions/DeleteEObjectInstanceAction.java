package org.miso.cloud.robotic.sirius.external.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

public class DeleteEObjectInstanceAction implements IExternalJavaAction{

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
				
		Object deleteEObject = parameters.get("element");
		if (deleteEObject instanceof EObject) {
			EcoreUtil.remove((EObject) deleteEObject);
		}		
	}
	
	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}

