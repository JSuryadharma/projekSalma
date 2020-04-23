package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import User.Customer;
import User.User;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class topUpMenu {
	private JFrame frame;
	private User currUser;
	private JTextField currSaldoTF;
	private JTextField amountTF;
	private JTextField afterTopUpTF;
	private Double res = new Double(0);

	public topUpMenu(User currUser) {
		this.currUser = currUser;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome, " + currUser.getNama());
		lblWelcome.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblWelcome.setBounds(20, 11, 186, 31);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblCurrentSaldo = new JLabel("Current Saldo:");
		lblCurrentSaldo.setBounds(189, 83, 87, 14);
		frame.getContentPane().add(lblCurrentSaldo);
		
		currSaldoTF = new JTextField(((Customer)currUser).getBalance().toString());
		currSaldoTF.setBounds(237, 108, 150, 31);
		frame.getContentPane().add(currSaldoTF);
		currSaldoTF.setColumns(10);
		currSaldoTF.setEditable(false);
		
		JLabel lblAmountTopUp = new JLabel("Amount Top Up:");
		lblAmountTopUp.setBounds(189, 154, 87, 14);
		frame.getContentPane().add(lblAmountTopUp);
		
		amountTF = new JTextField();
		amountTF.setColumns(10);
		amountTF.setBounds(237, 179, 150, 31);
		frame.getContentPane().add(amountTF);
		
		JButton btnTopUp = new JButton("Top Up");
		btnTopUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Customer)currUser).topUp(Integer.parseInt(amountTF.getText()));
				JOptionPane.showMessageDialog(null, "Top Up Successful! Amount added: " + amountTF.getText());
				frame.dispose();
				new manageMenu(currUser);
			}
		});
		btnTopUp.setBounds(248, 317, 139, 45);
		frame.getContentPane().add(btnTopUp);
		
		JLabel lblAfterTopUp = new JLabel("After Top Up:");
		lblAfterTopUp.setBounds(189, 221, 87, 14);
		frame.getContentPane().add(lblAfterTopUp);
		
		afterTopUpTF = new JTextField();
		afterTopUpTF.setColumns(10);
		afterTopUpTF.setBounds(237, 246, 150, 31);
		afterTopUpTF.setEditable(false);
		frame.getContentPane().add(afterTopUpTF);
		
		JButton btnCekBalance = new JButton("Cek Balance");
		btnCekBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				res = Double.parseDouble(amountTF.getText());
				res = res + ((Customer)currUser).getBalance();
				afterTopUpTF.setText(res.toString());
				currSaldoTF.setText(((Customer)currUser).getBalance().toString());
			}
		});
		btnCekBalance.setBounds(411, 183, 98, 23);
		frame.getContentPane().add(btnCekBalance);
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
