package User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Payment.Booking;

public class User {
	protected String UUID;
	protected String nama;
	protected String email;
	protected String password;
	DateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/YY");
	Date date = new Date();
	public ArrayList<Booking> booklist = new ArrayList<Booking>();
	
	public User(User oldUser)
	{
		this.UUID = UUID;
		this.nama = nama;
		this.email = email;
		this.password = password;
	}
	
	public User(String UUID, String nama, String email, String password) {
		super();
		this.UUID = UUID;
		this.nama = nama;
		this.email = email;
		this.password = password;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public Boolean auth(String email, String password){
		return this.email.equals(email)&& this.password.equals(password);
	}
	
	public Boolean authEmail(String email){
		return this.email.equals(email);
	}

	public void addBookList(String CustomerID, String StylistID, String serviceOrder){
		String dateSchedule = dateFormat.format(date);
		Booking temp = new Booking(CustomerID, StylistID, serviceOrder, dateSchedule);
		booklist.add(temp);
	}
	
}
