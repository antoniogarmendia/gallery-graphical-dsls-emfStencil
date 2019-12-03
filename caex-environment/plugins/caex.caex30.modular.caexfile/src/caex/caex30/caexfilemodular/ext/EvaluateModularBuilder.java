package caex.caex30.caexfilemodular.ext;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.e4.core.di.annotations.Execute;
import caex.caex30.caexfilemodular.wizard.ModularIncrementalProjectBuilder;

public class EvaluateModularBuilder {
	
	private static final String IMODULAR_BUILDER = "caex.caex30.modular.caexfile.CAEXFileModularBuilders";
	
	private int kind;
	private Map<String, String> args;
	private IProgressMonitor monitor;
	private ModularIncrementalProjectBuilder builder;
	
	public EvaluateModularBuilder(int kind, Map<String, String> args, ModularIncrementalProjectBuilder modularIncrementalProjectBuilder, IProgressMonitor monitor) {
		super();
		this.kind = kind;
		this.args = args;
		this.builder = modularIncrementalProjectBuilder;
		this.monitor = monitor;

	}

	@Execute
    public void execute(IExtensionRegistry registry) {
       IConfigurationElement[] config =
               registry.getConfigurationElementsFor(IMODULAR_BUILDER);
       try {
           for (IConfigurationElement e : config) {
               System.out.println("Evaluating extension");
               final Object o =
                       e.createExecutableExtension("class");
               if (o instanceof IModularBuilder) {
                   executeExtension(o);
               }
           }
       } catch (CoreException ex) {
           System.out.println(ex.getMessage());
       }
	}

	private void executeExtension(Object o) {
		ISafeRunnable runnable = new ISafeRunnable() {
           @Override
           public void handleException(Throwable e) {
               System.out.println("Exception in client");
            }

            @Override
            public void run() throws Exception {
                ((IModularBuilder) o).build(kind, args, builder, monitor);
            }
        };
        SafeRunner.run(runnable);		
	}
}

