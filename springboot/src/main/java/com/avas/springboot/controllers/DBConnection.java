package com.avas.springboot.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String connectionUrl = "jdbc:mysql://localhost:3306/employee_db";

    public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(connectionUrl, "root",  "Asdfgh@1999");
    }

}
