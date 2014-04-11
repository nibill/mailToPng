import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


@SuppressWarnings("serial")
public class Viewer extends JFrame
{

	private JPanel contentPane;
	private JTextField txtMail;
	private String newErrLblTextString = "fill in your email address and hit Save to create a png of your email";
	
	static Viewer frame = new Viewer();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					frame.setResizable(false);
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Viewer()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMail = new JLabel("email:");
		lblMail.setBounds(26, 48, 38, 25);
		contentPane.add(lblMail);
		
		txtMail = new JTextField();
		txtMail.setBounds(74, 50, 345, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		final JLabel lblNewErr = new JLabel(newErrLblTextString);
		lblNewErr.setBounds(26, 79, 393, 36);
		contentPane.add(lblNewErr);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmailValidator emailValidator = new EmailValidator();
			   if(emailValidator.validate(txtMail.getText().trim()))
			   {
					
					Converter conv = new Converter();
					conv.convert(txtMail.getText());
					JFileChooser saveFile = new JFileChooser();
					
					conv.save(saveFile);
					saveFile.setDialogTitle("Save address to png");	
					
					lblNewErr.setForeground(Color.black);
					lblNewErr.setFont(lblNewErr.getFont().deriveFont(11.0f));
					lblNewErr.setText(newErrLblTextString);
					txtMail.setText("");
			   }
			   else 
			   {
			   	lblNewErr.setText("Please insert a valid address!");
			   	lblNewErr.setForeground(Color.red);
			   	lblNewErr.setFont(lblNewErr.getFont().deriveFont(20.0f));
				}
			}
		});
		
		btnSave.setBounds(26, 126, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblTitle = new JLabel("Email to PNG Maker");
		lblTitle.setBounds(74, 25, 125, 14);
		contentPane.add(lblTitle);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(330, 126, 89, 23);
		contentPane.add(btnClose);
	}
}
