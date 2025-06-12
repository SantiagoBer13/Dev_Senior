package com.dev.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.dev.Model.Employee;

public class EmployeeDao extends AbstractDAO<Employee, Integer> {

    @Override
    public Employee findById(Integer id) {
        Employee employee = null;
        String sql = "SELECT * FROM employees WHERE employee_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getDate("hire_date"),
                        rs.getInt("job_id"),
                        rs.getLong("salary"),
                        rs.getInt("manager_id"),
                        rs.getInt("department_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee(
                    rs.getInt("employee_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getDate("hire_date"),
                    rs.getInt("job_id"),
                    rs.getLong("salary"),
                    rs.getInt("manager_id"),
                    rs.getInt("department_id")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void insert(Employee entity) {
        String sql = "INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getFirst_name());
            stmt.setString(2, entity.getLast_name());
            stmt.setString(3, entity.getEmail());
            stmt.setString(4, entity.getPhone_number());
            stmt.setDate(5, new Date(entity.getHire_date().getTime()));
            stmt.setInt(6, entity.getJob_id());
            stmt.setLong(7, entity.getSalary());
            stmt.setInt(8, entity.getManager_id());
            stmt.setInt(9, entity.getDepartment_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee entity) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, hire_date = ?, job_id = ?, salary = ?, manager_id = ?, department_id = ? WHERE employee_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getFirst_name());
            stmt.setString(2, entity.getLast_name());
            stmt.setString(3, entity.getEmail());
            stmt.setString(4, entity.getPhone_number());
            stmt.setDate(5, new Date(entity.getHire_date().getTime()));
            stmt.setInt(6, entity.getJob_id());
            stmt.setLong(7, entity.getSalary());
            stmt.setInt(8, entity.getManager_id());
            stmt.setInt(9, entity.getDepartment_id());
            stmt.setInt(10, entity.getEmployee_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
