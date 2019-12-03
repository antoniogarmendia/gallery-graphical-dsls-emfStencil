package org.miso.cloud.robotic.cloudsystemmodular.editors;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.mondo.modular.references.ext.IEditorCrossReferences;

import org.miso.cloud.robotic.cloudsystemmodular.wizard.CloudSystemNewProjectNature;

public class CloudSystemModularCrossReferences implements IEditorCrossReferences {

	public CloudSystemModularCrossReferences() {
		
	}

	@Override
	public EList<?> getChoicesOfValues(String modularNature,Resource res, boolean searchWS, EClass anEClass, String eolExpression) {
		
		if(searchWS==false)
			return getChoicesOfValuesProject(res,anEClass);
		else
			return getChoicesOfValuesWS(modularNature, anEClass);
	}
	
	public EList<?> getChoicesOfValuesProject(Resource res, EClass anEClass){
		
		EList<EObject> result = new BasicEList<EObject>();
		try {
			res.load(null);
			TreeIterator<EObject> tree = EcoreUtil.getAllContents(res, true);
			while (tree.hasNext()) {
				EObject anEObject = tree.next();
				if(anEClass.isInstance(anEObject))
					result.add(anEObject);			
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		res.unload();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public EList<?> getChoicesOfValuesWS(String modularNature, EClass anEClass){
		
		EList<EObject> result = new BasicEList<EObject>();
		IProject[] projs = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		int count = projs.length;
		IProjectNature nat = null;
		IProject current_pro = null;
		ResourceSet set = new ResourceSetImpl();
		Resource res = null;
		EList<?> project_result = null;
		try {
			for (int i = 0; i < count; i++) {
				current_pro = projs[i];
				nat = current_pro.getNature(modularNature);
				if(nat!=null){
					IFile fil = current_pro.getFile(new Path(current_pro.getName() + ".xmi"));	
					res = set.createResource(URI.createPlatformResourceURI(fil.getFullPath().toString(), true));
					project_result =  getChoicesOfValuesProject(res, anEClass);
					if(project_result!=null)
					{
						result.addAll((EList<? extends EObject>) project_result);
						project_result = null;
					}
				}				
			}			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	
	@Override
	public boolean init(List<String> metamodelURI,String modularNature) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean finish(String modularNature) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isGlobal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNature(String modularNature) {
		// TODO Auto-generated method stub
		if(modularNature.equals(CloudSystemNewProjectNature.ID))
			return true;
		return false;
	}

}

