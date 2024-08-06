package bank.model;

public class Login {

	private String accUname ;
	private String accPassword;
	
	public Login() {
		
	}

	public Login(String accUname, String accPassword) {
		super();
		this.accUname = accUname;
		this.accPassword = accPassword;
	}

	public String getAccUname() {
		return accUname;
	}

	public void setAccUname(String accUname) {
		this.accUname = accUname;
	}

	public String getAccPassword() {
		return accPassword;
	}

	public void setAccPassword(String accPassword) {
		this.accPassword = accPassword;
	}

	
}
