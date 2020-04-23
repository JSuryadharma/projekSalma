package User;

public class Platinum extends PremiumCustomer {

	private double discount = 20/100;
	

	public Platinum(Customer oldUser){
		super(oldUser);
	}
	
	public Platinum(String UUID, String nama, String email, String password, Double saldo, Integer point, Integer nTransaksi) {
		super(UUID, nama, email, password, saldo, point, nTransaksi);
	}

	@Override
	public int addPoint() {
		super.setPoint(super.getPoint() + 20);
		return 20;
	}

	@Override
	public double costReduction(double price) {
		return price * discount;
	}

	@Override
	public double getPricing(double price) {
		return price - costReduction(price);
	}
	
}
