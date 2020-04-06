package User;

public abstract class PremiumCustomer extends Customer implements InterfacePremium {
	
	protected int point = 0;
	private double discount = 0;
	
	public PremiumCustomer(Customer oldPremCust)
	{
		super(oldPremCust);
		this.point = 0;
	}
	
	public PremiumCustomer(String UUID, String nama, String email, String password) {
		super(UUID, nama, email, password);
		// TODO Auto-generated constructor stub
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public abstract double setDiscount();
	public abstract double getDiscount();
	
}
