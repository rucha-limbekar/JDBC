package utils;
import java.sql.*;

public class DBUtils {

	//add as static method to return the DB conn instance.
	//this method should return same singleton connection of DB so that we are checking cn value
	//this is not as scalable solution.(Scalable:- if the app is working fine for one or two clients then it should give you the same performance even 
	//when number of clients increases.)
	//will be replace by connection pool hibernate onwards.
	private static Connection cn;
	
	public static Connection openConnection() throws SQLException{
		if(cn==null) {
		String url = "jdbc:mysql://localhost:3306/cs1?useSSL=false&allowPublicKeyRetrieval=true";
		cn= DriverManager.getConnection(url,"root","root");
		}
		return cn;
	}
}
