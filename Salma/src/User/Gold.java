package User;

public class Gold extends PremiumCustomer {

	public Gold(String UUID, String nama, String email, String password) {
		super(UUID, nama, email, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addPoint() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costReduction() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double setDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
