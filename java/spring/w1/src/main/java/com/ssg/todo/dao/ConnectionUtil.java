package com.ssg.todo.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;

public enum ConnectionUtil {
  INSTANCE;

  private HikariDataSource ds;

  ConnectionUtil(){
    HikariConfig config = new HikariConfig();

    config.setDriverClassName("com.mysql.cj.jdbc.Driver");
    config.setJdbcUrl("jdbc:mysql://localhost:3306/ssg?serverTimezone=UTC");
    config.setUsername("ssg");
    config.setPassword("ssg");
    config.addDataSourceProperty("cachePrepStmts","true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit","2048");

    ds = new HikariDataSource(config);
  }

  public Connection getConnection() throws Exception {
    return ds.getConnection();
  }
}
