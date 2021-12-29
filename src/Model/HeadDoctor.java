package Model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HeadDoctor extends user {
	Connection con = conn.connDB();
	Statement st = null;
	ResultSet rs = null;

	public HeadDoctor(int id, String pasp, String password, String name, String type) {
		super(id, pasp, password, name, type);
	}
	public HeadDoctor() {}
	
	
	public ArrayList<user> getDoctorList() throws SQLException {

		ArrayList<user> list = new ArrayList<>();
		user obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from user1 where type = 'doctor'");
			while(rs.next()) {
				obj = new user(rs.getInt("id"), rs.getString("pasp"), rs.getString("password"), rs.getString("name"), rs.getString("type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return list;
	}
}
