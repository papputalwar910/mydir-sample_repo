package com.client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.management.InvalidApplicationException;
import javax.security.auth.login.AccountNotFoundException;

import com.model.Employee;
import com.service.EmployeeService;

public class Client {
	public static void main(String[] args) throws Exception {
		Employee emp;
		String empName;
		List<Employee> empList;
		int result = 0;
		EmployeeService es = new EmployeeService();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Press 1 to add Employee\n" + "press 2 to delete employee\n"
					+ "press 3 to update Employee\n" + "Press 4 to view Employee");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Employee ID");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee Name");
				String name = sc.nextLine();
				System.out.println("Enter Employee Salary");
				double sal = sc.nextDouble();
				emp = new Employee(id, name, sal);
				try {
					result = es.addEmployee(emp);
				} catch (SQLException e) {
					System.err.println(e.getMessage());
					System.out.println("Invalid");
				}
				if (result > 0) {
					System.out.println("Employee Successfull Add");
				} else {
					System.out.println("Employee Not Add");
				}
				break;

			case 2:
				System.out.println("Enter the id to delete");
				int Id = sc.nextInt();

				try {
					result = es.deleteEmployee(Id);
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				if(result>0) {
					System.out.println("Employee Successfully Deleted");
				}
				else {
					System.out.println("Not Deleted");
				}

				break;
			case 3:
				System.out.println("Enter Id which is update");
				
				try {
					int empId=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter new Employee Name");
					 empName=sc.nextLine();
					System.out.println("Enter salary for new employee");
					double newsal=sc.nextDouble();
					emp = new Employee(empId, empName, newsal);
					result = es.updateEmployee(empId, emp);
					if (result > 0) {
						System.out.println(result + " rows updated Successfully");
					} else {
						throw new Exception("Employee not found with id " + empId);
					}
					
				}
				catch(SQLException | AccountNotFoundException|InvalidApplicationException e) {
					System.err.println(e.getMessage());
					
				}
				
				break;
			case 4:
				try {
					empList = es.viewEmployee();
					for (Employee emp1 : empList) {
						System.out.println(emp1);
					}
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
				
			default:
				System.exit(0);
			}
		} while (true);

	}
}
