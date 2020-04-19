package Menu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Main.Main;
import Payment.Booking;
import User.Customer;
import User.Gold;
import User.Platinum;
import User.Silver;
import User.Stylist;
import User.User;

public class MainMenu {

	private JFrame firstFrame;
	DateFormat dateFormat = new SimpleDateFormat("EEEE , dd/MM/YYYY");
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
	private JTextField dateShowTF;

	public MainMenu() {
		initialize();
	}
	
	public void saveuserData(){		
			try {
				String filePath = "userdata.file";
				File file = new File(filePath);
				if(!file.exists()){			
					file.createNewFile();
				}
				PrintWriter pw = new PrintWriter(file);
				for(User u : Main.userdata){
					if(u instanceof Silver){
						System.out.println(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Silver" + "#" + ((Silver)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
						pw.print(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Silver" + "#" + ((Silver)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
					} else if(u instanceof Gold){
						System.out.println(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Gold" + "#" + ((Gold)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
						pw.print(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Gold" + "#" + ((Gold)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
					} else if(u instanceof Platinum){
						System.out.println(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Platinum" + "#" + ((Platinum)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
						pw.print(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Platinum" + "#" + ((Platinum)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
					} else if(u instanceof Customer){
						System.out.println(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Customer" + "#" + 0 + "#" + ((Customer)u).getnTransaksi() + "#");
						pw.print(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Customer" + "#" + 0 + "#" + ((Customer)u).getnTransaksi() + "#");
					}
					for(Booking bl : ((Customer)u).booklist){
						pw.print(bl.toString());
						System.out.print(bl.toString());
					}
					pw.println();
				}
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void savestylistData(){		
		try {
			String filePath = "stylistdata.file";
			File file = new File(filePath);
			if(!file.exists()){			
				file.createNewFile();
			}
			PrintWriter pw = new PrintWriter(file);
			for(User u : Main.stylistdata){
				System.out.println(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Stylist)u).getSpecialization() + "#" + ((Stylist)u).getPricing());
				pw.print(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Stylist)u).getSpecialization() + "#" + ((Stylist)u).getPricing());

			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	

	private void initialize() {
		firstFrame = new JFrame();
		firstFrame.setBounds(100, 100, 764, 438);
		firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstFrame.getContentPane().setLayout(null);
		
		JLabel labelSalma = new JLabel("SALMA - Salon Manager for Professionals");
		labelSalma.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		labelSalma.setBounds(151, 38, 450, 56);
		firstFrame.getContentPane().add(labelSalma);
		
		JButton buttonRegister = new JButton("Register Data");
		buttonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstFrame.setVisible(false);
				new Register();
			}
		});
		buttonRegister.setBounds(281, 109, 183, 64);
		firstFrame.getContentPane().add(buttonRegister);
		
		JButton buttonLogin = new JButton("User Login");
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstFrame.dispose();
				new Login();
			}
		});
		buttonLogin.setBounds(281, 197, 183, 64);
		firstFrame.getContentPane().add(buttonLogin);
		
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstFrame.dispose();
				saveuserData();
				savestylistData();
				JOptionPane.showMessageDialog(null, "All Personal Files are Saved Successfully!", "SALMA - Important Message", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		Exit.setBounds(281, 288, 183, 64);
		firstFrame.getContentPane().add(Exit);
		
		dateShowTF = new JTextField();
		dateShowTF.setBounds(10, 11, 131, 20);
		firstFrame.getContentPane().add(dateShowTF);
		dateShowTF.setColumns(10);
		dateShowTF.setText(dateFormat.format(date));
		dateShowTF.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("New! Reminder for Users to exit this program via Exit button above!  Otherwise, your data might be gone.");
		lblNewLabel.setBounds(127, 373, 519, 14);
		firstFrame.getContentPane().add(lblNewLabel);
		firstFrame.setResizable(false);
		firstFrame.setUndecorated(false);
		firstFrame.setVisible(true);
	}
}
