package User;

public class Silver extends PremiumCustomer {

	private double discount = 5/100;
	
	public Silver(Customer oldUser){
		super(oldUser);
	}
	
	public Silver(String UUID, String nama, String email, String password, Double saldo, Integer point, Integer nTransaksi) {
		super(UUID, nama, email, password, saldo, point, nTransaksi);
	}

	@Override
	public int addPoint() {
		super.setPoint(super.getPoint() + 5);
		return 5;
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
