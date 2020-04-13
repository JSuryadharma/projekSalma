package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Main.Main;
import Payment.Booking;
import User.Stylist;
import User.User;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class makeBooking {

	Calendar calendar = Calendar.getInstance(); 
	
	private JFrame frame;
	private JTable stylistTable;
	private JTextField txtServiceType;
	private User currUser = new User("", "", "", "");
	private JTextField dateShowlbl;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	String sUUID = new String("");
	String sName = new String("");
	String sSpecialization = new String("");
	JLabel inSpecialization;
	JLabel inName;
	JLabel inUUID;
	private JButton btnBacktoManageMenu;

	/**
	 * Create the application.
	 */
	public makeBooking(User currUser) {
		this.currUser = currUser;
		initialize();
		load_table();
	}
	
	public void load_table() {
		if(Main.stylistdata.size() == 0){
			JOptionPane.showMessageDialog(null, "Sorry there isn't any stylist data to show.");
			frame.dispose();
			new manageMenu(currUser);
		} else {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("No.");
			model.addColumn("UUID");
			model.addColumn("Name");
			model.addColumn("Specialization");
			int num = 1;
			for(User s : Main.stylistdata){
				model.addRow(new Object[]{
						num++,
						s.getUUID(),
						s.getNama(),
						((Stylist)s).getSpecialization(),
				});
			}
			stylistTable.setModel(model);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 592, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 66, 204, 271);
		frame.getContentPane().add(scrollPane);
		
		stylistTable = new JTable();
		stylistTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedLine = stylistTable.getSelectedRow();
				sUUID = stylistTable.getValueAt(selectedLine, 1).toString();
				sName = stylistTable.getValueAt(selectedLine, 2).toString();
				sSpecialization = stylistTable.getValueAt(selectedLine, 3).toString();
				inUUID.setText(sUUID);
				inName.setText(sName);
				inSpecialization.setText(sSpecialization);
				txtServiceType.setText(sSpecialization);
			}
		});
		stylistTable.setAutoResizeMode(0);
		scrollPane.setViewportView(stylistTable);
		
		JLabel lblPickYourStylish = new JLabel("Pick Your Personal Stylish...");
		lblPickYourStylish.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblPickYourStylish.setBounds(53, 37, 172, 22);
		frame.getContentPane().add(lblPickYourStylish);
		
		JButton btnMakeABook = new JButton("Book");
		btnMakeABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sUUID.equals("") || sName.equals("") || sSpecialization.equals("")){
					System.out.println(sUUID + sName + sSpecialization);
					JOptionPane.showMessageDialog(null, "Please pick a stylist from table!");
				} else {
					String dateSchedule = comboBox.getSelectedItem().toString();
					Booking book = new Booking(currUser.getUUID(), sUUID, sName, sSpecialization, dateSchedule);
					currUser.booklist.add(book);
					JOptionPane.showMessageDialog(null, "Book Added Successfully!");
					frame.dispose();
					new manageMenu(currUser);
				}
			}
		});
		btnMakeABook.setBounds(298, 201,133, 47);
		frame.getContentPane().add(btnMakeABook);
		
		txtServiceType = new JTextField();
		txtServiceType.setText("Service Type..");
		txtServiceType.setBounds(355, 105,133, 20);
		frame.getContentPane().add(txtServiceType);
		txtServiceType.setColumns(10);
		
		JLabel lblServiceOrder = new JLabel("Service Order");
		lblServiceOrder.setBounds(355, 80, 76, 14);
		frame.getContentPane().add(lblServiceOrder);
		
		DateFormat dateformat = new SimpleDateFormat("EEEE      ,dd-MM-YYYY");
		
		String[] schedule = new String[15];
		
		for(int i=1; i<=7; i++)
		{
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			
			schedule[i] = dateformat.format(calendar.getTime());
		}
		
		comboBox = new JComboBox();

		comboBox.addItem("Pick a schedule");
		
		for(int i=1; i<=7; i++)
		{
			comboBox.addItem(schedule[i]);
		}
		
		comboBox.setBounds(357, 150, 133, 21);
		comboBox.setToolTipText("Pick a schedule!");
		
		
		frame.getContentPane().add(comboBox);
		
		dateShowlbl = new JTextField();
		dateShowlbl.setBounds(326, 22, 204, 30);
		
		dateShowlbl.setEditable(false);
		dateShowlbl.setText(dateformat.format(calendar.getTime()));
		
		frame.getContentPane().add(dateShowlbl);
		dateShowlbl.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(326, 267, 196, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUUID = new JLabel("UUID:");
		lblUUID.setBounds(10, 11, 71, 14);
		panel.add(lblUUID);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 32, 71, 14);
		panel.add(lblName);
		
		JLabel lblSpecialization = new JLabel("Specialization:");
		lblSpecialization.setBounds(10, 56, 71, 14);
		panel.add(lblSpecialization);
		
		inUUID = new JLabel("Please select a data..");
		inUUID.setBounds(106, 11, 46, 14);
		panel.add(inUUID);
		
		
		inName = new JLabel("Please select a data..");
		inName.setBounds(106, 32, 46, 14);
		panel.add(inName);
		
		inSpecialization = new JLabel("Please select a data..");
		inSpecialization.setBounds(106, 56, 46, 14);
		panel.add(inSpecialization);
		
		btnBacktoManageMenu = new JButton("Back to Manage Menu");
		btnBacktoManageMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new manageMenu(currUser);
			}
		});
		btnBacktoManageMenu.setBounds(441, 201, 133, 47);
		frame.getContentPane().add(btnBacktoManageMenu);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
