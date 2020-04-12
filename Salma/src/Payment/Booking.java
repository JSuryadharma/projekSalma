package Payment;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;

public class Booking {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	private String CustomerID;
	private String StylistID;
	private String dateSchedule;
	private String serviceOrder;
	
	public void Cancel_Booking(String CreditCardNo, String CustomerID, String StylistID)
	{
//		for()
	}
	
	@Override
	public String toString(){
		return CustomerID + "#" + StylistID + "#" + serviceOrder + "#" + dateSchedule;
	}
	
	public Booking(String CustomerID, String StylistID, String serviceOrder, String dateSchedule) {
		initialize();
		this.CustomerID = CustomerID;
		this.StylistID = StylistID;
		this.serviceOrder = serviceOrder;
		this.dateSchedule = dateSchedule;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
