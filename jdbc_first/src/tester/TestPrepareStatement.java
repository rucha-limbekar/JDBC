package tester;
import java.sql.*;
import java.util.Scanner;
import static utils.DBUtils.openConnection;

public class TestPrepareStatement {

	public static void main(String[] args) {
		String sql="select * from my_emp where deptid=? and join_date>? order by salary";
		try(Scanner sc=new Scanner(System.in);
				//establish DB conn
				Connection cn=openConnection();
				//create PrepareStatement Object (need to create query with unknown params. IN params)
				PreparedStatement pst=cn.prepareStatement(sql);
				){
			System.out.println("enter deptid and date(YYYY-MM-DD)");
			String deptid=sc.next();
			Date joindate=Date.valueOf(sc.next());
			//set all IN parameters
			pst.setString(1, deptid);
			pst.setDate(2, joindate);
			//execute the query : public ResultSet executeQuery() throws SQLExc
			try(ResultSet rst=pst.executeQuery()){
				while(rst.next()) {
					System.out.printf("EmpID %d name %s Addess %s Salary %.1f DeptID &s JoinDate %s%n", 
							rst.getInt(1), rst.getString(2), rst.getString(3), rst.getFloat(4), rst.getString(5),
							rst.getString(6));
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
