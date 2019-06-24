package com.alevel.example.sql;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class CreateTableTest {

    private final static String url = "jdbc:h2:~/test";
    private final static String user = "sa";
    private final static String password = "";

    @Test
    public void create() throws Exception {
        org.h2.Driver.load();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            new CreateTable().create(connection);
        }
    }
}