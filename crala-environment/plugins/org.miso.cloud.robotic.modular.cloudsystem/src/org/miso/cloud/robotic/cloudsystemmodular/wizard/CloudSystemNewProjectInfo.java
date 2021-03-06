package org.miso.cloud.robotic.cloudsystemmodular.wizard;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.osgi.service.prefs.BackingStoreException;
import org.mondo.generate.modular.project.general.create.project.main.api.PerformantXMIUtils;
import org.mondo.generate.modular.project.general.create.project.main.api.CopierReverseEngineering;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edapt.internal.common.URIUtils;

import cloudRobotics.CloudSystem;
import cloudRobotics.impl.cloudRoboticsFactoryImpl;
import cloudRobotics.impl.ConfigurationImpl;
import cloudRobotics.impl.ArchitectureSpecificationImpl;
import cloudRobotics.impl.ConfigurationSystemImpl;



public class CloudSystemNewProjectInfo {

	private CloudSystem root; 
	private IProject project;
	private Resource reverseModel;

	public static final String CONCORDANCE_ID = "org.eclipse.epsilon.concordance.nature.ConcordanceNature";
	
	public CloudSystemNewProjectInfo(CloudSystem root){
		this.root = root;
		this.project = null;
	}
	
	public CloudSystemNewProjectInfo(CloudSystem root,Resource reverseModel)
	{
		this.root = root;
		this.project = null;
		this.reverseModel = reverseModel;
	}

	public boolean createProject() throws CoreException, BackingStoreException, IOException
	{	
		final IWorkspaceRunnable create = new IWorkspaceRunnable(){
		
		@Override
		public void run(IProgressMonitor monitor) throws CoreException {
		
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(root.getName());
		if (!project.exists()) {
		    project.create(null);
		    project.open(null);
			try {
		    	IProjectDescription description = project.getDescription();
		    	String[] natures = description.getNatureIds();
		    	String[] newNatures = new String[natures.length + 2];
				newNatures[natures.length] = CloudSystemNewProjectNature.ID;
				newNatures[natures.length + 1] = CONCORDANCE_ID;
		    	System.arraycopy(natures, 0, newNatures, 0, natures.length);		    	
		    	description.setNatureIds(newNatures);
		    	project.setDescription(description, null);
				
				try {
					createXMIAssociated(project);

				} catch (IOException e) {
					e.printStackTrace();
				}
		
		    }catch (CoreException e) {
		        
					e.printStackTrace();
		    	}
			}	
		  }	
		};
		
		try {

			ResourcesPlugin.getWorkspace().run(create,null);
		}
		catch (CoreException e) {
			
			e.printStackTrace();
		}

		return true;				
	}


	public IContainer createFolder(){
		
		String folderName = checkFileName(root.getName(), "CloudSystem");
		IFolder newFolder = project.getFolder(folderName);
		if(newFolder.exists()==false){
			try {
				newFolder.create(IResource.NONE, true, new NullProgressMonitor());
				createXMIAssociated(newFolder);
								
			} catch (CoreException | IOException e) {
				
				e.printStackTrace();
			}
		}else {
			
			// the name of the folder is gonna be different from the name of the EObject
			System.out.println("Cannot be created: " + newFolder.getName());
			int version = 0;
			while(version!=-1) {
				
				folderName = newFolder.getName() + version;
				IFolder checkFolder = project.getFolder(folderName);
				if(!checkFolder.exists()){
					try {
						checkFolder.create(IResource.NONE, true, null);
						createXMIAssociated(checkFolder);
						
					} catch (CoreException | IOException e) {						
						e.printStackTrace();
					}
					System.out.println("Instead: " + checkFolder.getName());
					return checkFolder;
				}
				version++;
			}	
		}	

		return newFolder;		
	}

	public void createXMIAssociated(IContainer container) throws IOException, CoreException
	{
		// Get the URI of the model file.
		URI fileURI = URI.createPlatformResourceURI(container.getFullPath().toString().concat("/").concat(container.getName()+".xmi"), true);
		if(reverseModel == null)
		{		
		
			Resource resource = PerformantXMIUtils.createResourceRoot(fileURI, this.root);
			resource.save(null);
			resource.unload();		
		}
		else
		{
			reverseEngineering(project);	
		}			
	}
	
	//join methods
	public Resource reverseEngineering(IContainer container, CloudSystem root, CopierReverseEngineering copier, ResourceSet reset){
		
		Resource resource = null;
		try {
			
			resource = reverseEnginneringContainer(container,root,copier,reset);			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return resource;
				
	}
	
	public void reverseEngineering(IContainer container){
		
		try {
			
			Resource resource = reverseEnginneringContainer(container);
			saveAllResources(resource.getResourceSet());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
	}
	
	// join the methods
	public Resource reverseEnginneringContainer(IContainer container, CloudSystem root, CopierReverseEngineering copierModular, ResourceSet reset) throws IOException{
		
		// Get the URI of the model file.
		URI folderUri = URI.createPlatformResourceURI(container.getFullPath().toString().concat("/").concat(container.getName()+".xmi"), true);
		
		//Create folder resource
		Resource folderResource =  reset.createResource(folderUri);
		
		//Iterator
		TreeIterator<EObject> itContents = root.eAllContents();
		EObject eObject = root;
		
		//Root of the model
		if(eObject instanceof CloudSystem){
			
			EObject result = copierModular.copyFolder(eObject);
			folderResource.getContents().add(result);	
			
			LinkedHashMap<EObject, URI> structureMap = new LinkedHashMap<EObject,URI>();
			structureMap.put(eObject, folderResource.getURI());			
			
			while (itContents.hasNext()) {
				
				eObject = itContents.next();				
				String name = getFolder(eObject);
				URI parentURI = getObjectParentURI(eObject, structureMap);
				
				if(name != null){
					
					URI fileURI = createPackage(parentURI,name,eObject,folderResource,copierModular,container);		
					structureMap.put(eObject, fileURI);					
				}
				else{
					
					name = getFile(eObject);					
					if(name != null){
						
						createUnit(parentURI,name,eObject,folderResource,copierModular,container);
						itContents.prune();
					}
					else{
						/*
						 * Objects that belonging to a package   
						 */
						addToPackage(parentURI,eObject,folderResource,copierModular);
						itContents.prune();
					}
				}
				
			}						
		}
		
		return folderResource;
	}

	public Resource reverseEnginneringContainer(IContainer container) throws IOException{
			
		// Get the URI of the model file.
		URI folderUri = URI.createPlatformResourceURI(container.getFullPath().toString().concat("/").concat(container.getName()+".xmi"), true);
		
		//Create folder resource
		Resource folderResource = PerformantXMIUtils.createPerformantResource(folderUri);
		
		//Iterator
		TreeIterator<EObject> itContents = reverseModel.getAllContents();
		EObject eObject = itContents.next();
		
		//Root of the model
		if(eObject instanceof CloudSystem){
			
			CopierReverseEngineering copierModular = new CopierReverseEngineering(true,true);
			EObject result = copierModular.copyFolder(eObject);
			folderResource.getContents().add(result);	

			LinkedHashMap<EObject, URI> structureMap = new LinkedHashMap<EObject,URI>();
			structureMap.put(eObject, folderResource.getURI());	
						
			while (itContents.hasNext()) {
				
				eObject = itContents.next();				
				String name = getFolder(eObject);
				URI parentURI = getObjectParentURI(eObject, structureMap);
				
				if(name != null){
					
					URI fileURI = createPackage(parentURI,name,eObject,folderResource,copierModular,container);		
					structureMap.put(eObject, fileURI);				
				}
				else{
					
					name = getFile(eObject);					
					if(name != null){
						
						createUnit(parentURI,name,eObject,folderResource,copierModular,container);
						itContents.prune();
					}
					else{
						if (parentURI == null) {
							addToProjectRoot(folderResource,eObject,copierModular);
							itContents.prune();
						}
						else {
						/*
						 * Objects that belonging to a package   
						 */
							addToPackage(parentURI,eObject,folderResource,copierModular);
							itContents.prune();
						}
					}
				}
				
			}
			
			copierModular.copyReferences();
			copierModular.copyIds();
			copierModular.clear();			
		}
		
		return folderResource;
	}
	
	private void addToProjectRoot(Resource folderResource, EObject eObject, CopierReverseEngineering copierModular) {
		
		EObject result = copierModular.copy(eObject);
		folderResource.getContents().add(result);
	}

	public void saveAllResources(ResourceSet resourceSet) {
		
		Iterator<Resource> itResources = resourceSet.getResources().iterator();
		while (itResources.hasNext()) {
			
			Resource resource = itResources.next();
			try {
				
				resource.save(null);
				resource.unload();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}			
		}
	}

	@SuppressWarnings("unchecked")
	private void addToPackage(URI parentURI, EObject eObject, Resource folderResource,
			CopierReverseEngineering copierModular) {
		
		try {
			
			EObject result = copierModular.copy(eObject);
			Resource parentResource = folderResource.getResourceSet().getResource(parentURI, true);
			parentResource.load(null);			
			((EList<EObject>)parentResource.getContents().get(0).eGet(eObject.eContainingFeature())).add(result);
			
		}catch (IOException e) {
			
			e.printStackTrace();
		}		
	}

	public void createUnit(URI parentURI, String name, EObject eObject, Resource folderResource,
			CopierReverseEngineering copierModular, IContainer container) {
		
		//URI Folder
		URI folderURI = parentURI.trimSegments(1);
				
		//Path to Create XMI File
		URI fileURI = folderURI.appendSegment(name);
		
		EObject result = copierModular.copy(eObject);
		
		// Create XMI File
		Resource resource = createFileUnit(fileURI,folderResource.getResourceSet(),result);
		addProxyToParent(parentURI, eObject, resource);	
		
		try {
			resource.save(null);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	private Resource createFileUnit(URI fileURI, ResourceSet resourceSet, EObject result) {
		
		//Check if the resource exists in the ResourceSet
		boolean existResource = resourceSet.getURIConverter().exists(fileURI,null);
		
		if(existResource == false) {
			Resource fileResource = resourceSet.createResource(fileURI);
			fileResource.getContents().add(result);
			return fileResource;
		} else {
			
			System.out.println("Cannot be created: " + fileURI.path());
			int version = 0;
			
			while(version != -1) {
				
				String fileName = fileURI.trimFileExtension().lastSegment() + version;
				URI newURI = fileURI.trimSegments(1).appendSegment(fileName).appendFileExtension(fileURI.fileExtension());
				existResource = resourceSet.getURIConverter().exists(newURI,null);
				
				if(existResource == false) {
					Resource fileResource = resourceSet.createResource(newURI);
					fileResource.getContents().add(result);
					System.out.println("Instead: " + newURI.path());
					return fileResource;
				}	
				version++;
			}			
		}
		return null;		
	}

	public URI createPackage(URI parentURI, String name, EObject eObject, Resource folderResource, 
			CopierReverseEngineering copierModular, IContainer container) {
		
		try {
		
			// Create Folder
			String type = eObject.eClass().getName();
			URI folderURI = parentURI.trimSegments(1);	
			String folderName = checkFileName(name, type);
			
			IContainer fol = this.createFolder(folderURI, folderName, container);
			
			// Path to Create XMI File
			String extension = getPackageExtension(eObject);
			String filePath = fol.getFullPath().toString().concat("/"+fol.getName().concat("." + extension));
			
			// Obtain File URI
			URI fileUri = URI.createPlatformResourceURI(filePath,true);
			
			// Copy of the result object
			EObject result =  copierModular.copyFolder(eObject);
			
			// Create XMI File
			Resource resource = createFile(fileUri,folderResource.getResourceSet(),result);
			addProxyToParent(parentURI,eObject,resource);
			
			return fileUri;
			
		} catch (CoreException e) {
			
			e.printStackTrace();
		}
		return null;					
	}
	
	public Resource createFile(URI fileUri, ResourceSet resourceSet, EObject result){
		
		Resource fileResource = resourceSet.createResource(fileUri);
		fileResource.getContents().add(result);
		
		try {
			fileResource.save(null);

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return fileResource;
	}
	
	@SuppressWarnings("unchecked")
	public void addProxyToParent(URI parentURI,EObject eObject, Resource resource){
		
		Resource parentResource = resource.getResourceSet().getResource(parentURI, true);		
		((EList<EObject>)parentResource.getContents().get(0).eGet(eObject.eContainingFeature())).add(resource.getContents().get(0));
	}

	@SuppressWarnings("restriction")
	public IContainer createFolder(URI folderParentURI, String name,IContainer container) throws CoreException
	{
		URI folderURI = folderParentURI.appendSegment(name);
		IFolder fol = URIUtils.getFolder(folderURI);
		if(!fol.exists()){
			fol.create(IResource.NONE, true, null);			
		} else {
			
			System.out.println("Cannot be created: " + fol.getName());
			int version = 0;
			while(version != -1) {
				
				String folderName = fol.getName() + version;
				folderURI = folderParentURI.appendSegment(folderName);
				IFolder checkFolder = URIUtils.getFolder(folderURI); 				
				
				if(!checkFolder.exists()){
					checkFolder.create(IResource.NONE, true, null);
					System.out.println("Instead: " + checkFolder.getName());
					return checkFolder;
				}
				version++;
			}				
		}
				
		return fol;
	}

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}	
	
	public URI getObjectParentURI(EObject eObject, LinkedHashMap<EObject, URI> structureMap) {
		
		EObject parent = eObject.eContainer();
		return structureMap.get(parent);
	}
	
	public String getFolder(EObject eObject){
		
		 if(eObject instanceof ConfigurationImpl)
				return checkFileName(((ConfigurationImpl)eObject).getName().toString(),"Configuration");
		return null;
	}
	
	public static String getFile(EObject eObject){
		
		if(eObject instanceof ArchitectureSpecificationImpl)
			return checkFileName(((ArchitectureSpecificationImpl) eObject).getName(),"ArchitectureSpecification").concat(".archi");
		if(eObject instanceof ConfigurationSystemImpl)
			return checkFileName(((ConfigurationSystemImpl) eObject).getName(),"ConfigurationSystem").concat(".config");
		
		return null;
	} 
	
	private String getPackageExtension(EObject eObject) {
		
		 if(eObject instanceof ConfigurationImpl)
				return "1";	
		
		return null;
	}
	
	private static final char[] ILLEGAL_CHARACTERS = { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };
	
	public static String checkFileName(String fileName, String type) {
		
		if(fileName == null)
			return type;
		if(fileName.equals("")) 
			return type;
		
		String result = removeIlegalCharacters(fileName);
		
		if(result.equals("")) 
			return type;
		
		return result;			
	}	
	
	public static String removeIlegalCharacters(String fileName) {
		
		String result = "";
		char[] name = fileName.toCharArray();		
		for(int i=0; i<name.length;i++) {
			
			char ch = name[i];
			for (int j = 0; j < ILLEGAL_CHARACTERS.length; j++) {
				
				if(ch==ILLEGAL_CHARACTERS[j])
					break;				
				if(j + 1 == ILLEGAL_CHARACTERS.length)
					result = result + ch;
			}			
		}
		return result;
	}	
}

