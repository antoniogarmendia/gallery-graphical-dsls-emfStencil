package org.miso.mindstorms.sample.sirius.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IEditorLauncher;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.CreateRepresentationCommand;
import org.eclipse.sirius.business.api.dialect.command.MoveRepresentationCommand;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.session.DefaultLocalSessionCreationOperation;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionCreationOperation;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSession;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.tools.internal.command.PrepareNewAnalysisCommand;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelection;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallbackWithConfimation;
import org.eclipse.sirius.ui.business.internal.commands.ChangeViewpointSelectionCommand;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.ViewpointFactory;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

import org.miso.mindstorms.sample.sirius.editor.dialog.DiagramSelectionDialog;
import org.miso.mindstorms.sample.sirius.editor.dialog.ModularAnalysisSelector;
import org.miso.mindstorms.sample.sirius.editor.dialog.ViewpointRepresentationDialog;
import org.miso.mindstorms.sample.sirius.editor.label.LabelProviderDRepresentation;
import org.miso.mindstorms.sample.sirius.editor.label.LabelProviderDescription;
import org.miso.mindstorms.sample.sirius.editor.label.LabelProviderDiagram;

public class GraphicalSiriusEditor implements IEditorLauncher {

		public static final String DIAGRAM_EXTENSION = "aird";
	
	@Override
	public void open(IPath filePath) {

		IProgressMonitor monitor = new NullProgressMonitor();
		URIConverter converter = new ExtensibleURIConverterImpl();
		// Check if projectName .aird exist
		Session projectSession = getProjectAird(filePath);
		
		if (projectSession.isOpen() == false)
			projectSession.open(monitor);

		URI fileUri = URI
				.createFileURI(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + File.separator);
		URI platformURI = URI.createPlatformResourceURI("/", false);
		converter.getURIMap().put(fileUri, platformURI);

		URI anFileURI = converter.normalize(URI.createFileURI(filePath.toFile().getAbsolutePath()));

		// Get semantic resource
		EObject semanticElement = null;
		try {
			semanticElement = getSemanticElement(projectSession, anFileURI, monitor);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DRepresentation showRepresentation = null;
		Collection<DRepresentation> allRepresentationDiagram = DialectManager.INSTANCE
				.getRepresentations(semanticElement, projectSession);
		
		boolean hasRepresentations = allRepresentationDiagram.size() > 0?true:false;
		DiagramSelectionDialog diagDiagram = new DiagramSelectionDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), new LabelProviderDiagram(),hasRepresentations);

		diagDiagram.setElements(allRepresentationDiagram.toArray());
		if (diagDiagram.open() == Dialog.OK) {

			// Create New Representation
			if (diagDiagram.isNewDiagram() == true) {

				String name = diagDiagram.getDiagramName();

				final Set<Viewpoint> newSelectedViewpoints = ViewpointSelection
						.getViewpoints(anFileURI.fileExtension());
				
				//If the viewpoint is one and has a single descriptor create the diagram automatically
				if (newSelectedViewpoints.size() == 1 && newSelectedViewpoints.iterator().next().getOwnedRepresentations().size()==1) {
					
					Viewpoint selectedViewpoint = newSelectedViewpoints.iterator().next();
					
					Viewpoint correspondingViewpoint = addView(projectSession, anFileURI.fileExtension(), selectedViewpoint,
							monitor);
					
					RepresentationDescription description = getDescriptor(correspondingViewpoint, newSelectedViewpoints.iterator().next().getOwnedRepresentations().get(0));
					
					showRepresentation = createDiagram(selectedViewpoint, description, projectSession, name, semanticElement, anFileURI, monitor);
					
				} else {			
					//Test ViewPoint dialog
					ViewpointRepresentationDialog dialogSelectDescriptor = new ViewpointRepresentationDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
							newSelectedViewpoints);
					if (dialogSelectDescriptor.open() == Dialog.OK) {
						
						Viewpoint selectedViewpoint = dialogSelectDescriptor.getSelectedViewPoint();
						
						Viewpoint correspondingViewpoint = addView(projectSession, anFileURI.fileExtension(), selectedViewpoint,
								monitor);
						
						RepresentationDescription description = getDescriptor(correspondingViewpoint, dialogSelectDescriptor.getRepresentationDescriptor());						
						
						showRepresentation = createDiagram(selectedViewpoint, description, projectSession, name, semanticElement, anFileURI, monitor);									
					
					} else
						return;
				}
				
			} else {

				Object[] objectRepre = diagDiagram.getResult();

				if (objectRepre[0] instanceof DRepresentation)
					showRepresentation = (DRepresentation) objectRepre[0];
			}
		}

		DialectUIManager.INSTANCE.openEditor(projectSession, showRepresentation, monitor);
	}
	
	private DRepresentation createDiagram(Viewpoint viewpoint, RepresentationDescription description, Session currentSession, String name, EObject semanticElement,
			URI anFileURI, IProgressMonitor monitor) {
		
		URIConverter converter = new ExtensibleURIConverterImpl();
		// Before create the new representation change the DAnalysisSelector interface
		URI pickedResourceUri = anFileURI.trimFileExtension()
				.appendFileExtension(DIAGRAM_EXTENSION);				
		((DAnalysisSession) currentSession).setAnalysisSelector(new ModularAnalysisSelector(currentSession.getSessionResource().getURI(),pickedResourceUri));
		// End
		DRepresentation showRepresentation = createRepresentation(currentSession, semanticElement, name, description, monitor);
		currentSession.save(monitor);
		
		boolean existPickedResource = converter.exists(pickedResourceUri, null);
		if (existPickedResource == false)
			extractAirRepresentation(currentSession, semanticElement, anFileURI);

		currentSession.save(monitor);
		
		return showRepresentation;	
	}	

	private RepresentationDescription getDescriptor(Viewpoint correspondingViewpoint,
			RepresentationDescription representationDescriptor) {
		
		Iterator<RepresentationDescription> listRepresentations = correspondingViewpoint.getOwnedRepresentations().iterator();
			
		while (listRepresentations.hasNext()) {
			RepresentationDescription currentDescriptor = (RepresentationDescription) listRepresentations
					.next();			
			if(currentDescriptor.getLabel().equals(representationDescriptor.getLabel()))
				return currentDescriptor;		
		}	
		
		return null;
	}

	private void extractAirRepresentation(Session currentSession, EObject semanticElement, URI anFileURI) {

		Collection<DRepresentationDescriptor> repDescriptors = DialectManager.INSTANCE
				.getRepresentationDescriptors(semanticElement, currentSession);
		URI pickedResourceUri = anFileURI.trimFileExtension().appendFileExtension(DIAGRAM_EXTENSION);
		Resource pickedResource = createResource(currentSession,
				currentSession.getTransactionalEditingDomain().getResourceSet(), pickedResourceUri);
		final DAnalysis slaveAnalysis = ViewpointFactory.eINSTANCE.createDAnalysis();
		currentSession.getTransactionalEditingDomain().getCommandStack().execute(new PrepareNewAnalysisCommand(
				currentSession.getTransactionalEditingDomain(), pickedResource, slaveAnalysis, currentSession));
		moveRepresentations(currentSession, slaveAnalysis, repDescriptors);
	}
		
	private void moveRepresentations(Session currentSession, final DAnalysis slaveAnalysis,
			Collection<DRepresentationDescriptor> repDescriptors) {
		currentSession.getTransactionalEditingDomain().getCommandStack()
				.execute(new MoveRepresentationCommand(currentSession, slaveAnalysis, repDescriptors));
	}

	private DRepresentation createRepresentation(Session currentSession, EObject semanticElement, String name,
			RepresentationDescription description, IProgressMonitor monitor) {

		boolean isOpen = currentSession.isOpen();
		if (isOpen == false)
			currentSession.open(monitor);

		// Create a new one
		CreateRepresentationCommand createViewCommand = new CreateRepresentationCommand(currentSession, description,
				semanticElement, name, monitor);

		currentSession.getTransactionalEditingDomain().getCommandStack().execute(createViewCommand);

		SessionManager.INSTANCE.notifyRepresentationCreated(currentSession);

		return createViewCommand.getCreatedRepresentation();
	}

	private Viewpoint addView(Session currentSession, String extension, Viewpoint viewpoint, IProgressMonitor monitor) {

		TransactionalEditingDomain domain = currentSession.getTransactionalEditingDomain();
		Set<Viewpoint> viewpoints = new HashSet<Viewpoint>();
		final ViewpointSelection.Callback callback = new ViewpointSelectionCallbackWithConfimation();
		Viewpoint correspondingViewpoint = SiriusResourceHelper.getCorrespondingViewpoint(currentSession, viewpoint);
		viewpoints.add(correspondingViewpoint);

		Command command = new ChangeViewpointSelectionCommand(currentSession, callback, viewpoints,
				new HashSet<Viewpoint>(), false, monitor);
		domain.getCommandStack().execute(command);

		currentSession.save(monitor);
		return correspondingViewpoint;
	}
	
	private void addResource(Session geProjectSession, URI anFileURI, IProgressMonitor monitor) {

		// Adding the resource also to Sirius session
		AddSemanticResourceCommand addCommandToSession = new AddSemanticResourceCommand(geProjectSession, anFileURI,
				monitor);
		geProjectSession.getTransactionalEditingDomain().getCommandStack().execute(addCommandToSession);
		geProjectSession.save(monitor);
		// END
	}

	private Session getProjectAird(IPath filePath) {

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = Path.fromOSString(filePath.toFile().getAbsolutePath());
		IFile file = workspace.getRoot().getFileForLocation(location);
		IProject project = file.getProject();

		IProgressMonitor monitor = new NullProgressMonitor();
		URIConverter converter = new ExtensibleURIConverterImpl();

		URI sessionResourceURI = URI
				.createPlatformResourceURI(project.getName() + "/" + project.getName().concat(".aird"), true);
		boolean existSession = converter.exists(sessionResourceURI, null);
		Session currentSession = null;
		if (existSession == false) {
			currentSession = this.createSession(sessionResourceURI, monitor);
		} else
			currentSession = SessionManager.INSTANCE.getSession(sessionResourceURI, monitor);

		return currentSession;
	}

	private Session createSession(URI sessionResourceURI, IProgressMonitor monitor) {
		// Create Session Operation
		SessionCreationOperation oper = new DefaultLocalSessionCreationOperation(sessionResourceURI, monitor);
		// Create Session
		try {
			oper.execute();
			Session createdSession = oper.getCreatedSession();
			createdSession.save(monitor);
			// END
			return createdSession;
		} catch (CoreException e) {

			e.printStackTrace();
		}
		return null;
	}

	private Viewpoint selectDRepresentationDialog(Set<Viewpoint> referencers) {

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), new LabelProviderDRepresentation());
		dialog.setTitle("Select Diagram");
		dialog.setMessage("Select a String (* = any string, ? = any char):");
		dialog.setElements(referencers.toArray());

		if (dialog.open() == Dialog.OK)
			return (Viewpoint) dialog.getFirstResult();
		else
			return null;
	}

	private RepresentationDescription selectRepresentationDialog(Collection<RepresentationDescription> descriptions) {

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), new LabelProviderDescription());
		dialog.setTitle("Select the Representation");
		dialog.setMessage("Select a String (* = any string, ? = any char):");
		dialog.setElements(descriptions.toArray());

		if (dialog.open() == Dialog.OK)
			return (RepresentationDescription) dialog.getFirstResult();
		else
			return null;
	}

	private Resource createResource(Session currentSession, ResourceSet resourceSet, URI pickedResourceUri) {

		final ResourceSet set = currentSession.getTransactionalEditingDomain().getResourceSet();
		return set.createResource(pickedResourceUri);
	}

	private EObject getSemanticElement(Session currentSession, URI anFileURI, IProgressMonitor monitor)
			throws Exception {

		EObject semanticElement = findSemanticElement(currentSession, anFileURI);

		if (semanticElement == null) {

			addResource(currentSession, anFileURI, monitor);
			semanticElement = findSemanticElement(currentSession, anFileURI);
			if (semanticElement == null)
				throw new Exception("Error! Failed to add semantic resource! "
						+ currentSession.getSemanticResources().iterator().next().getContents().get(0));
		}

		return semanticElement;
	}

	private EObject findSemanticElement(Session currentSession, URI anFileURI) {

		Iterator<Resource> itResources = currentSession.getSemanticResources().iterator();
		while (itResources.hasNext()) {
			Resource resource = (Resource) itResources.next();
			if (resource.getURI().path().equals(anFileURI.path()))
				return resource.getContents().get(0);
		}

		return null;
	}
}
