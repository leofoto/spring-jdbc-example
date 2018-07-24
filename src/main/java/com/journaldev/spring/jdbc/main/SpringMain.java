package com.journaldev.spring.jdbc.main;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.jdbc.dao.EmployeeDAO;
import com.journaldev.spring.jdbc.model.Employee;

public class SpringMain {

	public static void main(String[] args) {
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
//		Get the EmployeeDAO Bean
//		EmployeeDAO employeeJDBCDAO = ctx.getBean("employeeJDBCDAO", EmployeeDAO.class);
		//To use JdbcTemplate
		EmployeeDAO employeeJDBCDAO = ctx.getBean("employeeDAOJDBCTemplate", EmployeeDAO.class);
		
		//Run some tests for JDBC CRUD operations
		Employee emp = new Employee();
		int rand = new Random().nextInt(1000);
		emp.setId(rand);
		emp.setName("Pandiyan");
		emp.setRole("Java Developer");
		
		//Create
		employeeJDBCDAO.save(emp);
		
		//Read
		Employee emp1 = employeeJDBCDAO.getById(rand);
		System.out.println("Employee Retrieved::"+emp1);
		
		//Update
		emp.setRole("CTO");
		employeeJDBCDAO.update(emp);
		
		//Get All
		List<Employee> empList = employeeJDBCDAO.getAll();
		System.out.println(empList);
		
		//Delete
//		employeeJDBCDAO.deleteById(rand);
		
		//Close Spring Context
		ctx.close();
		
		System.out.println("DONE");
	}

}
