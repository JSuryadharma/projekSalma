package User;

import java.util.ArrayList;

import Payment.Booking;
import Payment.Payment;

public class Customer extends User {
	
	private Double balance = new Double(0);
	private Integer nTransaksi = new Integer(0);
	public ArrayList<Booking> booklist = new ArrayList<Booking>();
	public ArrayList<Payment> receipt = new ArrayList<Payment>();
	
	public Customer(Customer OldCust)
	{
		super(OldCust);
		this.UUID = OldCust.UUID;
		this.nama = OldCust.nama;
		this.email = OldCust.email;
		this.password = OldCust.password;
		this.balance = OldCust.balance;
		this.booklist = OldCust.booklist;
		this.receipt = OldCust.receipt;
	}
	
	public Customer(String UUID, String nama, String email, String password, Double balance, Integer nTransaksi) {
		super(UUID, nama, email, password);
		this.balance = balance;
		this.nTransaksi = nTransaksi;
	}

	public Double getBalance() {
		return balance;
	}

	public void topUp(Integer balance) {
		this.balance = this.balance + balance;
	}
	
	public void reduceBalance(Double price){
		this.balance = this.balance - price;
	}

	public Integer getnTransaksi() {
		return nTransaksi;
	}

	public void setnTransaksi(Integer nTransaksi) {
		this.nTransaksi = nTransaksi;
	}
	
	public void addPayment(Payment payment){
		receipt.add(payment);
	}
	
}
