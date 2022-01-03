package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Clinic {

	DBConnection conn = new DBConnection();
	Connection con = conn.connDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private int id;
	private String name;

	public Clinic() {

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

	public Clinic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ArrayList<Clinic> getClinicList() throws SQLException {

		ArrayList<Clinic> list = new ArrayList<>();
		Clinic obj;
		Connection con = conn.connDB();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from clinic ");
			while (rs.next()) {
				obj = new Clinic();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return list;
	}

	public boolean addClinic(String name) throws SQLException {

		String query = "insert into clinic (name)  values (?)";
		boolean key = false;
		Connection con = conn.connDB();
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (key)
			return true;
		else
			return false;

	}

	public boolean deleteClinic(int id) throws SQLException {

		String query = "delete from clinic where id = ?";
		Connection con = conn.connDB();
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (key)
			return true;
		else
			return false;

	}

	public boolean updateClinic(int id, String name) throws SQLException {

		String query = "update clinic set name=? where id = ?";
		Connection con = conn.connDB();
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (key)
			return true;
		else
			return false;

	}

}
