package com.example.JDBCdemo;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        // Test CRUD operations
        Employee emp1 = new Employee();
        emp1.setName("John Doe");
        emp1.setAge(30);
        emp1.setDesignation("Software Engineer");

        // Save employee
        employeeService.save(emp1);
        System.out.println("Employee saved successfully: " + emp1);

        // Get employee by ID
        Employee retrievedEmp = employeeService.getById(emp1.getId());
        System.out.println("Retrieved Employee: " + retrievedEmp);

        // Update employee
        retrievedEmp.setDesignation("Senior Software Engineer");
        employeeService.update(retrievedEmp);
        System.out.println("Employee updated successfully: " + retrievedEmp);

        // Get all employees
        List<Employee> allEmployees = employeeService.getAll();
        System.out.println("All Employees:");
        for (Employee emp : allEmployees) {
            System.out.println(emp);
        }

        // Delete employee
        employeeService.delete(retrievedEmp.getId());
        System.out.println("Employee deleted successfully.");

        // Check if deleted
        Employee deletedEmp = employeeService.getById(retrievedEmp.getId());
        System.out.println("After deletion, employee found: " + deletedEmp);
    }
}
