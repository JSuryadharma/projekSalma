package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class makeBooking {

	Calendar calendar = Calendar.getInstance(); 
	
	private JFrame frame;
	private JTable stylistTable;
	private JTextField textField;

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
		
		JButton btnMakeABook = new JButton("Book");
		btnMakeABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMakeABook.setBounds(355, 203,133, 47);
		frame.getContentPane().add(btnMakeABook);
		
		textField = new JTextField();
		textField.setBounds(355, 105,133, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblStylishUuid = new JLabel("Stylish UUID");
		lblStylishUuid.setBounds(355, 66, 76, 14);
		frame.getContentPane().add(lblStylishUuid);
		
		DateFormat dateformat = new SimpleDateFormat("EEEE      ,dd-MM-YYYY");
		
		String[] schedule = new String[15];
		
		for(int i=1; i<=7; i++)
		{
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			
			schedule[i] = dateformat.format(calendar.getTime());
		}
		
		JComboBox comboBox = new JComboBox();

		comboBox.addItem("Pick a schedule");
		
		for(int i=1; i<=7; i++)
		{
			comboBox.addItem(schedule[i]);
		}
		
		comboBox.setBounds(357, 150, 133, 21);
		comboBox.setToolTipText("Pick a schedule!");
		
		
		frame.getContentPane().add(comboBox);
		frame.setVisible(true);
	}
}
