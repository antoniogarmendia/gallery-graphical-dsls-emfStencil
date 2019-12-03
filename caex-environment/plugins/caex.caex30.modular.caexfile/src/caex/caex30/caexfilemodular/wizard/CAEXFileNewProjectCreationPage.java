package caex.caex30.caexfilemodular.wizard;

import java.util.Arrays;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import caex.caex30.caex.CAEXFile;
import caex.caex30.caex.ChangeMode;
import caex.caex30.caex.impl.CAEXFactoryImpl;


public class CAEXFileNewProjectCreationPage extends WizardPage {

	private Composite container;
	//Attributes
	private Label lbl_changeMode;
    private Combo cmb_changeMode;		
	private Label lbl_fileName;
	private Text txt_fileName;
	private Label lbl_schemaVersion;
	private Text txt_schemaVersion;
	private CAEXFile root;
	//Select Model 
	private Button create_project;
	private Text txt_loc;
	private Button btn_select;
	private String diagram_address;

	public CAEXFileNewProjectCreationPage(String pageName) {
		super(pageName);
		diagram_address = null;
		
		root = CAEXFactoryImpl.eINSTANCE.createCAEXFile();
	}

	public CAEXFileNewProjectCreationPage(String pageName, String title,
			ImageDescriptor titleImage) {

		super(pageName, title, titleImage);
	}

	@Override
	public void createControl(Composite parent) {
				    
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		
		
		//Attributes
		lbl_changeMode = new Label(container, SWT.NONE);		
			lbl_changeMode.setText("changeMode: ");
		cmb_changeMode = new Combo (container, SWT.READ_ONLY);
		cmb_changeMode.setItems(Arrays.stream(ChangeMode.values()).map(Enum::name).toArray(String[]::new));
		new Label(container, SWT.NONE);	
		lbl_fileName = new Label(container, SWT.NONE);		
			lbl_fileName.setText("Project Name(fileName): ");	
		txt_fileName = new Text(container, SWT.BORDER | SWT.SINGLE );
		txt_fileName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		new Label(container, SWT.NONE);	
		lbl_schemaVersion = new Label(container, SWT.NONE);		
			lbl_schemaVersion.setText("schemaVersion: ");
		txt_schemaVersion = new Text(container, SWT.BORDER | SWT.SINGLE );
		txt_schemaVersion.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		new Label(container, SWT.NONE);	
		
		
		//Add Listeners
		cmb_changeMode.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				String result = cmb_changeMode.getText();
				root.setChangeMode(ChangeMode.getByName(result.toLowerCase()));
				Validate_Form();
			}
		});		
		
		txt_fileName.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				
				root.setFileName(txt_fileName.getText());
				Validate_Form();
			}
		});		
		txt_schemaVersion.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				
				root.setSchemaVersion(txt_schemaVersion.getText());
				Validate_Form();
			}
		});		
		
		//Select Model
		create_project = new Button(container, SWT.CHECK);
		create_project.setText("Select Model");
		create_project.setSelection(false);
		
		create_project.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				if(create_project.getSelection()){
					cmb_changeMode.setEnabled(false);
					txt_fileName.setEnabled(false);
					txt_schemaVersion.setEnabled(false);
					txt_loc.setEnabled(true);
					btn_select.setEnabled(true);
					diagram_address = (txt_loc.getText()!="")?txt_loc.getText():null;
					if(diagram_address==null)
						setPageComplete(false);
					else
						setPageComplete(true);
				}		
				else
				{
					cmb_changeMode.setEnabled(true);
					txt_fileName.setEnabled(true);
					txt_schemaVersion.setEnabled(true);
					txt_loc.setEnabled(false);
					btn_select.setEnabled(false);
					diagram_address = null;
					Validate_Form();
				}				
			}
			
		});
		
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lbl_loc = new Label(container, SWT.NONE);
		lbl_loc.setText("Location: ");
				
		txt_loc = new Text(container, SWT.BORDER | SWT.SINGLE);
		txt_loc.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		txt_loc.setEnabled(false);
		
		txt_loc.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				if(txt_loc.getText()!=""){
					diagram_address = txt_loc.getText();
					setPageComplete(true);
					}
				else{
					diagram_address = null;
					setPageComplete(false);
				}
			}
		});
		
		btn_select = new Button(container, SWT.PUSH);
		btn_select.setText("Browse");
		btn_select.setEnabled(false);
		btn_select.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
				dialog.setFilterExtensions(new String [] {"*.xmi","*.*"});				
				diagram_address = dialog.open();	
				if(diagram_address!=null){
					txt_loc.setText(diagram_address);
					setPageComplete(true);
				}
			}				
			
		});
		
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(false);

	}
	

	@Override
	public boolean canFlipToNextPage() {
		//return super.canFlipToNextPage();
		return false;
	}

	public void Validate_Form()
	{
		setPageComplete(false);
			if(cmb_changeMode.getText().equals(""))
				return;
			if(txt_fileName.getText().equals(""))
				return;
			if(txt_schemaVersion.getText().equals(""))
				return;
		setPageComplete(true);
	}
	
	public CAEXFile getRoot()
	{
		return this.root;
	}
	
	public String getDiagram_address() {
		return diagram_address;
	}

}


