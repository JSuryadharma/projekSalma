package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Main.Main;
import User.Stylist;
import User.User;
import Utils.Utils;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Register {

	private JFrame registerFrame;
	private JTextField inputNama;
	private JTextField inputEmail;
	private JTextField inputPass;
	private JTextField SpecializationTextField;


	public Register() {
		initialize();
	}

	private void initialize() {
		registerFrame = new JFrame();
		registerFrame.setTitle("SALMA - Register Page");
		registerFrame.setBounds(100, 100, 551, 454);
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerFrame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Choose your Role");
		comboBox.addItem("Choose your Role");
		comboBox.addItem("Customer");
		comboBox.addItem("Stylist");
		
		comboBox.setBounds(150, 279, 224, 37);
		registerFrame.getContentPane().add(comboBox);
		
		SpecializationTextField = new JTextField();
		SpecializationTextField.setText("Your specialization.");
		SpecializationTextField.setBounds(270, 358, 104, 23);
		registerFrame.getContentPane().add(SpecializationTextField);
		SpecializationTextField.setColumns(10);
		SpecializationTextField.setVisible(false);
		
		JLabel LabelSpecialization = new JLabel("Specialization");
		LabelSpecialization.setBounds(271, 337, 78, 14);
		LabelSpecialization.setVisible(false);
		
		registerFrame.getContentPane().add(LabelSpecialization);
	
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedItem().equals("Stylist"))
				{
					LabelSpecialization.setVisible(true);
					SpecializationTextField.setVisible(true);
				}
				else
				{
					LabelSpecialization.setVisible(false);
					SpecializationTextField.setVisible(false);
				}
			}
		});
		
		JLabel labelNama = new JLabel("Input Nama");
		labelNama.setBounds(140, 95, 78, 16);
		registerFrame.getContentPane().add(labelNama);
		
		JLabel labelEmail = new JLabel("Input Email");
		labelEmail.setBounds(140, 159, 78, 16);
		registerFrame.getContentPane().add(labelEmail);
		
		JLabel labelPass = new JLabel("Input Password");
		labelPass.setBounds(140, 219, 103, 16);
		registerFrame.getContentPane().add(labelPass);
		
		inputNama = new JTextField();
		inputNama.setBounds(150, 124, 224, 22);
		registerFrame.getContentPane().add(inputNama);
		inputNama.setColumns(10);
		
		inputEmail = new JTextField();
		inputEmail.setColumns(10);
		inputEmail.setBounds(150, 184, 224, 22);
		registerFrame.getContentPane().add(inputEmail);
		
		inputPass = new JPasswordField();
		inputPass.setColumns(10);
		inputPass.setBounds(150, 246, 224, 22);
		registerFrame.getContentPane().add(inputPass);
		
		JLabel lblRegistrationMenu = new JLabel("Registration Menu");
		lblRegistrationMenu.setFont(new Font("Century Gothic", Font.PLAIN, 27));
		lblRegistrationMenu.setBounds(140, 29, 251, 37);
		registerFrame.getContentPane().add(lblRegistrationMenu);
		
		JButton registerButton = new JButton("Daftar");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userNama = inputNama.getText();
				String userEmail = inputEmail.getText();
				String userPass = inputPass.getText();
				String userUUID = UUID.randomUUID().toString();
				if(!Utils.verifyName(userNama)){
					JOptionPane.showMessageDialog(null, "Masukkan Nama dengan Benar! Tidak ada numeric, minimum 4 chars!");
				} else{					
					if(!Utils.verifyEmail(userEmail)){
						JOptionPane.showMessageDialog(null, "Masukkan Email dengan Benar! Harus dengan @gmail.com dan [Alpha | Num] !");
					} else {
						if(!Utils.verifyPass(userPass)){
							JOptionPane.showMessageDialog(null, "Masukkan Password dengan Benar! Minimum 6 Character! [Alphanumeric]");
						} else {							
							User tempuser = null;
							User tempstylist = null;
							
							for(User s : Main.stylistdata)
							{
								if(s.authEmail(userEmail)){
									tempstylist = s;
									break;
								}
							}
							
							for(User u : Main.userdata){
								if(u.authEmail(userEmail)){
									tempuser = u;
									break;
								}
							}
							
							
							if(tempuser != null || tempstylist != null){
								JOptionPane.showMessageDialog(null, "Email/Data harus unik!");
								
							} else {
								
								if(comboBox.getSelectedObjects().equals("Stylist"))
								{
									String userSpecialization = SpecializationTextField.getText();
									
									tempstylist = new Stylist(userUUID, userNama, userEmail, userPass, userSpecialization);
									Main.stylistdata.add(tempstylist);
									System.out.println(Main.stylistdata.size());
									registerFrame.dispose();
									new manageMenu((Stylist)tempstylist);
								}
								
								else
								{
									tempuser = new User(userUUID, userNama, userEmail, userPass);
									Main.userdata.add(tempuser);
									System.out.println(Main.userdata.size());
									registerFrame.dispose();
									new manageMenu(tempuser);
								}
							}
						}
					}
				}
			}
		});
		
		registerButton.setBounds(151, 336, 108, 47);
		registerFrame.getContentPane().add(registerButton);
		registerFrame.setVisible(true);
	}
}
