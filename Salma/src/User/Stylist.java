package User;

public class Stylist extends User {

	private String specialization;
	private Double pricing;

	public Stylist(String UUID, String nama, String email, String password) {
		super(UUID, nama, email, password);
	}
	
	public Stylist(String UUID, String nama, String email, String password, String specialization, Double pricing) {
		super(UUID, nama, email, password);
		this.specialization = specialization;
		this.pricing = pricing;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Double getPricing() {
		return pricing;
	}

	public void setPricing(Double pricing) {
		this.pricing = pricing;
	}

}
