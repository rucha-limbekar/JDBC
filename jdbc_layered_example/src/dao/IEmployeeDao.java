package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pojos.Employee;

//tester will call the methods included in DAO I/F
public interface IEmployeeDao {

	/*
	 * Display details(id,name,salary,join date) of all emps from a specific dept ,
	 * joined between strt date n end date sql : select id,name,salary,join_date
	 * from my_emp where deptid=? and join_date between ? and ?
	 */
	//add a method declaration for getting selected emps
	List<Employee> getSelectedEmpDetails(String deptId, Date beginDate, Date endDate) throws SQLException;

	//add new employee
	String addNewEmployee(Employee e) throws SQLException;
	
	//add a method to update emp dept and salary incr
	String updateEmpDetails(int empId, double salIncr, String deptId) throws SQLException;
	
	//add a new method to delete employee
	String deleteEmployee(int empId) throws SQLException;
}
