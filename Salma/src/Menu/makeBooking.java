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
import Payment.Payment;
import User.Customer;
import User.PremiumCustomer;
import User.Stylist;
import User.User;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class makeBooking {

	Calendar calendar = Calendar.getInstance(); 
	Calendar selection = Calendar.getInstance();
	
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
	Double sPricing = new Double(0);
	JLabel inSpecialization;
	JLabel inName;
	JLabel inUUID;
	DateFormat dateformat = new SimpleDateFormat("EEEE ,dd-MM-YYYY");
	String bookDate = dateformat.format(calendar.getTime());
	private JLabel lblPricing;
	private JLabel inPricing;
	private JTextField txtYourBalance;
	private JLabel lblNewLabel;

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
			model.addColumn("Price");
			int num = 1;
			for(User s : Main.stylistdata){
				model.addRow(new Object[]{
						num++,
						s.getUUID(),
						s.getNama(),
						((Stylist)s).getSpecialization(),
						((Stylist)s).getPricing()
				});
			}
			stylistTable.setModel(model);
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(350, 150, 617, 442);
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
				sPricing = Double.parseDouble(stylistTable.getValueAt(selectedLine, 4).toString());
				inUUID.setText(sUUID);
				inName.setText(sName);
				inSpecialization.setText(sSpecialization);
				txtServiceType.setText(sSpecialization);
				inPricing.setText("" + sPricing);
			}
		});
		stylistTable.setAutoResizeMode(0);
		scrollPane.setViewportView(stylistTable);
		
		JLabel lblPickYourStylish = new JLabel("Pick Your Personal Stylish...");
		lblPickYourStylish.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblPickYourStylish.setBounds(365, 61, 172, 22);
		frame.getContentPane().add(lblPickYourStylish);
		
		JButton btnMakeABook = new JButton("Book");
		btnMakeABook.setBackground(new Color(255, 228, 181));
		btnMakeABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sUUID.equals("") || sName.equals("") || sSpecialization.equals("")){
					System.out.println(sUUID + sName + sSpecialization);
					JOptionPane.showMessageDialog(null, "Please pick a stylist from table!");
				} else {
					ArrayList <Booking> currUserBooking = ((Customer)currUser).getBooklist();
					int transactionsize = currUserBooking.size();
					
					boolean isDateExist = false;
					
					for(int i=0; i<transactionsize; i++) {
						
						String curDate = currUserBooking.get(i).getDateSchedule();
						String dateSchedule = comboBox.getSelectedItem().toString();
						
						if(curDate.equals(dateSchedule)) {
							isDateExist = true;
							break;
						}
					}
					
					if(isDateExist){
						JOptionPane.showMessageDialog(null, "You already make a booking that day!");
					}
					else if (!isDateExist){					
						if(currUser instanceof PremiumCustomer){
							if(((Customer)currUser).getBalance() >= ((PremiumCustomer)currUser).getPricing(sPricing)){
								
								double costReduction = ((PremiumCustomer)currUser).costReduction(sPricing);
								JOptionPane.showMessageDialog(null, "Yey! You just got discount by: " + costReduction);
								
								double pricing = ((PremiumCustomer)currUser).getPricing(sPricing);
								((Customer)currUser).reduceBalance(pricing);
								JOptionPane.showMessageDialog(null, "Your balance has been reduced by: " + pricing + " !");
								
								String dateSchedule = comboBox.getSelectedItem().toString();
								Booking book = new Booking(currUser.getUUID(), sUUID, sName, sSpecialization, dateSchedule, bookDate);
								((Customer)currUser).booklist.add(book);
								((Customer)currUser).setnTransaksi(((Customer)currUser).getnTransaksi() + 1);
								
								JOptionPane.showMessageDialog(null, "Book Added Successfully! Printing Your Payment Receipt...");
								Payment paymentTemp = new Payment(dateformat.format(calendar.getTime()), sSpecialization, sPricing);
								((Customer)currUser).addPayment(paymentTemp);
								frame.dispose();
								new manageMenu(currUser);
							} else {
								JOptionPane.showMessageDialog(null, "Your balance is Insufficient! Please Top Up your balance!");
							}
							
						} else {
							if(((Customer)currUser).getBalance() >= sPricing){
								((Customer)currUser).reduceBalance(sPricing);
								double pricing = (double)sPricing;
								JOptionPane.showMessageDialog(null, "Your saldo has been reduced by: " + pricing + " !");
								String dateSchedule = comboBox.getSelectedItem().toString();
								Booking book = new Booking(currUser.getUUID(), sUUID, sName, sSpecialization, dateSchedule, bookDate);
								((Customer)currUser).booklist.add(book);
								((Customer)currUser).setnTransaksi(((Customer)currUser).getnTransaksi() + 1);
								JOptionPane.showMessageDialog(null, "Book Added Successfully! Printing Your Payment Receipt...");
								Payment paymentTemp = new Payment(dateformat.format(calendar.getTime()), sSpecialization, sPricing);
								((Customer)currUser).addPayment(paymentTemp);
								JOptionPane.showMessageDialog(null, "Book Added Successfully!");
								frame.dispose();
								new manageMenu(currUser);
							} else {
								JOptionPane.showMessageDialog(null, "Your Saldo is Insufficient! Please Top Up your Saldo!");
							}
						}
					}
				}
			}
		});
		btnMakeABook.setBounds(365, 227,105, 47);
		frame.getContentPane().add(btnMakeABook);
		
		txtServiceType = new JTextField();
		txtServiceType.setText("Service Type..");
		txtServiceType.setBounds(365, 164,133, 20);
		frame.getContentPane().add(txtServiceType);
		txtServiceType.setColumns(10);
		txtServiceType.setEditable(false);
		
		JLabel lblServiceOrder = new JLabel("Service Order");
		lblServiceOrder.setBounds(365, 139, 76, 14);
		frame.getContentPane().add(lblServiceOrder);
		
		
		String[] schedule = new String[15];
		
		for(int i=1; i<=7; i++)
		{
			selection.add(Calendar.DAY_OF_YEAR, 1);
			
			schedule[i] = dateformat.format(selection.getTime());
		}
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 222, 173));

		comboBox.setSelectedItem("Pick a schedule");
		
		for(int i=1; i<=7; i++)
		{
			comboBox.addItem(schedule[i]);
		}
		
		comboBox.setBounds(365, 195, 133, 21);
		comboBox.setToolTipText("Pick a schedule!");
		
		
		frame.getContentPane().add(comboBox);
		
		dateShowlbl = new JTextField();
		dateShowlbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateShowlbl.setBounds(365, 94, 133, 30);
		
		dateShowlbl.setEditable(false);
		dateShowlbl.setText(dateformat.format(calendar.getTime()));
		
		frame.getContentPane().add(dateShowlbl);
		dateShowlbl.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(365, 285, 196, 105);
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
		
		lblPricing = new JLabel("Pricing");
		lblPricing.setBounds(10, 81, 71, 14);
		panel.add(lblPricing);
		
		inPricing = new JLabel("Please select a data..");
		inPricing.setBounds(106, 81, 46, 14);
		panel.add(inPricing);
		
		inSpecialization = new JLabel("Please select a data..");
		inSpecialization.setBounds(106, 56, 46, 14);
		panel.add(inSpecialization);
		
		txtYourBalance = new JTextField();
		txtYourBalance.setText("Your Balance");
		txtYourBalance.setBounds(72, 389, 86, 20);
		txtYourBalance.setText(((Customer)currUser).getBalance().toString());
		txtYourBalance.setEditable(false);
		frame.getContentPane().add(txtYourBalance);
		txtYourBalance.setColumns(10);
		
		JLabel lblCurrBalance = new JLabel("Curr Balance:");
		lblCurrBalance.setBounds(72, 369, 66, 14);
		frame.getContentPane().add(lblCurrBalance);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/background.jpg")));
		lblNewLabel.setBounds(0, 0, 297, 464);
		frame.setUndecorated(true);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				new manageMenu(currUser);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/close.png")));
		lblNewLabel_1.setBounds(559, 21, 32, 47);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
