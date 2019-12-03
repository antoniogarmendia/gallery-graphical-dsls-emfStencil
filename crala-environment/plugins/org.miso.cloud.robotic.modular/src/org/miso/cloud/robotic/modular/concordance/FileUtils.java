package org.miso.cloud.robotic.modular.concordance;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class FileUtils {
	
	/** Cache value */
	private static final IWorkspaceRoot WORKSPACE_ROOT = ResourcesPlugin.getWorkspace().getRoot();
	
	public static IFile getFileFromURI(URI uri)
	 {
		if (uri == null)
	 	{
	 	    return null;
	 	}
	 	
	 	if (uri.hasFragment())
	 	{
	 	   uri = uri.trimFragment();
	 	}
	 	
	 	if (uri.isFile())
	 	{
	 	// File is directly accessible (outside of the workspace)
	 	IPath relativePath = Path.fromOSString(uri.toFileString());
	 	return WORKSPACE_ROOT.getFileForLocation(relativePath);
	 	}
	 
	 	IPath path;
	 	if (uri.isPlatform())
	 	{
	 	 // platform:/resource URI
	 	 path = new Path(uri.toPlatformString(true));
	 	}
	 	else
	 	{
	 	  path = new Path(uri.toString());
	 	}
	 	
	 	return WORKSPACE_ROOT.getFile(path);
	}	
	 
}

