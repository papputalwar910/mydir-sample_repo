package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class EmployeeDao implements IEmployeeDao {
Connection con;
PreparedStatement ps;
	@Override
	public int addEmployee(Employee emp) throws SQLException {
		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","root");
		ps=con.prepareStatement("insert into employee values(?,?,?)");
		ps.setInt(1, emp.getEmpID());
		ps.setString(2, emp.getEmpName());
		ps.setDouble(3, emp.getSalary());
		int i = ps.executeUpdate();
		con.close();
		return i;
	}
	@Override
	public int deleteEmployee(int id) throws SQLException {
		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","root");
		ps=con.prepareStatement("delete from employee where id=?");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		con.close();
		return i;
	}

	@Override
	public List<Employee> viewEmployee() throws SQLException {
		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","root");
		ps = con.prepareStatement("select * from employee");
		ResultSet rs = ps.executeQuery();
		List<Employee> empList = new ArrayList<>();
		Employee emp;
		while(rs.next()) {
			int id=rs.getInt(1);
			String name = rs.getString(2);
			double salary = rs.getDouble(3);
			emp = new Employee(id,name,salary);
			empList.add(emp);
		}
		con.close();
		return empList;
	}
	@Override
	public int updateEmployee(int empId,Employee emp) throws SQLException {
		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","root");
		ps = con.prepareStatement("update employee set name = ?,salary = ? where id = ?");
		ps.setString(1, emp.getEmpName());
		ps.setDouble(2, emp.getSalary());
		ps.setInt(3, empId);
		int i = ps.executeUpdate();
		return i;
	}
	@Override
	public int updateEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


}
