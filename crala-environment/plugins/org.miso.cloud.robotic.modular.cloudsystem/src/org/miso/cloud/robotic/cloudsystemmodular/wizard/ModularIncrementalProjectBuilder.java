package org.miso.cloud.robotic.cloudsystemmodular.wizard;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.core.runtime.Platform;
import org.miso.cloud.robotic.cloudsystemmodular.ext.EvaluateModularBuilder;

public class ModularIncrementalProjectBuilder extends IncrementalProjectBuilder  {

	public static final String ID = "org.miso.cloud.robotic.modular.cloudsystem.ModularIncrementalProjectBuilder";
	
	public ModularIncrementalProjectBuilder() {
		
	}

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		
		
		EvaluateModularBuilder eval = new EvaluateModularBuilder(kind, args, this, monitor);
		eval.execute(Platform.getExtensionRegistry());
		return null;
	}

}
