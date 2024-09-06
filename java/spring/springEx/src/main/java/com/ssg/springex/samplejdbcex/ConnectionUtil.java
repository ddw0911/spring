package com.ssg.springex.samplejdbcex;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {

    INSTANCE;


    private HikariDataSource ds;


    ConnectionUtil() {
        HikariConfig config = new HikariConfig();  // Corrected class name

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/ssg?serverTimezone=UTC");  // Corrected method name
        config.setUsername("root");
        config.setPassword("1234");  // Corrected method name
        config.addDataSourceProperty("cachePrepStmts", "true");  // Corrected method name
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");


        ds = new HikariDataSource(config);
    }
    public Connection getConnection() throws  Exception{
        return ds.getConnection();
    }
}