package com.kopek.stockAndSales.controllers;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conn = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String ip = "localhost";
    String port = "3306";
    String dbName = "factandstock";
    String user = "root";
    String pass = "Rafaela$12";

    String cadena = "jdbc:mysql://" + ip + ":" + port + "/" + dbName;

    public Conexion() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(cadena, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se conectó a la base de datos, error: " + e.getMessage());
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