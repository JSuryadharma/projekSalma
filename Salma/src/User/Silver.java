package User;

public class Silver extends PremiumCustomer {

	private double discount = 5/100;
	
	public Silver(PremiumCustomer oldPremCust) {
		super(oldPremCust);
		this.discount = discount;
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
