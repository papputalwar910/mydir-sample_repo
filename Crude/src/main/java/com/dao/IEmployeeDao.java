package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Employee;

public interface IEmployeeDao {
public int addEmployee(Employee emp) throws SQLException;
public int deleteEmployee(int id)throws SQLException;
public int updateEmployee(int id) throws SQLException;
List<Employee> viewEmployee() throws SQLException;
int updateEmployee(int empId, Employee emp) throws SQLException;
}
