package User;

public class Gold extends PremiumCustomer {

	private double discount = 10;

	public Gold(Customer oldUser){
		super(oldUser);
	}
	
	public Gold(String UUID, String nama, String email, String password, Double saldo, Integer point, Integer nTransaksi) {
		super(UUID, nama, email, password, saldo, point, nTransaksi);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addPoint() {
		super.setPoint(super.getPoint() + 15);
		return 15;
	}

	@Override
	public double costReduction(double price) {
		return price * discount/100;
	}

	@Override
	public double getPricing(double price) {
		return (double)price - costReduction(price);
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	

}
