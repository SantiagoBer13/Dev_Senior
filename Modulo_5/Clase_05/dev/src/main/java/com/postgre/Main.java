package com.postgre;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/devseniior";
        String user = "postgres";
        String pass = "Sbtrap2002";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, user, pass);

            Statement stmt = conn.createStatement();
            //stmt.execute();

            ResultSet res = stmt.executeQuery("SELECT * FROM employees");
            while (res.next()) {
                System.out.printf("%n%s    %s", res.getString(1), res.getString(2));
            }

            res.close();
            stmt.close();
            conn.close();

            System.out.println("Conexion Exitosa.");
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("Hello world!");
    }
}