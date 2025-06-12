package com.dev.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection  {
    private static DatabaseConnection instance;
    private Connection connection;

    private static final String URL = "jdbc:postgresql://localhost:5432/human_resources";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Sbtrap2002";

    private DatabaseConnection() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo conectar a la base de datos.");
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
    if (connection != null) {
        try {
            connection.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
}
