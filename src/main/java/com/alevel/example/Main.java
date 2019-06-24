package com.alevel.example;

import com.alevel.example.sql.CreateTable;
import com.alevel.example.sql.InsertData;
import com.alevel.example.sql.SelectData;
import com.alevel.example.sql.UpdateData;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private final static String url = "jdbc:h2:~/test";
    private final static String user = "sa";
    private final static String password = "";

    public static void main(String[] args) {
        System.out.println("Start");
        org.h2.Driver.load();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            new CreateTable().create(connection);

            new InsertData().insert(connection);

            new SelectData().select(connection);

            new UpdateData().update(connection);

            new SelectData().select(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("The end");
    }

}
