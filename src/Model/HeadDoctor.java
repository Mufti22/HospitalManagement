package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HeadDoctor extends user {
	Connection con = conn.connDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public HeadDoctor(int id, String pasp, String password, String name, String type) {
		super(id, pasp, password, name, type);
	}

	public HeadDoctor() {
	}

	public ArrayList<user> getDoctorList() throws SQLException {

		ArrayList<user> list = new ArrayList<>();
		user obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from user1 where type = 'doctor'");
			while (rs.next()) {
				obj = new user(rs.getInt("id"), rs.getString("pasp"), rs.getString("password"), rs.getString("name"),
						rs.getString("type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<user> getClinicDoctorList(int id_clinic) throws SQLException {

		ArrayList<user> list = new ArrayList<>();
		user obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery(
					"select u.id, u.pasp, u.type, u.name,u.password from staff s inner join user1 u on s.id_user = u.id where id_clinic = "
							+ id_clinic);
			while (rs.next()) {
				obj = new user(rs.getInt("id"), rs.getString("pasp"), rs.getString("password"), rs.getString("name"),
						rs.getString("type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public boolean addDoctor(String pasp, String password, String name) throws SQLException {

		String query = "insert into user1 (pasp, password, name, type)  values (?,?,?,?)";

		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, pasp);
			preparedStatement.setString(4, "doctor");
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

	public boolean deleteDoctor(int id) throws SQLException {

		String query = "delete from user1 where id = ?";

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

	public boolean updateDoctor(int id, String pasp, String password, String name) throws SQLException {

		String query = "update user1 set name=?, pasp=?, password=? where id = ?";

		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pasp);
			preparedStatement.setString(3, password);
			preparedStatement.setInt(4, id);
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

	public boolean addStaff(int id_user, int id_clinic) throws SQLException {

		String query = "insert into staff (id_user, id_clinic)  values (?,?)";

		boolean key = false;
		int count = 0;
		try {

			st = con.createStatement();
			rs = st.executeQuery("select * from staff where id_clinic=" + id_clinic + "and id_user=" + id_user);
			while (rs.next()) {
				count++;
			}
			if (count == 0) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, id_user);
				preparedStatement.setInt(2, id_clinic);
				preparedStatement.executeUpdate();
			}

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
