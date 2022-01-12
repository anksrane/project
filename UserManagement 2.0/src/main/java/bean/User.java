package bean;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private String role;
	private int checkLogin;
	
	public User() {
		super();
	}


	public User(String email) {
		super();
		this.email = email;
	}


	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public User(String name, String email, String password, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role=role;
	}


	public User(int id, String name, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role=role;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getpassword() {
		return password;
	}


	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getrole() {
		return role;
	}


	public void setrole(String role) {
		this.role = role;
	}
	
	public int getCheckLogin() {
		return checkLogin;
	}
	
	
	public void setCheckLogin(int checkLogin) {
		this.checkLogin = checkLogin;
	}
}
