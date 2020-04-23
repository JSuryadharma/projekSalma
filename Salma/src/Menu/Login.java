package Menu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Main.Main;
import User.User;
import Utils.Utils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame loginFrame;
	private JTextField inputEmail;
	private JTextField inputPass;

	public Login() {
		initialize();
	}

	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setUndecorated(true);
		loginFrame.getContentPane().setBackground(new Color(255, 255, 255));
		loginFrame.setTitle("SALMA - Login Page");
		loginFrame.setBounds(300, 150, 714, 438);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		
		JLabel labelEmail = new JLabel("Input Email");
		labelEmail.setBounds(430, 161, 103, 16);
		loginFrame.getContentPane().add(labelEmail);
		
		JLabel labelPass = new JLabel("Input Password");
		labelPass.setBounds(430, 240, 103, 16);
		loginFrame.getContentPane().add(labelPass);
		
		inputEmail = new JTextField();
		inputEmail.setToolTipText("Input Your Email!");
		inputEmail.setColumns(10);
		inputEmail.setBounds(430, 188, 224, 22);
		loginFrame.getContentPane().add(inputEmail);
		
		inputPass = new JPasswordField();
		inputPass.setToolTipText("Input your password!");
		inputPass.setColumns(10);
		inputPass.setBounds(430, 267, 224, 22);
		loginFrame.getContentPane().add(inputPass);
		
		JLabel lblLoginMenu = new JLabel("Login Menu");
		lblLoginMenu.setFont(new Font("Century Gothic", Font.PLAIN, 27));
		lblLoginMenu.setBounds(430, 71, 251, 37);
		loginFrame.getContentPane().add(lblLoginMenu);
		
		JLabel labelBG1 = new JLabel("");
		labelBG1.setHorizontalAlignment(SwingConstants.CENTER);
		labelBG1.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/SalmaLogo.png")));
		labelBG1.setBounds(22, 33, 368, 358);
		loginFrame.getContentPane().add(labelBG1);
		
		JLabel labelBG2 = new JLabel("");
		labelBG2.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/background.jpg")));
		labelBG2.setBounds(0, -10, 377, 448);
		loginFrame.getContentPane().add(labelBG2);
		
		JLabel labelLogin = new JLabel("");
		labelLogin.setToolTipText("Login");
		labelLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userEmail = inputEmail.getText();
				String userPass = inputPass.getText();
			
				if(!Utils.verifyEmail(userEmail)){
					JOptionPane.showMessageDialog(null, "Please input the correct email! Must ended @gmail.com and [Alpha | Num] !");
				} else {					
					if(!Utils.verifyPass(userPass)){
						JOptionPane.showMessageDialog(null, "Please input the correct password format! Minimum 6 Character! [Alphanumeric]");
					} else {
						User temp = null;
						for(User u : Main.userdata){
							if(u.auth(userEmail, userPass)){
								temp = u;
								break;
							}
						}
						for(User s : Main.stylistdata){
							if(s.auth(userEmail, userPass)){
								temp = s;
								break;
							}
						}
						
						if(temp != null){
							System.out.println(temp.getNama());
							JOptionPane.showMessageDialog(null, "Data has been found! Welcome, " +  temp.getNama() + " !");
							loginFrame.dispose();
							new manageMenu(temp);
						} else {
							JOptionPane.showMessageDialog(null, "User email or password not found!");
						}
					}
				}
			}
		});
		labelLogin.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/next.png")));
		labelLogin.setBounds(430, 311, 97, 80);
		loginFrame.getContentPane().add(labelLogin);
		
		JLabel labelBack = new JLabel("");
		labelBack.setToolTipText("Cancel");
		labelBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginFrame.dispose();
				new MainMenu();
			}
		});
		labelBack.setHorizontalAlignment(SwingConstants.CENTER);
		labelBack.setIcon(new ImageIcon(MainMenu.class.getResource("/IMAGE/cancel64.png")));
		labelBack.setBounds(493, 311, 97, 80);
		loginFrame.getContentPane().add(labelBack);
		loginFrame.setResizable(false);
		loginFrame.setVisible(true);
	}

}
