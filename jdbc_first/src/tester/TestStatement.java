package tester;
import static utils.DBUtils.openConnection;
import java.sql.*;

public class TestStatement {

	public static void main(String[] args) {
		// Display all the employee details.
		//select * from my_emp; (cs1 database)
		//for this req , we need empty query holder so that we can add query later. Statement i/f
		//for select query , we need to execute that query and we expect in return ResultSet.
		//for connection we just need to call the static method of utils package.

		try(Connection cn=openConnection();
				//create empty Statement object to hold the query.
				Statement st = cn.createStatement(); //returns you the empty stmt obj.
				//execute query and get back ResultSet which is autocloseable
				ResultSet rst=st.executeQuery("select * from my_emp");){
			while(rst.next()) {
				System.out.printf("EmpID %d name %s Addess %s Salary %.1f DeptID &s JoinDate %s%n", 
						rst.getInt(1), rst.getString(2), rst.getString(3), rst.getFloat(4), rst.getString(5),
						rst.getString(6)
						);
			}//rst.close , st.close();, cn.close  as all are autocloseable
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
