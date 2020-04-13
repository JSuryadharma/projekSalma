package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import User.User;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class viewBookings {

	private JFrame frame;
	private JTable table;
	private User currUser;

	public viewBookings(User currUser) {
		this.currUser = currUser;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 749, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseClick) {
				frame.dispose();
				new manageMenu(currUser);
			}
		});
		frame.getContentPane().add(table, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
