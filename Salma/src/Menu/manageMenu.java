package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import User.User;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manageMenu {

	private JFrame manageFrame;
	private User currUser;

	public manageMenu(User currUser) {
		super();
		this.currUser = currUser;
		initialize();
	}

	private void initialize() {
		manageFrame = new JFrame();
		manageFrame.setTitle("SALMA - Manage Menu");
		manageFrame.setBounds(100, 100, 748, 559);
		manageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manageFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Make a booking");
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
		buttonBackToMainMenu.setBounds(273, 268, 167, 65);
		manageFrame.getContentPane().add(buttonBackToMainMenu);
		manageFrame.setVisible(true);
	}
}
