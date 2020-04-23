package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Payment.Booking;
import User.Customer;
import User.User;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class viewBookings {

	private JFrame frame;
	private User currUser = new User("", "", "", "");
	private JTable bookingTable;
	private JScrollPane scrollPane;
	private JLabel lblViewBookings;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	public viewBookings(User currUser) {
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(300, 120, 749, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 79, 598, 295);
		frame.getContentPane().add(scrollPane);
		bookingTable = new JTable();
		scrollPane.setViewportView(bookingTable);
		
		lblViewBookings = new JLabel("View Bookings");
		lblViewBookings.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewBookings.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		lblViewBookings.setBounds(512, 40, 165, 30);
		frame.getContentPane().add(lblViewBookings);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/background.jpg")));
		lblNewLabel.setBounds(-111, -61, 488, 549);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				new manageMenu(currUser);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/xbutton32.png")));
		lblNewLabel_1.setBounds(636, 385, 32, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
