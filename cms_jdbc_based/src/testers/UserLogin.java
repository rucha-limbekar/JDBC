//1. User Login
//i/p : email ,password
//o/p : User details in case of successful login or login failed message


package testers;

import java.sql.*;
import java.util.Scanner;
import static utils.DBUtils.openConnection;

public class UserLogin {

	public static void main(String[] args) {

		String sql1="select * from users where email=? and password=?";
		try(Scanner sc=new Scanner(System.in);
				Connection cn=openConnection();
				PreparedStatement pst1=cn.prepareStatement(sql1);){
			//accepting IN params from user
			System.out.println("enter the email and password");
			String email=sc.next();
			String pwd=sc.next();
			//set those IN parameters
			pst1.setString(1, email);
			pst1.setString(2, pwd);
			//now we are ready to execute the query
			try(ResultSet rst=pst1.executeQuery()){
				if(rst.next()) {
					System.out.printf("id %d name %s email %s password %s reg_amt %.1f reg_date %s role %s%n",
							rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4)
							,rst.getDouble(5),rst.getDate(6),rst.getString(7));
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
