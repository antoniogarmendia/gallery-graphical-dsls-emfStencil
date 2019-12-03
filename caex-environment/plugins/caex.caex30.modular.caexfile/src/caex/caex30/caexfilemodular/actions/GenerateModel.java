package caex.caex30.caexfilemodular.actions;

import java.io.IOException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import caex.caex30.caexfilemodular.ModularModel;

public class GenerateModel implements IHandler  {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		
	}

	@Override
	public void dispose() {		

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(window!=null)
		{
			ISelectionService selectionservice = (ISelectionService)window.getSelectionService();
			ISelection selection = selectionservice.getSelection();
			TreeSelection treeselection = (TreeSelection)selection;
			Object firstelement = treeselection.getFirstElement();
			if(firstelement instanceof IProject){

				IProject pro = (IProject)firstelement;
				URI modelUri = URI.createPlatformResourceURI(pro.getName() + "/complete_diagram.caex",true);
				ModularModel mModel = new ModularModel();

				try {

					mModel.createCompleteModel(pro,modelUri);
					pro.refreshLocal(IResource.DEPTH_ONE, null);
			
				} catch (CoreException | IOException e) {
					
					e.printStackTrace();
				} 
			
			MessageDialog.openInformation(
				window.getShell(),
				"Completed",
				"Generate Diagram was executed.");
			
			}
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	@Override
	public boolean isHandled() {
		
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {		

	}
}

