package com.ssg.springex.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoTest {
    @Test
    public void test1() {
        int v1 = 10;
        int v2 = 10;
        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void test2() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssg?serverTimezone=UTC", "root", "1234");

        Assertions.assertNotNull(connection);
        //Assertions.assertNotNull(connection);
        connection.close();

    }
}
