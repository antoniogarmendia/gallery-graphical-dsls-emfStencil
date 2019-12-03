package caex.caex30.caexfilemodular.wizard.file;

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

import java.io.*;
import caex.caex30.caexfilemodular.XMI_File;

import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.URI;


import caex.caex30.caex.SystemUnitClass;
import caex.caex30.caex.ChangeMode;
import caex.caex30.caex.impl.CAEXFactoryImpl;


public class SystemUnitClassCreateFileWizard extends Wizard implements INewWizard {
	private SystemUnitClassCreateFileWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for SystemUnitClassCreateFileWizard.
	 */
	public SystemUnitClassCreateFileWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new SystemUnitClassCreateFileWizardPage(selection);
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
		final String attr_changeMode = page.Get_changeMode();	
		final String attr_iD = page.Get_iD();	
		final String attr_refBaseClassPath = page.Get_refBaseClassPath();	
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName,
					attr_changeMode,
					attr_iD,
					attr_refBaseClassPath,
					 monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
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
	 *@throws IOException
	 */

	private void doFinish(
		String containerName,
		String fileName,
		String attr_changeMode,	
		String attr_iD,	
		String attr_refBaseClassPath,	
		IProgressMonitor monitor)
		throws CoreException, IOException  {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.");
		}
		// Get the URI of the model file.
		URI fileURI = URI.createPlatformResourceURI(resource.getFullPath().toString().concat("/").concat(fileName), true);
			
		//Add the root to the object
		SystemUnitClass rootObject = CAEXFactoryImpl.eINSTANCE.createSystemUnitClass();
		//Set the Attributes
		rootObject.setChangeMode(ChangeMode.get(attr_changeMode));		
		rootObject.setID(attr_iD);
		rootObject.setName(fileName.substring(0, fileName.lastIndexOf('.')));
		rootObject.setRefBaseClassPath(attr_refBaseClassPath);
		
		//Save XMI file
		XMI_File child_xmi = new XMI_File();
		child_xmi.Create_XMI_File(fileURI);//fileURI
		child_xmi.getFile_res().getContents().add(rootObject);
		child_xmi.Save_XMI();
		
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));
        
		//Search the file
		IContainer fol_parent = file.getParent();
		IFile file_parent = getParentFile(fol_parent);
		
		if (file_parent == null) {
			
			MessageDialog.openError(getShell(), "Error", "The parent file cannot be found");
			return;
		}
		
		XMI_File file_xmi = new XMI_File(URI.createPlatformResourceURI(file_parent.getFullPath().toString(),true),child_xmi.getFile_reset());		
		
		((EList<EObject>)file_xmi.Get_Root().eGet(file_xmi.Get_Root().eClass().getEStructuralFeature("systemUnitClass"), true)).add(child_xmi.Get_Root());
		file_xmi.Save_XMI();
	
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}
	
	private IFile getParentFile(IContainer folder) {
		
		if (folder instanceof IProject) {
			IFile file = folder.getFile(new Path(folder.getName().concat(".xmi")));
			if (file.exists())
				return file;
		} else {
			for (int i = 1; i <=  4; i++) {
				IFile file = folder.getFile(new Path(folder.getName().concat("." + i)));
				if (file.exists())
					return file;						
			}	
		}
		return null;	
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 */

	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "test_editor", IStatus.OK, message, null);
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

