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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

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
						// System.out.println(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Silver" + "#" + ((Silver)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
						pw.print(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Silver" + "#" + ((Silver)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
					} else if(u instanceof Gold){
						// System.out.println(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Gold" + "#" + ((Gold)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
						pw.print(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Gold" + "#" + ((Gold)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
					} else if(u instanceof Platinum){
						// System.out.println(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Platinum" + "#" + ((Platinum)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
						pw.print(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Platinum" + "#" + ((Platinum)u).getPoint() + "#" + ((Customer)u).getnTransaksi() + "#");
					} else if(u instanceof Customer){
						// System.out.println(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Customer" + "#" + 0 + "#" + ((Customer)u).getnTransaksi() + "#");
						pw.print(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Customer)u).getBalance() + "#" + "Customer" + "#" + 0 + "#" + ((Customer)u).getnTransaksi() + "#");
					}
					for(Booking bl : ((Customer)u).booklist){
						pw.print(bl.toString());
						// System.out.print(bl.toString());
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
				// System.out.println(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Stylist)u).getSpecialization() + "#" + ((Stylist)u).getPricing());
				pw.print(u.getUUID() + "#" + u.getNama() + "#" + u.getEmail() + "#" + u.getPassword() + "#" + ((Stylist)u).getSpecialization() + "#" + ((Stylist)u).getPricing());

			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	

	private void initialize() {
		firstFrame = new JFrame();
		firstFrame.setBounds(450, 110, 400, 600);
		firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstFrame.getContentPane().setLayout(null);
		
		dateShowTF = new JTextField();
		dateShowTF.setToolTipText("Today's Date!");
		dateShowTF.setHorizontalAlignment(SwingConstants.CENTER);
		dateShowTF.setFont(new Font("Century Gothic", Font.BOLD, 10));
		dateShowTF.setBounds(236, 141, 148, 20);
		firstFrame.getContentPane().add(dateShowTF);
		dateShowTF.setColumns(10);
		dateShowTF.setText(dateFormat.format(date));
		dateShowTF.setEditable(false);
		
		JLabel labelRegister = new JLabel("");
		labelRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				firstFrame.setVisible(false);
				new Register();
			}
		});
		labelRegister.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/register.png")));
		labelRegister.setBounds(248, 249, 70, 47);
		firstFrame.getContentPane().add(labelRegister);
		
		JLabel labelLogin = new JLabel("");
		labelLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				firstFrame.dispose();
				new Login();
			}
		});
		labelLogin.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/login.png")));
		labelLogin.setBounds(184, 419, 70, 64);
		firstFrame.getContentPane().add(labelLogin);
		
		JLabel labelExit = new JLabel("");
		labelExit.setToolTipText("Click to Exit!");
		labelExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				firstFrame.dispose();
				saveuserData();
				savestylistData();
				JOptionPane.showMessageDialog(null, "All Personal Files are Saved Successfully!", "SALMA - Important Message", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/close.png")));
		labelExit.setBounds(182, 11, 47, 34);
		firstFrame.getContentPane().add(labelExit);
		
		JLabel labelBG = new JLabel("");
		labelBG.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/RegisterOrLogin.png")));
		labelBG.setBounds(0, 0, 412, 600);
		firstFrame.getContentPane().add(labelBG);
		firstFrame.setResizable(false);
		firstFrame.setUndecorated(true);
		firstFrame.setVisible(true);
	}
}
