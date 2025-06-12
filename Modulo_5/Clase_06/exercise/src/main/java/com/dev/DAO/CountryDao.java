package com.dev.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dev.Model.Country;

public class CountryDao extends AbstractDAO<Country, String> {

    @Override
    public Country findById(String id) {
        Country country = null;
        String sql = "SELECT * FROM countries WHERE country_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    country = new Country(
                        rs.getString("country_id"),
                        rs.getString("country_name"),
                        rs.getInt("region_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        String sql = "SELECT * FROM countries";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Country country = new Country(
                    rs.getString("country_id"),
                    rs.getString("country_name"),
                    rs.getInt("region_id")
                );
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public void insert(Country entity) {
        String sql = "INSERT INTO countries (country_id,country_name, region_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getCountry_id());
            stmt.setString(2, entity.getCountry_name());
            stmt.setInt(3, entity.getRegion_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Country entity) {
        String sql = "UPDATE countries SET country_name = ?, region_id = ? WHERE country_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getCountry_name());
            stmt.setInt(2, entity.getRegion_id());
            stmt.setString(3, entity.getCountry_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM countries WHERE country_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}