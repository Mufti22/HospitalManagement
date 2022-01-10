package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Helper.DBConnection;

public class Whour {
	DBConnection conn = new DBConnection();
	Connection con = conn.connDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	private int id, doctor_id;
	private String doctor_name, wdate,status;
	
	public Whour(int id, int doctor_id, String doctor_name, String wdate, String status) {

		this.id = id;
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.wdate = wdate;
		this.status = status;
	}
	public Whour() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
