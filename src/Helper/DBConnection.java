package Helper;
import java.sql.*;
public class DBConnection {
	Connection c = null;
	
	public DBConnection () {
		
	}
	
	
	public Connection connDB() {
		try {
			this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medical?user=postgress&password=admin");
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
}
