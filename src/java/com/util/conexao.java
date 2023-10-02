package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    public Connection getConnection() throws SQLException {
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                throw new SQLException(e);
        }

        return DriverManager.getConnection("jdbc:mysql://localhost/Clinica","root", "");
    }
}
