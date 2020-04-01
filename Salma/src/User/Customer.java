package User;

import java.util.ArrayList;

import Payment.Booking;

public class Customer extends User {

	public Customer(User oldUser)
	{
		super(oldUser);
	}

	public Customer(Customer OldStdCust)
	{
		this.UUID = OldStdCust.UUID;
		this.nama = OldStdCust.nama;
		this.email = OldStdCust.email;
		this.password = OldStdCust.password;
	}
	
	public Customer(String UUID, String nama, String email, String password) {
		super(UUID, nama, email, password);
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<Booking> BookingList = new ArrayList<>();
	
	
	
}