package Model;

import Helper.DBConnection;

public class user {
	private int id;
	String pasp, password, name, type;
	DBConnection conn = new DBConnection();

	public user(int id, String pasp, String password, String name, String type) {

		this.id = id;
		this.pasp = pasp;
		this.password = password;
		this.name = name;
		this.type = type;
	}

	public user() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPasp() {
		return pasp;
	}

	public void setPasp(String pasp) {
		this.pasp = pasp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
