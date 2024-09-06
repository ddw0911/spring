package com.ssg.todo.dao;

import com.ssg.todo.domain.TodoVO;
import com.ssg.todo.dto.TodoDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

  public List<TodoVO> selectAllList() throws Exception {
    String query = "SELECT * FROM tbl_todo";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(query);
    List<TodoVO> list = new ArrayList<>();
    @Cleanup ResultSet rs = pstmt.executeQuery();
    while(rs.next()) {
      TodoVO vo = TodoVO.builder()
          .tno(rs.getLong(1))
          .title(rs.getString(2))
          .dueDate(rs.getDate(3).toLocalDate())
          .finished(rs.getBoolean(4))
          .build();
      list.add(vo);
    }
    return list;
  }

  public TodoVO selectOne() throws Exception {
    String query = "SELECT * from tbl_todo where tno = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(query);
    @Cleanup ResultSet rs = pstmt.executeQuery();
    rs.next();
    TodoVO vo = TodoVO.builder()
        .tno(rs.getLong(1))
        .title(rs.getString(2))
        .dueDate(rs.getDate(3).toLocalDate())
        .finished(rs.getBoolean(4))
        .build();

    return vo;
  }

  public void update(TodoVO vo) throws Exception {
    String query = "UPDATE tbl_todo SET title =?, dueDate=?, finished=? where tno = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(query);
    pstmt.setString(1, vo.getTitle());
    pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
    pstmt.setBoolean(3, vo.isFinished());
    pstmt.setLong(4, vo.getTno());
    pstmt.executeUpdate();
  }

  public void delete(TodoVO vo) throws Exception {
    String query = "DELETE FROM tbl_todo where tno = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(query);
    pstmt.setLong(1, vo.getTno());
    pstmt.executeUpdate();
  }
}
