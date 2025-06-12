package com.dev.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dev.Model.Location;

public class LocationDao extends AbstractDAO<Location, Integer> {

    @Override
    public Location findById(Integer id) {
        Location location = null;
        String sql = "SELECT * FROM locations WHERE location_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    location = new Location(
                        rs.getInt("location_id"),
                        rs.getString("street_address"),
                        rs.getString("postal_code"),
                        rs.getString("city"),
                        rs.getString("state_province"),
                        rs.getString("country_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public List<Location> findAll() {
        List<Location> locations = new ArrayList<>();
        String sql = "SELECT * FROM locations";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Location location = new Location(
                    rs.getInt("location_id"),
                    rs.getString("street_address"),
                    rs.getString("postal_code"),
                    rs.getString("city"),
                    rs.getString("state_province"),
                    rs.getString("country_id")
                );
                locations.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public void insert(Location entity) {
        String sql = "INSERT INTO locations (street_address, postal_code, city, state_province, country_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getStreet_address());
            stmt.setString(2, entity.getPostal_code());
            stmt.setString(3, entity.getCity());
            stmt.setString(4, entity.getState_province());
            stmt.setString(5, entity.getCountry_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Location entity) {
        String sql = "UPDATE locations SET street_address = ?, postal_code = ?, city = ?, state_province = ?, country_id = ? WHERE location_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getStreet_address());
            stmt.setString(2, entity.getPostal_code());
            stmt.setString(3, entity.getCity());
            stmt.setString(4, entity.getState_province());
            stmt.setString(5, entity.getCountry_id());
            stmt.setInt(6, entity.getLocation_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM locations WHERE location_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}