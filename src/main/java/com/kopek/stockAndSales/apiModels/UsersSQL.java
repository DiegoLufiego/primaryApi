package com.kopek.stockAndSales.apiModels;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersSQL {

    private static final String SQL_NEXTUSER = "SELECT ifnull(MAX(ID), 0)+1 as userID FROM users";
    PreparedStatement preparedStatement;
    Conexion conn;
    private ResultSet resultSet;

    public UsersSQL() {
        preparedStatement = null;
        conn = new Conexion();
    }

    public Integer nextUserID() {
        Integer retorno = null;
        try {
            preparedStatement = conn.openConnection().prepareStatement(SQL_NEXTUSER);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                retorno = resultSet.getInt("userID");
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            conn.closedConnection();
        }
        return retorno;
    }
}
