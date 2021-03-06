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
	private String StylistName;
	private String dateSchedule;
	private String serviceOrder;
	private String bookDate;
	public String toString(){
		return CustomerID + "#" + StylistID + "#" + StylistName + "#" + serviceOrder + "#" + dateSchedule + "#" + bookDate + "#";
	}
	
	public Booking(String CustomerID, String StylistID, String StylistName, String serviceOrder, String dateSchedule, String bookDate) {
		initialize();
		this.CustomerID = CustomerID;
		this.StylistID = StylistID;
		this.serviceOrder = serviceOrder;
		this.dateSchedule = dateSchedule;
		this.StylistName = StylistName;
		this.bookDate = bookDate;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getStylistID() {
		return StylistID;
	}

	public void setStylistID(String stylistID) {
		StylistID = stylistID;
	}

	public String getDateSchedule() {
		return dateSchedule;
	}

	public void setDateSchedule(String dateSchedule) {
		this.dateSchedule = dateSchedule;
	}

	public String getServiceOrder() {
		return serviceOrder;
	}

	public void setServiceOrder(String serviceOrder) {
		this.serviceOrder = serviceOrder;
	}

	public String getStylistName() {
		return StylistName;
	}

	public void setStylistName(String stylistName) {
		StylistName = stylistName;
	}
	
}
