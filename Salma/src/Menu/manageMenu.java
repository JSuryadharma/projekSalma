package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import User.Customer;
import User.Gold;
import User.Platinum;
import User.Silver;
import User.Stylist;
import User.User;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class manageMenu {
	
	private JLabel labelRole = new JLabel("<dynamic>");
	private JFrame manageFrame;
	private User currUser;
	private JTextField dateShowTF;
	DateFormat dateFormat = new SimpleDateFormat("EEEE , dd/MM/YYYY");
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();

	public manageMenu(User currUser) {
		super();
		this.currUser = currUser;
		initialize();
		
		System.out.println(currUser.getClass());
		if(currUser instanceof Stylist)
		{	
			labelRole.setText("Stylist");
		}
		
		else if (currUser instanceof Customer)
		{
			labelRole.setText("Regular Customer");
		}
		
		else if(currUser instanceof Silver)
		{
			labelRole.setText("Premium Silver");
		}
		
		else if(currUser instanceof Gold)
		{
			labelRole.setText("Premium Gold");
		}
		
		else if(currUser instanceof Platinum)
		{
			labelRole.setText("Premium Platinum");
		}
	}

	private void initialize() {
		manageFrame = new JFrame();
		manageFrame.setTitle("SALMA - Manage Menu");
		manageFrame.setBounds(100, 100, 748, 559);
		manageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manageFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Make a booking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageFrame.dispose();
				new makeBooking();
			}
		});
		btnNewButton.setBounds(273, 190, 167, 65);
		manageFrame.getContentPane().add(btnNewButton);
		
		JLabel labelNama = new JLabel("Nama:");
		labelNama.setBounds(42, 35, 56, 16);
		manageFrame.getContentPane().add(labelNama);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(42, 64, 56, 16);
		manageFrame.getContentPane().add(labelEmail);
		
		JLabel lblUuid = new JLabel("UUID:");
		lblUuid.setBounds(42, 96, 56, 16);
		manageFrame.getContentPane().add(lblUuid);
		
		JLabel labelNamaUser = new JLabel(currUser.getNama());
		labelNamaUser.setBounds(110, 35, 500, 16);
		manageFrame.getContentPane().add(labelNamaUser);
		
		JLabel labelEmailUser = new JLabel(currUser.getEmail());
		labelEmailUser.setBounds(110, 64, 500, 16);
		manageFrame.getContentPane().add(labelEmailUser);
		
		JLabel labelUUIDUser = new JLabel(currUser.getUUID());
		labelUUIDUser.setBounds(110, 96, 500, 16);
		manageFrame.getContentPane().add(labelUUIDUser);
		
		JButton buttonBackToMainMenu = new JButton("Back to Main Menu");
		buttonBackToMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageFrame.dispose();
//				manageFrame.setVisible(false);
				new MainMenu();
			}
		});
		buttonBackToMainMenu.setBounds(42, 444, 167, 65);
		manageFrame.getContentPane().add(buttonBackToMainMenu);
		
		JButton editButton = new JButton("Edit a booking");
		editButton.setBounds(273, 266, 167, 65);
		manageFrame.getContentPane().add(editButton);
		
		JButton btnViewBookings = new JButton("View bookings");
		btnViewBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageFrame.dispose();
				new viewBookings(currUser);
			}
		});
		btnViewBookings.setBounds(273, 342, 167, 65);
		manageFrame.getContentPane().add(btnViewBookings);
		
		
		dateShowTF = new JTextField();
		dateShowTF.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		dateShowTF.setBounds(393, 25, 329, 29);
		manageFrame.getContentPane().add(dateShowTF);
		dateShowTF.setColumns(10);
		dateShowTF.setText("Today's date: " + " " + dateFormat.format(date));
		dateShowTF.setEditable(false);
		
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setBounds(42, 129, 56, 16);
		manageFrame.getContentPane().add(lblRole);
		
		lblRole.setVisible(true);
		labelRole.setVisible(true);
		labelRole.setBounds(110, 129, 500, 16);
		manageFrame.getContentPane().add(labelRole);
		manageFrame.setVisible(true);
		
	}
}
