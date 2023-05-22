package com.service;

import java.sql.SQLException;
import java.util.List;

import javax.management.InvalidApplicationException;

import com.dao.EmployeeDao;
import com.model.Employee;

import empdetails.exceptions.InvalidDetailsException;
import empdetails.util.ValidateEmployee;

public class EmployeeService implements IEmployeeService {
	EmployeeDao ed=new EmployeeDao();
	ValidateEmployee ve = new ValidateEmployee();
	@Override
	public int addEmployee(Employee emp) throws SQLException {
		int i = ed.addEmployee(emp);
		
		return i;
	}
	
	@Override
	public int deleteEmployee(int id) throws SQLException {
		int i=ed.deleteEmployee(id);
		return i;
	}
	
	public int updateEmployee(int empId, Employee emp) throws SQLException, InvalidApplicationException, InvalidDetailsException {
		int i = 0;
		if (ve.validateName(emp.getEmpName())) {
			i = ed.updateEmployee(empId, emp);
		}
		return i;
	}

	public List<Employee> viewEmployee() throws SQLException {
		List<Employee> empList = ed.viewEmployee();
		if (empList.isEmpty()) {
			return null;
		}
		return empList;


	}
}
