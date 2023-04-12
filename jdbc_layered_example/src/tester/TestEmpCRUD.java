package tester;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class TestEmpCRUD {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)){
			
			//create single instance of DAO (initialization phase of application)
			EmployeeDaoImpl dao=new EmployeeDaoImpl(); //for getting singleton connection
			boolean exit=false;
			while(!exit) {
				System.out.println("1. Get Employee Details");
				System.out.println("10. Exit");
				try {
					switch (sc.nextInt()) {
					case 1://get all emp details
						System.out.println("Enter dept, begin date and end date(YYYY-MM-DD)");
						List<Employee> empList=dao.getSelectedEmpDetails(sc.next(), Date.valueOf(sc.next()), Date.valueOf(sc.next()));
						empList.forEach(System.out::println);
						break;

					case 10:
						exit=true;
						//destroy or shut down phase , first we need to cleanup resources
						dao.cleanUp();
						break;
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
