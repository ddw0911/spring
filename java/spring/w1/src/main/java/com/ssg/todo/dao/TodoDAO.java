package com.ssg.todo.dao;

import com.ssg.todo.dto.TodoDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import lombok.Cleanup;

public class TodoDAO {

  public void insert(TodoDTO dto) throws Exception {
    String query = "INSERT tbl_todo values(null,?,?,?)";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(query);
    pstmt.setString(1, dto.getTitle());
    pstmt.setDate(2, Date.valueOf(dto.getDueDate()));
    pstmt.setBoolean(3, dto.isFinished());
    pstmt.executeUpdate();
  }

  public List<TodoDTO> selectAllList() {
    return null;
  }

  public TodoDTO selectOne() {
    return null;
  }

  public void update() {}

  public void delete() {}
}
