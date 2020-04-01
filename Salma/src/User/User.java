package User;

public class User {
	protected String UUID;
	protected String nama;
	protected String email;
	protected String password;
	
	public User(User oldUser)
	{
		this.UUID = UUID;
		this.nama = nama;
		this.email = email;
		this.password = password;
	}
	
	public User(String UUID, String nama, String email, String password) {
		super();
		this.UUID = UUID;
		this.nama = nama;
		this.email = email;
		this.password = password;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public Boolean auth(String email, String password){
		return this.email.equals(email)&& this.password.equals(password);
	}
	
	public Boolean authEmail(String email){
		return this.email.equals(email);
	}
	
}