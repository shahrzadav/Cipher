import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class cipher {

	protected Shell shell;
	private Text Inputtext;
	private Label lblCipherText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			cipher window = new cipher();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Encryption");
		
		Inputtext = new Text(shell, SWT.BORDER);
		Inputtext.setBounds(58, 59, 80, 31);
		
		
		final Label lblCipherText = new Label(shell, SWT.NONE);
		lblCipherText.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 9, SWT.BOLD));
		lblCipherText.setBounds(53, 158, 327, 60);
		
		Button btnEncrypt = new Button(shell, SWT.NONE);
		btnEncrypt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String input;
				try {
				input = Inputtext.getText();
				}
				catch(Exception exc){
					MessageDialog.openError(shell , "Error", "Bad Input");
					return;
				}
				lblCipherText.setText("CipherText: " + input);
			}
		});
		btnEncrypt.setBounds(58, 96, 105, 35);
		btnEncrypt.setText("Encrypt");
		
		
		
		Label lblInput = new Label(shell, SWT.NONE);
		lblInput.setBounds(57, 30, 81, 25);
		lblInput.setText("input");
		
	

	}
}
