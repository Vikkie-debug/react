package com.example.JDBCdemo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
    
    @Autowired
    private EmployeeDAO employeeDAO;

    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
