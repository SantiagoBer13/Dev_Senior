package com.dev.DAO;

import java.sql.Connection;
import java.util.List;

import com.dev.Connection.DatabaseConnection;

public abstract class AbstractDAO<T, ID> {
    protected Connection connection;

    public AbstractDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void closeConnection() {
        DatabaseConnection.getInstance().closeConnection();
    }

    public abstract T findById(ID id);
    public abstract List<T> findAll();
    public abstract void insert(T entity);
    public abstract void update(T entity);
    public abstract void delete(ID id);
}
