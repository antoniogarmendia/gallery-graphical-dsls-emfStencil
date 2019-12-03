package caex.caex30.sirius.editor.dialog;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public class DiagramSelectionDialog extends ElementListSelectionDialog{

	private Text filterText;
	private boolean isNewDiagram;
	private String diagramName;
	private boolean hasRepresentations;
	
	public DiagramSelectionDialog(Shell parent, ILabelProvider renderer, boolean hasRepresentations) {
		super(parent, renderer);
		this.isNewDiagram = false;
		this.hasRepresentations = hasRepresentations;
		setTitle("Select or Create New Diagram");
		setMessage("Select a String (* = any string, ? = any char):");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		
		final Composite contents = (Composite) super.createDialogArea(parent);
		
		Composite cont = new Composite(contents, SWT.NONE);
		GridLayout layout_cont = new GridLayout(1,false);
		GridData grid_cont = new GridData();
		grid_cont.grabExcessVerticalSpace = false;
		grid_cont.grabExcessHorizontalSpace = true;
		grid_cont.horizontalAlignment = GridData.FILL;
		grid_cont.verticalAlignment = GridData.BEGINNING;
		cont.setLayoutData(grid_cont);
		cont.setLayout(layout_cont);
		
		
		Button createNewDiagram = new Button(cont, SWT.CHECK);
		createNewDiagram.setText("Create New Diagram");
		createNewDiagram.setSelection(false);
		
		Composite container = new Composite(cont, SWT.NONE);		
		GridLayout layout = new GridLayout(2,false);
		container.setLayout(layout);		
		
		Label label_name = new Label(container, SWT.NONE);
		label_name.setText("Diagram Name: ");
		
		Text text_name = new Text(container, SWT.BORDER | SWT.SINGLE );
		GridData gd = new GridData();
		gd.grabExcessVerticalSpace = false;
		gd.grabExcessHorizontalSpace = false;
		gd.horizontalAlignment = GridData.FILL_HORIZONTAL;
		gd.verticalAlignment = GridData.BEGINNING;
		text_name.setLayoutData(gd);
		text_name.setEnabled(false);
		
		//Listeners
		createNewDiagram.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(createNewDiagram.getSelection() == true){
					
					text_name.setEnabled(true);
					filterText.setEnabled(false);
					isNewDiagram = true;
				}
				else{
					
					text_name.setEnabled(false);
					filterText.setEnabled(true);	
					isNewDiagram = false;
				}
			}		
			
		});
		
		text_name.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				
				// do nothing			
			}

			@Override
			public void focusLost(FocusEvent e) {
				diagramName = text_name.getText();			
			}
			
		});
		
		
		text_name.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				diagramName = text_name.getText();
				if (diagramName.length() >= 1) {
					getOkButton().setEnabled(true);
				}
				else {
					getOkButton().setEnabled(false);
				}	
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// Do nothing				
			}
		});
				
		if (hasRepresentations == false) {
			filterText.setEnabled(false);	
			createNewDiagram.setSelection(true);
			createNewDiagram.setEnabled(false);
			text_name.setEnabled(true);
			isNewDiagram = true;			
		} else {
			filterText.setEnabled(true);	
		}
			
		return contents;
	}	

	@Override
	protected Text createFilterText(Composite parent) {
		
		filterText = super.createFilterText(parent);
		return filterText;
	}
	
	public boolean isNewDiagram() {
		return isNewDiagram;
	}

	public String getDiagramName() {
		return diagramName;
	}
	
}

