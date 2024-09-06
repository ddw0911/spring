package com.ssg.springex.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class testHikariCP {

    @Test
    public void testHikari() throws Exception {

        HikariConfig config = new HikariConfig();  // Corrected class name

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/ssg?serverTimezone=UTC");  // Corrected method name
        config.setUsername("root");
        config.setPassword("1234");  // Corrected method name
        config.addDataSourceProperty("cachePrepStmts", "true");  // Corrected method name
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
