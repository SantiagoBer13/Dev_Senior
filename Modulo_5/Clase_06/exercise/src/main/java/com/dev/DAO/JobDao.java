package com.dev.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.Model.Job;

public class JobDao extends AbstractDAO<Job, Integer>{

    @Override
    public Job findById(Integer id) {
        Job job = null;
        String sql = "SELECT * FROM jobs WHERE job_id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    job = new Job(
                        rs.getInt("job_id"), 
                        rs.getString("job_title"),
                        rs.getLong("min_salary"),
                        rs.getLong("max_salary"));
                }
            }
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return job;
    }

    @Override
    public List<Job> findAll() {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)){
            try (ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    Job job;
                    job = new Job(
                        rs.getInt("job_id"), 
                        rs.getString("job_title"),
                        rs.getLong("min_salary"),
                        rs.getLong("max_salary"));
                    jobs.add(job);
                }
            }
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return jobs;
    }

    @Override
    public void insert(Job entity) {
        String sql = "INSERT INTO jobs VALUES (?,?,?,?);";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setInt(1, entity.getJob_id());
            stmt.setString(2, entity.getJob_title());
            stmt.setLong(3, entity.getMin_salary());
            stmt.setLong(4, entity.getMax_salary());
            stmt.executeUpdate();
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }

    @Override
    public void update(Job entity) {
        String sql = "UPDATE jobs SET job_title = ? WHERE job_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getJob_title());
            stmt.setInt(2, entity.getJob_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM jobs WHERE job_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
