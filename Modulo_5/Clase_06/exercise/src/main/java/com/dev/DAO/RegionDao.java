package com.dev.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dev.Model.Region;

public class RegionDao extends AbstractDAO<Region, Integer> {

    @Override
    public Region findById(Integer id) {
        Region region = null;
        String sql = "SELECT * FROM regions WHERE region_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    region = new Region(
                        rs.getInt("region_id"),
                        rs.getString("region_name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return region;
    }

    @Override
    public List<Region> findAll() {
        List<Region> regions = new ArrayList<>();
        String sql = "SELECT * FROM regions";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Region region = new Region(
                    rs.getInt("region_id"),
                    rs.getString("region_name")
                );
                regions.add(region);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }

    @Override
    public void insert(Region entity) {
        String sql = "INSERT INTO regions (region_name) VALUES (?)";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getRegion_name());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Region entity) {
        String sql = "UPDATE regions SET region_name = ? WHERE region_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getRegion_name());
            stmt.setInt(2, entity.getRegion_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM regions WHERE region_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
