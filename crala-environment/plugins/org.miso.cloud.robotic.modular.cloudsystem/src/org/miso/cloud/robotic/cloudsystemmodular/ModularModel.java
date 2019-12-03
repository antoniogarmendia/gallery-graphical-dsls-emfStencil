package org.miso.cloud.robotic.cloudsystemmodular;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.mondo.generate.modular.project.general.create.project.main.api.PerformantXMIUtils;
import org.mondo.generate.modular.project.general.create.project.main.api.CopierReverseEngineering;
import org.miso.cloud.robotic.cloudsystemmodular.wizard.CloudSystemNewProjectInfo;
import org.osgi.service.prefs.BackingStoreException;

import cloudRobotics.CloudSystem;

public class ModularModel {
	
	public ModularModel(){}

	private String projectName;	
	
	public void createCompleteModel(IProject pro, URI modelUri) throws CoreException, IOException
	{
		IFile projectFile = pro.getFile(pro.getName().concat(".xmi"));
		URI projectUri = URI.createPlatformResourceURI(projectFile.getFullPath().toString(),true);
		
		// Create the resources
		Resource projectResource = PerformantXMIUtils.getPerformantResource(projectUri);	
		Resource completeModel = PerformantXMIUtils.createPerformantResource(modelUri);
		
		// Copier all objects
		CopierReverseEngineering copier = new CopierReverseEngineering(true, true);
		completeModel.getContents().addAll(copier.copyAll(projectResource.getContents()));
		copier.copyReferences();
		copier.copyIds();
		
		// Save and Unload resources 
		completeModel.save(null);		
		completeModel.unload();
		projectResource.unload();		
	}
	
	public void Reverse_Engineering(URI fileURI) throws IOException, CoreException, BackingStoreException
	{
		//Create Performant Resource
		Resource modelResource = PerformantXMIUtils.getPerformantResource(fileURI);

		//The first element(Root)
		CloudSystem root = (CloudSystem) modelResource.getContents().get(0);
		
		if(root instanceof CloudSystem){
			
			CloudSystemNewProjectInfo project = new CloudSystemNewProjectInfo(root,modelResource);
			project.createProject();
			System.out.println("Reverse_Engineering_Create_Project_Complete");
		}

	}
		
	public void reverseEngineeringContainer(URI modelURI, IProject pro){
		
		//Create Performant Resource
		Resource modelResource = PerformantXMIUtils.getPerformantResource(modelURI);

		CloudSystem root = (CloudSystem) modelResource.getContents().get(0);
		
		//Create Performant Resource
		CloudSystemNewProjectInfo project = new CloudSystemNewProjectInfo(root,modelResource);
		project.setProject(pro);
		IContainer newFolder = project.createFolder();		
		project.reverseEngineering(newFolder);		
	}

	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}	
	
	// join methods
	public Resource reverseEngineeringContainer(CloudSystem root, IProject pro, CopierReverseEngineering copier, ResourceSet reset) {
			
		//Create Performant Resource
		CloudSystemNewProjectInfo project = new CloudSystemNewProjectInfo(root,null);
		project.setProject(pro);
		IContainer newFolder = project.createFolder();		
		return project.reverseEngineering(newFolder,root,copier,reset);			
	}	
}


