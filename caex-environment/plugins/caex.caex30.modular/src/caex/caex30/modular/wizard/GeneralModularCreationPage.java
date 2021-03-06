package caex.caex30.modular.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class GeneralModularCreationPage extends WizardPage{
	
	private String projectName;
	private String modelUri;

	protected GeneralModularCreationPage(String pageName) {
		super(pageName);
		modelUri = "";
	}
	
	@Override
	public void createControl(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		
		Label labelProjectName = new Label(container, SWT.NONE);
		labelProjectName.setText("Project Name: ");
		
		Text txtProjectName = new Text(container, SWT.BORDER | SWT.SINGLE );		
		txtProjectName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		txtProjectName.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				
				setProjectName(txtProjectName.getText());
				
				if(txtProjectName.getText().equals(""))					
					setPageComplete(false);				
				else
					setPageComplete(true);			
				
			}
		});
		
		//Reverse Engineering
		Button btnSelectModel = new Button(container, SWT.CHECK);
		btnSelectModel.setText("Select Model");
		btnSelectModel.setSelection(false);
				
		new Label(container, SWT.NONE);
		
		Label lblSelectModel = new Label(container, SWT.NONE);
		lblSelectModel.setText("Location: ");
		
		Text txtLocation = new Text(container, SWT.BORDER | SWT.SINGLE);
		txtLocation.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		txtLocation.setEnabled(false);
		
		Button btnBrowse = new Button(container, SWT.PUSH);
		btnBrowse.setText("Browse");
		btnBrowse.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				super.widgetSelected(e);
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
				dialog.setFilterExtensions(new String [] {"*.xmi","*.*"});				
				modelUri = dialog.open();	
				if(modelUri!=null){
					txtLocation.setText(modelUri);
					setPageComplete(true);
				}
			}				
			
		});
		
		btnSelectModel.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(btnSelectModel.getSelection())
					txtLocation.setEnabled(true);				
				else
					txtLocation.setEnabled(false);
				
			}
			
		});
		
		
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(false);
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getDiagramUri() {
		return modelUri;
	}	
	
}
	
