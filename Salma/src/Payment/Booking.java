package Payment;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Booking {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	private String CreditCardNo;
	private String CustomerID;
	private String StylistID;
	
	
	public void Make_Booking(String CreditCardNo, String CustomerID, String StylistID)
	{
		this.CreditCardNo = CreditCardNo;
		this.CustomerID = CustomerID;
		this. StylistID = StylistID;
	}
	
	public void Cancel_Booking(String CreditCardNo, String CustomerID, String StylistID)
	{
//		for()
	}
	
	public void Display_Booking()
	{
		
	}
	
	public Booking() {
		initialize();
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
