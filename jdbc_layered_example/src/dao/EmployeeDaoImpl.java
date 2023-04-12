package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.openConnection;
import pojos.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
	//state: instance var
	private Connection cn;
	private PreparedStatement pst1;
	
	//we need to get fix DB connection or any stmt exactly once , so will call constructor which do init time type job
	public EmployeeDaoImpl() throws SQLException{
		cn=openConnection();
		pst1=cn.prepareStatement("select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?" );
		System.out.println("Employee DAO created !!!");//Just for debugging purpose
	}

	@Override
	public List<Employee> getSelectedEmpDetails(String deptId, Date beginDate, Date endDate) throws SQLException {
		List<Employee> emps=new ArrayList<>();
		// Tester can call this method many times between service phase
		//firstly set IN parameters
		pst1.setString(1, deptId);
		pst1.setDate(2, beginDate);
		pst1.setDate(3, endDate);
		try(ResultSet rst=pst1.executeQuery()){
			while(rst.next())
				//we are just collecting result here and send it to the caller(tester)
				emps.add(new Employee(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDate(4)));//col pos according to pst1
			
		}
		return null;
	}
	
	//add a method to clean up DB resources (no need to close RST because we are returning it back as output.
	public void cleanUp() throws SQLException{
		if(pst1!=null)
			pst1.close();
		if(cn!=null)
			cn.close();
		System.out.println("Emp DAO cleaned up");
	}

}
