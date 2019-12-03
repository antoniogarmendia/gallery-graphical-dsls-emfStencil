package org.miso.cloud.robotic.cloudsystemmodular.wizard;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class CloudSystemNewProjectNature implements IProjectNature {

    private IProject project;
	public static final String ID = "org.miso.cloud.robotic.modular.cloudsystem.ModularNature";

	public String getBuilderID() {
		return ModularIncrementalProjectBuilder.ID;
	}
	
    public void configure() throws CoreException {
    	
		if (modularProjectHasBuilder() == false)
    	   applyModularBuilderToProject(addCommandModularBuilder());	
    }
		
	private void applyModularBuilderToProject(Collection<ICommand> buildSpec) throws CoreException {
		final IProjectDescription desc = project.getDescription();
				
		desc.setBuildSpec(buildSpec.toArray(new ICommand[0]));
		
		project.setDescription(desc, null);
	}
    
    
    private Collection<ICommand> addCommandModularBuilder() throws CoreException {
		final Collection<ICommand> newBuildSpec = new LinkedList<ICommand>();
		newBuildSpec.add(createModularCommand());
		newBuildSpec.addAll(Arrays.asList(project.getDescription().getBuildSpec()));
		return newBuildSpec;
	}
    
    private ICommand createModularCommand() throws CoreException {
		final ICommand buildCommand = project.getDescription().newCommand();
		buildCommand.setBuilderName(getBuilderID());
		return buildCommand;
	}

	 private boolean modularProjectHasBuilder() throws CoreException {
		if (project != null) {
			for (ICommand buildCommand : project.getDescription().getBuildSpec()) {
				if (getBuilderID().equals(buildCommand.getBuilderName())) {
					return true;
				}
			}
		}		
		return false;
	}

    public void deconfigure() throws CoreException {
       // Remove the nature-specific information here.
    }

    public IProject getProject() {
       return project;
    }

    public void setProject(IProject value) {
       project = value;
    }

}
