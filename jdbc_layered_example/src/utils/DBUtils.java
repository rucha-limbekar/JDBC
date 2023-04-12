package utils;

import java.sql.*;

public class DBUtils {

	private static Connection cn;

	public static Connection openConnection() throws SQLException{
		if(cn==null) {
			String url="jdbc:mysql://localhost:3306/cs1?useSSL=false&allowPublicKeyRetrieval=true";
			cn=DriverManager.getConnection(url,"root","root");
		}
		return cn;
	}
}
