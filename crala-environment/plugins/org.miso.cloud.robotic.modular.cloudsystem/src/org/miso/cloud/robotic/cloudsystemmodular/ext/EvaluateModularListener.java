package org.miso.cloud.robotic.cloudsystemmodular.ext;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.e4.core.di.annotations.Execute;
import org.mondo.generate.modular.project.ext.IModularListener;

public class EvaluateModularListener {
	
	private static final String IMODULAR_LISTENER = "org.miso.cloud.robotic.modular.cloudsystem.CloudSystemModularListeners";
	
	@Execute
	public void executeProject(IExtensionRegistry registry,String anProjectName) {
	    evaluateExtensionListener(registry, anProjectName);
	}

	private void evaluateExtensionListener(IExtensionRegistry registry,String anProjectName) {
		 
		IConfigurationElement[] config = registry.getConfigurationElementsFor(IMODULAR_LISTENER);
		
		try {
			
		      for (IConfigurationElement e : config) {
		        final Object o = e.createExecutableExtension("class");
		        if (o instanceof IModularListener) {
		           executeExtension(o,anProjectName);
		        }
		      }
		    } catch (CoreException ex) {
		      System.out.println(ex.getMessage());
		    }
			 
	}
	
	private void executeExtension(Object o,String anProjectName) {
		ISafeRunnable runnable = new ISafeRunnable() {
		      @Override
		      public void handleException(Throwable e) {
		        System.out.println("Exception in client");
		      }
		      @Override
		      public void run() throws Exception {
			    	((IModularListener) o).executeAfterProjectCreation(anProjectName);
			      }
			    };
			    
		 SafeRunner.run(runnable);
	}	
}

