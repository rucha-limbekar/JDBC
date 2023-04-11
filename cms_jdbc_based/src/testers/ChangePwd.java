package testers;

import java.sql.*;
import static utils.DBUtils.openConnection;
import java.util.Scanner;

public class ChangePwd {

	public static void main(String[] args) {
		
		String sql="update users set password=? where email=?";
		try(Scanner sc = new Scanner(System.in);
				Connection cn=openConnection();
				PreparedStatement pst=cn.prepareStatement(sql)){
			//take email from user
			System.out.println("Enter email and password to change");
			String email=sc.next();
			String pwd=sc.next();
			//set IN params
			pst.setString(1, pwd);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("Password updated successfully !!!!");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
