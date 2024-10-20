package com.example.JDBCdemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee (name, age, designation) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getDesignation());
    }

    @Override
    public Employee getById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee SET name = ?, age = ?, designation = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getDesignation(), employee.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static final class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setAge(rs.getInt("age"));
            employee.setDesignation(rs.getString("designation"));
            return employee;
        }
    }
}
