package com.kopek.stockAndSales.apiModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    Connection conn = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String IP = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "factandstock";
    private static final String USER = "root";
    private static final String PASSWORD = "Rafaela$12";

    private static final String CADENA = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;

    public Conexion() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(CADENA, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se conectó a la base de datos, error: " + e.getMessage());
        }
    }

    public Connection openConnection() {
        return conn;
    }

    public void closedConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
}
