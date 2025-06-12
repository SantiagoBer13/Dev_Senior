package com.dev.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dev.Model.Department;

public class DepartmentDao extends AbstractDAO<Department, Integer> {

    @Override
    public Department findById(Integer id) {
        Department department = null;
        String sql = "SELECT * FROM departments WHERE department_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    department = new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getInt("location_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM departments";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Department department = new Department(
                    rs.getInt("department_id"),
                    rs.getString("department_name"),
                    rs.getInt("location_id")
                );
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public void insert(Department entity) {
        String sql = "INSERT INTO departments (department_name, location_id) VALUES (?, ?)";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getDepartment_name());
            stmt.setInt(2, entity.getLocation_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Department entity) {
        String sql = "UPDATE departments SET department_name = ?, location_id = ? WHERE department_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getDepartment_name());
            stmt.setInt(2, entity.getLocation_id());
            stmt.setInt(3, entity.getDepartment_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM departments WHERE department_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
