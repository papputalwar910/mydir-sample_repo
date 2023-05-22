package com.service;

import java.sql.SQLException;
import java.util.List;

import javax.management.InvalidApplicationException;

import com.model.Employee;

import empdetails.exceptions.InvalidDetailsException;

public interface IEmployeeService {
	public int addEmployee(Employee emp) throws SQLException;
	public int deleteEmployee(int id) throws SQLException;
	public int updateEmployee(int id, Employee emp) throws SQLException, InvalidApplicationException, InvalidDetailsException;
	public List<Employee> viewEmployee() throws SQLException;

}
