package Payment;

import java.util.ArrayList;
import java.util.Date;

import User.Customer;
import User.PremiumCustomer;

public class Payment {

	private String PaymentDate;
	private String TreatmentName;
	private String TransactionID;
	private Double amount;
	
	private static int counter = 0;

	public Payment(String paymentDate, String treatmentName, Double amount) {
		super();
		PaymentDate = paymentDate;
		TreatmentName = treatmentName;
		String temp = "";
		temp += "TS-";
		temp += counter;
		TransactionID = temp;
		this.amount = amount;
		counter++;
	}

	public String getPaymentDate() {
		return PaymentDate;
	}

	public String getTreatmentName() {
		return TreatmentName;
	}

	public String getTransactionID() {
		return TransactionID;
	}

	public double getAmount() {
		return amount;
	}
}
