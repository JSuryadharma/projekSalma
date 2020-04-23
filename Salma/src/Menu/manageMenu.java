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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class manageMenu {
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
		
	}
	
	private void initialize() {
		manageFrame = new JFrame();
		manageFrame.getContentPane().setBackground(new Color(255, 255, 255));
		manageFrame.getContentPane().setForeground(Color.WHITE);
		manageFrame.setTitle("SALMA - Manage Menu");
		manageFrame.setBounds(280, 110, 820, 560);
		manageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manageFrame.getContentPane().setLayout(null);
		
		
		dateShowTF = new JTextField();
		dateShowTF.setHorizontalAlignment(SwingConstants.CENTER);
		dateShowTF.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		dateShowTF.setBounds(599, 33, 207, 20);
		manageFrame.getContentPane().add(dateShowTF);
		dateShowTF.setColumns(10);
		dateShowTF.setText("Today's date: " + " " + dateFormat.format(date));
		dateShowTF.setEditable(false);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance:");
		lblCurrentBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentBalance.setBounds(635, 243, 92, 14);
		lblCurrentBalance.setVisible(false);
		manageFrame.getContentPane().add(lblCurrentBalance);
		
		balanceTF = new JTextField();
		balanceTF.setBounds(635, 268, 113, 20);
		manageFrame.getContentPane().add(balanceTF);
		balanceTF.setVisible(false);
		balanceTF.setColumns(10);
		balanceTF.setEditable(false);
		
		JButton btnUpgradeNow = new JButton("Upgrade Now!");
		btnUpgradeNow.setBackground(Color.WHITE);
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
		
		btnUpgradeNow.setBounds(635, 209, 120, 23);
		btnUpgradeNow.setVisible(false);
		manageFrame.getContentPane().add(btnUpgradeNow);
		
		JLabel lblUpgradeTo = new JLabel("Upgrade to:");
		lblUpgradeTo.setBounds(635, 184, 67, 14);
		lblUpgradeTo.setVisible(false);
		manageFrame.getContentPane().add(lblUpgradeTo);
		
		JLabel lblType = new JLabel("type");
		lblType.setBounds(712, 184, 46, 14);
		if(currUser instanceof Silver){
			lblType.setText("Gold");
		} else if(currUser instanceof Gold){
			lblType.setText("Platinum");
		} else if(currUser instanceof Customer){
			lblType.setText("Silver");
		}
		lblType.setVisible(false);
		manageFrame.getContentPane().add(lblType);
		
		if((currUser instanceof Customer || currUser instanceof Silver || currUser instanceof Gold) && ((Customer)currUser).getnTransaksi() >= 5){
			lblUpgradeTo.setVisible(true);
			lblType.setVisible(true);
			btnUpgradeNow.setVisible(true);
		}
	
		
		JButton updateSalary = new JButton("Update Salary / Pricing");
		updateSalary.setBackground(Color.WHITE);
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
		updateSalary.setBounds(353, 207, 113, 20);
		updateSalary.setVisible(false);
		manageFrame.getContentPane().add(updateSalary);
		
		txtYourPricing = new JTextField();
		txtYourPricing.setText("Your Pricing");
		txtYourPricing.setBounds(343, 165, 138, 31);
		txtYourPricing.setVisible(false);
		manageFrame.getContentPane().add(txtYourPricing);
		txtYourPricing.setColumns(10);
		
		JLabel lblYourSalary = new JLabel("Your salary / pricing:");
		lblYourSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourSalary.setBounds(343, 140, 138, 14);
		lblYourSalary.setVisible(false);
		manageFrame.getContentPane().add(lblYourSalary);
		
		JButton btnViewReceipts = new JButton("View Receipts");
		btnViewReceipts.setBackground(Color.WHITE);
		btnViewReceipts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageFrame.dispose();
				new viewReceipts(currUser);
			}
		});
		btnViewReceipts.setBounds(692, 64, 113, 23);
		btnViewReceipts.setVisible(false);
		manageFrame.getContentPane().add(btnViewReceipts);
		
		JLabel labelClose = new JLabel("");
		labelClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				manageFrame.dispose();
				new MainMenu();
			}
		});
//		
		labelClose.setHorizontalAlignment(SwingConstants.CENTER);
		labelClose.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/xbutton32.png")));
		labelClose.setBounds(23, 21, 46, 42);		
		JLabel labelBook = new JLabel("");
		labelBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageFrame.dispose();
				new makeBooking(currUser);
			}
		});
		labelBook.setHorizontalAlignment(SwingConstants.CENTER);
		labelBook.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/book.png")));
		labelBook.setBounds(48, 341, 151, 138);
		manageFrame.getContentPane().add(labelBook);
		manageFrame.getContentPane().add(labelClose);
		
		JLabel labelView = new JLabel("");
		labelView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageFrame.dispose();
				new viewBookings(currUser);
			}
		});
		labelView.setHorizontalAlignment(SwingConstants.CENTER);
		labelView.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/view.png")));
		labelView.setBounds(232, 341, 147, 138);
		manageFrame.getContentPane().add(labelView);
		
		JLabel labelEdit = new JLabel("");
		labelEdit.setHorizontalAlignment(SwingConstants.CENTER);
		labelEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				manageFrame.dispose();
				new editBooking(currUser);
			}
		});
		labelEdit.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/edit.png")));
		labelEdit.setBounds(423, 341, 155, 128);
		
		JLabel labelTopUp = new JLabel("");
		labelTopUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new topUpMenu(currUser);
				manageFrame.dispose();
			}
		});
		
		
		labelTopUp.setHorizontalAlignment(SwingConstants.CENTER);
		labelTopUp.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/money.png")));
		labelTopUp.setBounds(618, 351, 155,128);
		JLabel labelNamaView = new JLabel("View booking!");
		labelNamaView.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		labelNamaView.setHorizontalAlignment(SwingConstants.CENTER);
		labelNamaView.setBounds(262, 493, 84, 14);
		manageFrame.getContentPane().add(labelTopUp);
		manageFrame.getContentPane().add(labelNamaView);
		manageFrame.getContentPane().add(labelEdit);
		JLabel labelNamaBook = new JLabel("Make a Book!");
		labelNamaBook.setHorizontalAlignment(SwingConstants.CENTER);
		labelNamaBook.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		labelNamaBook.setBounds(80, 493, 84, 14);
		manageFrame.getContentPane().add(labelNamaBook);
				
		JLabel labelEditBooking = new JLabel("Edit Booking!");
		labelEditBooking.setHorizontalAlignment(SwingConstants.CENTER);
		labelEditBooking.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		labelEditBooking.setBounds(454, 493, 84, 14);
		manageFrame.getContentPane().add(labelEditBooking);
		
		JLabel labelNamaTopUp = new JLabel("TopUp Now!");
		labelNamaTopUp.setHorizontalAlignment(SwingConstants.CENTER);
		labelNamaTopUp.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		labelNamaTopUp.setBounds(642, 493, 84, 14);
		manageFrame.getContentPane().add(labelNamaTopUp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/background.jpg")));
		lblNewLabel.setBounds(-30, 0, 883, 296);
		manageFrame.getContentPane().add(lblNewLabel);
		
	
		if(!(currUser instanceof Stylist)){
			labelNamaView.setVisible(true);
			labelBook.setVisible(true);
			labelNamaBook.setVisible(true);
			labelEditBooking.setVisible(true);
			labelNamaTopUp.setVisible(true);
			labelTopUp.setVisible(true);
			labelEdit.setVisible(true);
			balanceTF.setVisible(true);
			balanceTF.setText(((Customer)currUser).getBalance().toString());
			lblCurrentBalance.setVisible(true);
			balanceTF.setVisible(true);
			btnViewReceipts.setVisible(true);
		} else if(currUser instanceof Stylist){
			labelNamaView.setVisible(false);
			labelBook.setVisible(false);
			labelNamaBook.setVisible(false);
			labelEditBooking.setVisible(false);
			labelNamaTopUp.setVisible(false);
			labelTopUp.setVisible(false);
			labelEdit.setVisible(false);
			labelView.setVisible(false);
			txtYourPricing.setText(((Stylist)currUser).getPricing().toString());
			updateSalary.setVisible(true);
			txtYourPricing.setVisible(true);
			lblYourSalary.setVisible(true);
		}
		
		manageFrame.setUndecorated(true);
		manageFrame.setResizable(false);
		manageFrame.setVisible(true);

		
	}
}
