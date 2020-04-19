package Menu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Payment.Booking;
import User.Customer;
import User.User;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JComboBox;

public class editBooking {

	private JFrame frame;
	private User currUser = new User("", "", "", "");
	private JTable bookingTable;
	private JScrollPane scrollPane;
	private JLabel lblEditBookings;
	private Calendar schedule = Calendar.getInstance();
	DateFormat dateformat = new SimpleDateFormat("EEEE ,dd-MM-YYYY");
	private JComboBox comboBox;
	String dateBook = dateformat.format(schedule.getTime());
	private String cUUID;
	private String sUUID;
	private String sName;
	private String serviceOrder;
	private String dateSchedule;
	private int selectedLine;

	public editBooking(User currUser) {
		this.currUser = currUser;
		initialize();
		if(((Customer)currUser).booklist.size() == 0){
			JOptionPane.showMessageDialog(null, "You have no Bookings Data to show!");
			frame.dispose();
			new manageMenu(currUser);
		} else {
			load_table();
		}
	}
	
	public void load_table(){
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("No.");
		model.addColumn("Customer ID");
		model.addColumn("Stylist ID");
		model.addColumn("Stylist Name");
		model.addColumn("Service Order");
		model.addColumn("Date Schedule");
		
		int no = 1;
		
		for(Booking bl : ((Customer)currUser).booklist){
			model.addRow(new Object[]{
					no++,
					bl.getCustomerID(),
					bl.getStylistID(),
					bl.getStylistName(),
					bl.getServiceOrder(),
					bl.getDateSchedule()
		
			});
		}
		
		bookingTable.setModel(model);
		bookingTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		bookingTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		bookingTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		bookingTable.getColumnModel().getColumn(3).setPreferredWidth(50);
		bookingTable.getColumnModel().getColumn(4).setPreferredWidth(50);
		bookingTable.getColumnModel().getColumn(5).setPreferredWidth(50);
		bookingTable.setAutoResizeMode(0);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 749, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back to Manage Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new manageMenu(currUser);
			}
		});
		btnNewButton.setBounds(262, 351, 196, 39);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 45, 299, 295);
		frame.getContentPane().add(scrollPane);
		bookingTable = new JTable();
		bookingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedLine = bookingTable.getSelectedRow();
				cUUID = bookingTable.getValueAt(selectedLine, 1).toString();
				sUUID = bookingTable.getValueAt(selectedLine, 2).toString();
				sName = bookingTable.getValueAt(selectedLine, 3).toString();
				serviceOrder = bookingTable.getValueAt(selectedLine, 4).toString();
				dateSchedule = bookingTable.getValueAt(selectedLine, 5).toString();
				comboBox.setSelectedItem(dateSchedule);
			}
		});
		scrollPane.setViewportView(bookingTable);
		
		lblEditBookings = new JLabel("Edit Bookings");
		lblEditBookings.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		lblEditBookings.setBounds(59, 11, 196, 30);
		frame.getContentPane().add(lblEditBookings);
		
		comboBox = new JComboBox();
		comboBox.setBounds(446, 107, 196, 30);
		DateFormat dateformat = new SimpleDateFormat("EEEE ,dd-MM-YYYY");
		
		String[] scheduleList = new String[15];
		
		for(int i=1; i<=7; i++)
		{
			schedule.add(Calendar.DAY_OF_YEAR, 1);
			
			scheduleList[i] = dateformat.format(schedule.getTime());
		}
		for(int i=1; i<=7; i++){			
			comboBox.addItem(scheduleList[i]);
		}
		comboBox.setSelectedItem(dateSchedule);
		frame.getContentPane().add(comboBox);
		
		JLabel lblChangeSchedule = new JLabel("Change Schedule");
		lblChangeSchedule.setBounds(446, 82, 101, 14);
		frame.getContentPane().add(lblChangeSchedule);
		
		JButton btnUpdateBooking = new JButton("Update Booking");
		btnUpdateBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dateSchedule = comboBox.getSelectedItem().toString();
					if(!dateSchedule.equals("")){
					Booking tempBook = new Booking(cUUID, sUUID, sName, serviceOrder, dateSchedule, dateBook);
					((Customer)currUser).booklist.set(selectedLine, tempBook);
					load_table();
				} else {
					JOptionPane.showMessageDialog(null, "Please pick a replacement date!");
				}
			}
		});
		btnUpdateBooking.setToolTipText("Update your Booking");
		btnUpdateBooking.setBounds(423, 187, 124, 39);
		frame.getContentPane().add(btnUpdateBooking);
		
		JButton btnDeleteBooking = new JButton("Cancel Booking");
		btnDeleteBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((Customer)currUser).booklist.remove(selectedLine);
				JOptionPane.showMessageDialog(null, "Receipt number #" + selectedLine + " has been removed!");
				load_table();
			}
		});
		btnDeleteBooking.setToolTipText("Delete your booking...");
		btnDeleteBooking.setBounds(557, 187, 124, 39);
		frame.getContentPane().add(btnDeleteBooking);
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
