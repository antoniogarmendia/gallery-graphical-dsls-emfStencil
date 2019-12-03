package org.miso.cloud.robotic.cloudsystemmodular.wizard.folder;
	
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.URI;
import java.io.IOException;

import cloudRobotics.Configuration;
import cloudRobotics.impl.cloudRoboticsFactoryImpl;

import org.miso.cloud.robotic.cloudsystemmodular.XMI_File;

public class ConfigurationCreateFolderWizard extends Wizard implements INewWizard {
	private ConfigurationCreateFolderWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for ConfigurationCreateFolderWizard.
	 */
	public ConfigurationCreateFolderWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new ConfigurationCreateFolderWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String containerName = page.getContainerName();
		final String fileName = page.getFileName();
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName,
					monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 * @throws IOException 
	 */

	private void doFinish(
		String containerName,
		String fileName,
		IProgressMonitor monitor)
		throws CoreException, IOException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		IFolder folder = container.getFolder(new Path(fileName));
		if(!folder.exists()){
			folder.create(IResource.NONE, true, null);					
		}
		//Get the URI 
		//The extension is the index
		URI fileURI = URI.createPlatformResourceURI(folder.getFullPath().toString().concat("/").concat(folder.getName()+".1"), true);
		//Create Root
		Configuration root_obj = cloudRoboticsFactoryImpl.eINSTANCE.createConfiguration();
		//Set the Attributes
			root_obj.setName(folder.getName());

		XMI_File folder_xmi = new XMI_File();
		folder_xmi.Create_XMI_File(fileURI);//fileURI
		folder_xmi.getFile_res().getContents().add(root_obj);
		folder_xmi.Save_XMI();
		
		//Search the file
		IContainer fol_parent = folder.getParent();
		IFile file_parent = null;
		if (fol_parent instanceof IProject) {
			file_parent = fol_parent.getFile(new Path(fol_parent.getName().concat(".xmi")));
		} else {
			file_parent = getParentFile(fol_parent);
		}
		
		if (file_parent == null) {
			
			MessageDialog.openError(getShell(), "Error", "The parent file cannot be found");
			return;
		}

		XMI_File file_xmi = new XMI_File(URI.createPlatformResourceURI(file_parent.getFullPath().toString(),true),folder_xmi.getFile_reset());		
		
		((EList<EObject>)file_xmi.Get_Root().eGet(file_xmi.Get_Root().eClass().getEStructuralFeature("configs"), true)).add(folder_xmi.Get_Root());
		file_xmi.Save_XMI();				
		
		monitor.worked(1);
		
	}

	private IFile getParentFile(IContainer folder) {
		
		for (int i = 1; i <= 1; i++) {
			IFile file = folder.getFile(new Path(folder.getName().concat("." + i)));
			if (file.exists())
				return file;						
		}		
		return null;
	}
	
	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "org.eclipse.modular.project", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}
	
