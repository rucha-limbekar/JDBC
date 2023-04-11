package tester;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {

	public static void main(String[] args) {
		
		try {
		// Load mysql connector.(JDBC driver class in method area) : Optional Step
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/cs1?useSSL=false&allowPublicKeyRetrieval=true";
		//API of java.sql.Driver<Manager class
		//public static Connection getConnection(url,uname,pwd) throws SQLException.
		try(Connection cn=DriverManager.getConnection(url, "root", "root")){
			System.out.println("DB connection successfull !!!!!" +cn);//cn gives impl class name of Connection interface.
		}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
