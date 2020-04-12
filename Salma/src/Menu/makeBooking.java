package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class makeBooking {

	private JFrame frame;
	private JTable stylistTable;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					makeBooking window = new makeBooking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public makeBooking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 592, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		stylistTable = new JTable();
		stylistTable.setBounds(53, 66, 204, 271);
		frame.getContentPane().add(stylistTable);
		
		JLabel lblPickYourStylish = new JLabel("Pick Your Personal Stylish...");
		lblPickYourStylish.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblPickYourStylish.setBounds(53, 37, 172, 22);
		frame.getContentPane().add(lblPickYourStylish);
		
		JButton btnMakeABook = new JButton("Make a Book!");
		btnMakeABook.setBounds(377, 244, 99, 33);
		frame.getContentPane().add(btnMakeABook);
		
		textField = new JTextField();
		textField.setBounds(356, 93, 134, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblStylishUuid = new JLabel("Stylish UUID");
		lblStylishUuid.setBounds(355, 66, 68, 14);
		frame.getContentPane().add(lblStylishUuid);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(356, 147, 134, 20);
		frame.getContentPane().add(textField_1);
	}
}
