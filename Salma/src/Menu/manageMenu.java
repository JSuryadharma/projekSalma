package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import Main.Main;
import Payment.Booking;
import User.Customer;
import User.Gold;
import User.Platinum;
import User.Silver;
import User.Stylist;
import User.User;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class manageMenu {
	JLabel lblRole = new JLabel("Role:");
	private JLabel labelRole = new JLabel("empty");
	private JFrame manageFrame;
	private User currUser = new User("","","","");
	private JTextField dateShowTF;
	DateFormat dateFormat = new SimpleDateFormat("EEEE , dd/MM/YYYY");
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
	private JTextField balanceTF;
	private JTextField txtYourPricing;

	public manageMenu(User currUser) {
		super();
		this.currUser = currUser;
		initialize();
		
		System.out.println(currUser.getClass());
		lblRole.setVisible(true);
		if(currUser instanceof Stylist)
		{	
			labelRole.setText("Stylist");
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
		
		else if (currUser instanceof Customer)
		{
			labelRole.setText("Regular Customer");
		}
		
		else
		{
			labelRole.setText("None");
		}
		labelRole.setVisible(true);
	}
	
	private void initialize() {
		manageFrame = new JFrame();
		manageFrame.setTitle("SALMA - Manage Menu");
		manageFrame.setBounds(100, 100, 748, 559);
		manageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manageFrame.getContentPane().setLayout(null);
		
		JButton makeButton = new JButton("Make a booking");
		makeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageFrame.dispose();
				new makeBooking(currUser);
			}
		});
		makeButton.setBounds(273, 190, 167, 65);
		manageFrame.getContentPane().add(makeButton);
		
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
		labelUUIDUser.setBounds(108, 96, 500, 16);
		manageFrame.getContentPane().add(labelUUIDUser);
		
		JButton buttonBackToMainMenu = new JButton("Back to Main Menu");
		buttonBackToMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageFrame.dispose();
				new MainMenu();
			}
		});
		buttonBackToMainMenu.setBounds(42, 444, 167, 65);
		manageFrame.getContentPane().add(buttonBackToMainMenu);
		
		JButton editButton = new JButton("Edit a booking");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageFrame.dispose();
				new editBooking(currUser);
			}
		});
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
		
		
		lblRole.setBounds(42, 129, 56, 16);
		manageFrame.getContentPane().add(lblRole);
		
		lblRole.setVisible(false);
		labelRole.setVisible(false);
		labelRole.setBounds(110, 129, 500, 16);
		manageFrame.getContentPane().add(labelRole);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance:");
		lblCurrentBalance.setBounds(564, 469, 92, 14);
		lblCurrentBalance.setVisible(false);
		manageFrame.getContentPane().add(lblCurrentBalance);
		
		balanceTF = new JTextField();
		balanceTF.setBounds(574, 489, 113, 20);
		manageFrame.getContentPane().add(balanceTF);
		balanceTF.setVisible(false);
		balanceTF.setColumns(10);
		balanceTF.setEditable(false);
		
		JButton btnTopUpNow = new JButton("Top Up Now!");
		btnTopUpNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new topUpMenu(currUser);
				manageFrame.dispose();
			}
		});
		btnTopUpNow.setBounds(440, 486, 106, 23);
		manageFrame.getContentPane().add(btnTopUpNow);
		
		JButton btnUpgradeNow = new JButton("Upgrade Now!");
		btnUpgradeNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String upgradeTo = new String("");
				if(currUser instanceof Silver){
					upgradeTo = "Gold";
					Gold upgradeGold = new Gold((Customer)currUser);
					Main.userdata.set(Main.userdata.indexOf(currUser), upgradeGold);
					((Customer) currUser).setnTransaksi(0);
					manageFrame.dispose();
					new manageMenu(upgradeGold);
					JOptionPane.showMessageDialog(null, "Congratulation! Upgrade to " + upgradeTo + " success!");
				} else if(currUser instanceof Gold){
					upgradeTo = "Platinum";
					Platinum upgradePlatinum = new Platinum((Customer)currUser);
					Main.userdata.set(Main.userdata.indexOf(currUser), upgradePlatinum);
					((Customer) currUser).setnTransaksi(0);
					manageFrame.dispose();
					new manageMenu(upgradePlatinum);
					JOptionPane.showMessageDialog(null, "Congratulation! Upgrade to " + upgradeTo + " success!");
				} else if(currUser instanceof Customer){
					upgradeTo = "Silver";
					Silver upgradeSilver = new Silver((Customer)currUser);
					Main.userdata.set(Main.userdata.indexOf(currUser), upgradeSilver);
					((Customer) currUser).setnTransaksi(0);
					manageFrame.dispose();
					new manageMenu(upgradeSilver);
					JOptionPane.showMessageDialog(null, "Congratulation! Upgrade to " + upgradeTo + " success!");
				}
			}
		});
		
		if(!(currUser instanceof Customer)){
			btnTopUpNow.setVisible(false);
			btnViewBookings.setVisible(false);
			btnUpgradeNow.setVisible(false);
			editButton.setVisible(false);
			makeButton.setVisible(false);
		}
		
		btnUpgradeNow.setBounds(567, 287, 120, 23);
		btnUpgradeNow.setVisible(false);
		manageFrame.getContentPane().add(btnUpgradeNow);
		
		JLabel lblUpgradeTo = new JLabel("Upgrade to:");
		lblUpgradeTo.setBounds(564, 262, 67, 14);
		lblUpgradeTo.setVisible(false);
		manageFrame.getContentPane().add(lblUpgradeTo);
		
		JLabel lblType = new JLabel("type");
		lblType.setBounds(641, 262, 46, 14);
		if(currUser instanceof Silver){
			lblType.setText("Gold");
		} else if(currUser instanceof Gold){
			lblType.setText("Platinum");
		} else if(currUser instanceof Customer){
			lblType.setText("Silver");
		}
		lblType.setVisible(false);
		manageFrame.getContentPane().add(lblType);
		
		JPanel upgradeGroup = new JPanel();
		upgradeGroup.setBackground(Color.LIGHT_GRAY);
		upgradeGroup.setBounds(538, 245, 179, 86);
		upgradeGroup.setVisible(false);
		manageFrame.getContentPane().add(upgradeGroup);
		
		if((currUser instanceof Customer || currUser instanceof Silver || currUser instanceof Gold) && ((Customer)currUser).getnTransaksi() >= 5){
			lblUpgradeTo.setVisible(true);
			lblType.setVisible(true);
			btnUpgradeNow.setVisible(true);
			upgradeGroup.setVisible(true);
		}
		
		JLabel lblTransactions = new JLabel("Transactions:");
		lblTransactions.setBounds(42, 158, 74, 14);
		lblTransactions.setVisible(false);
		manageFrame.getContentPane().add(lblTransactions);
		
		JLabel labelTransactionInfo = new JLabel((String) null);
		labelTransactionInfo.setBounds(120, 156, 500, 16);
		if(currUser instanceof Customer){
			labelTransactionInfo.setText(((Customer)currUser).getnTransaksi().toString());
		}
		labelTransactionInfo.setVisible(false);
		manageFrame.getContentPane().add(labelTransactionInfo);
		
		JButton updateSalary = new JButton("Update Salary / Pricing");
		updateSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtYourPricing.equals("")){
					((Stylist)currUser).setPricing(Double.parseDouble(txtYourPricing.getText()));
					JOptionPane.showMessageDialog(null, "Pricing has been updated! Congratulations!");
				} else {
					JOptionPane.showMessageDialog(null, "Please input your new pricing!");
				}
			}
		});
		updateSalary.setBounds(273, 302, 167, 65);
		updateSalary.setVisible(false);
		manageFrame.getContentPane().add(updateSalary);
		
		txtYourPricing = new JTextField();
		txtYourPricing.setText("Your Pricing");
		txtYourPricing.setBounds(262, 254, 179, 31);
		txtYourPricing.setVisible(false);
		manageFrame.getContentPane().add(txtYourPricing);
		txtYourPricing.setColumns(10);
		
		JLabel lblYourSalary = new JLabel("Your salary / pricing:");
		lblYourSalary.setBounds(262, 229, 92, 14);
		lblYourSalary.setVisible(false);
		manageFrame.getContentPane().add(lblYourSalary);
		
		JButton btnViewReceipts = new JButton("View Receipts");
		btnViewReceipts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageFrame.dispose();
				new viewReceipts(currUser);
			}
		});
		btnViewReceipts.setBounds(564, 211, 113, 23);
		btnViewReceipts.setVisible(false);
		manageFrame.getContentPane().add(btnViewReceipts);
		
		JLabel lblReceipts = new JLabel("Receipts:");
		lblReceipts.setBounds(564, 190, 56, 20);
		lblReceipts.setVisible(false);
		manageFrame.getContentPane().add(lblReceipts);
		
		if(!(currUser instanceof Stylist)){
			balanceTF.setVisible(true);
			balanceTF.setText(((Customer)currUser).getBalance().toString());
			lblTransactions.setVisible(true);
			labelTransactionInfo.setVisible(true);
			lblCurrentBalance.setVisible(true);
			balanceTF.setVisible(true);
			lblReceipts.setVisible(true);
			btnViewReceipts.setVisible(true);
		} else if(currUser instanceof Stylist){
			txtYourPricing.setText(((Stylist)currUser).getPricing().toString());
			updateSalary.setVisible(true);
			txtYourPricing.setVisible(true);
			lblYourSalary.setVisible(true);
		}
		
		manageFrame.setResizable(false);
		manageFrame.setVisible(true);
		
	}
}
