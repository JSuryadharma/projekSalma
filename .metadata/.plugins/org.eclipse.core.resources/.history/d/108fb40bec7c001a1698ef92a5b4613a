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

public class Login {

	private JFrame loginFrame;
	private JTextField inputEmail;
	private JTextField inputPass;

	public Login() {
		initialize();
	}

	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setTitle("SALMA - Login Page");
		loginFrame.setBounds(100, 100, 556, 423);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		
		JLabel labelEmail = new JLabel("Input Email");
		labelEmail.setBounds(140, 102, 78, 16);
		loginFrame.getContentPane().add(labelEmail);
		
		JLabel labelPass = new JLabel("Input Password");
		labelPass.setBounds(140, 166, 103, 16);
		loginFrame.getContentPane().add(labelPass);
		
		inputEmail = new JTextField();
		inputEmail.setColumns(10);
		inputEmail.setBounds(150, 131, 224, 22);
		loginFrame.getContentPane().add(inputEmail);
		
		inputPass = new JPasswordField();
		inputPass.setColumns(10);
		inputPass.setBounds(150, 195, 224, 22);
		loginFrame.getContentPane().add(inputPass);
		
		JLabel lblLoginMenu = new JLabel("Login Menu");
		lblLoginMenu.setFont(new Font("Century Gothic", Font.PLAIN, 27));
		lblLoginMenu.setBounds(140, 29, 251, 37);
		loginFrame.getContentPane().add(lblLoginMenu);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userEmail = inputEmail.getText();
				String userPass = inputPass.getText();
				if(!Utils.verifyEmail(userEmail)){
					JOptionPane.showMessageDialog(null, "Masukkan Email dengan Benar! Harus dengan @gmail.com dan [Alpha | Num] !");
				} else {					
					if(!Utils.verifyPass(userPass)){
						JOptionPane.showMessageDialog(null, "Masukkan Password dengan Benar! Minimum 6 Character! [Alphanumeric]");
					} else {
						User temp = null;
						for(User u : Main.userdata){
							if(u.auth(userEmail, userPass)){
								temp = u;
								break;
							}
						}
						System.out.println(temp.getNama());
						if(temp != null){
							JOptionPane.showMessageDialog(null, "Data berhasil ditemukan! Selamat datang, " +  temp.getNama());
							loginFrame.dispose();
							new manageMenu(temp);
						} else {
							JOptionPane.showMessageDialog(null, "User email atau password tidak ditemukan!");
						}
					}
				}
			}
		});
		loginButton.setBounds(187, 230, 141, 47);
		loginFrame.getContentPane().add(loginButton);
		
		loginFrame.setVisible(true);
	}

}
