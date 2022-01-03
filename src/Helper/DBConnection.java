package Helper;

import java.sql.*;

public class DBConnection {
	Connection c = null;

	public DBConnection() {

	}

	public Connection connDB() {
		try {
			this.c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/medical?user=postgres&password=admin");
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}
}

//this.c = DriverManager.getConnection("jdbc:postgresql://ec2-34-255-134-200.eu-west-1.compute.amazonaws.com:5432/d6tobp9lumihap?user=jxqamexcdvqxkx&password=2ac3d11e133a88f5559dfd5bfc8adc53950f9a4df586ef4714610d8e683b1bc0");