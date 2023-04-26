package com.example.memora_v2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "memora";
        String databaseUser = "root";
        String databasePassword = "18461860";
        String url = "jdbc:mysql://localhost/" + databaseName + "?allowMultiQueries=true";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;

    }
}

