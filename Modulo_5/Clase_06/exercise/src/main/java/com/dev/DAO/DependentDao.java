package com.dev.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dev.Model.Dependent;

public class DependentDao extends AbstractDAO<Dependent, Integer> {

    @Override
    public Dependent findById(Integer id) {
        Dependent dependent = null;
        String sql = "SELECT * FROM dependents WHERE dependent_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    dependent = new Dependent(
                        rs.getInt("dependent_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("relationship"),
                        rs.getInt("employee_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dependent;
    }

    @Override
    public List<Dependent> findAll() {
        List<Dependent> dependents = new ArrayList<>();
        String sql = "SELECT * FROM dependents";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Dependent dependent = new Dependent(
                    rs.getInt("dependent_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("relationship"),
                    rs.getInt("employee_id")
                );
                dependents.add(dependent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dependents;
    }

    @Override
    public void insert(Dependent entity) {
        String sql = "INSERT INTO dependents (first_name, last_name, relationship, employee_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getFirst_name());
            stmt.setString(2, entity.getLast_name());
            stmt.setString(3, entity.getRelationship());
            stmt.setInt(4, entity.getEmployee_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Dependent entity) {
        String sql = "UPDATE dependents SET first_name = ?, last_name = ?, relationship = ?, employee_id = ? WHERE dependent_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getFirst_name());
            stmt.setString(2, entity.getLast_name());
            stmt.setString(3, entity.getRelationship());
            stmt.setInt(4, entity.getEmployee_id());
            stmt.setInt(5, entity.getDependent_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM dependents WHERE dependent_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
