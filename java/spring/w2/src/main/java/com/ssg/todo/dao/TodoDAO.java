package com.ssg.todo.dao;

import com.ssg.todo.domain.TodoVO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lombok.Cleanup;

public class TodoDAO {

  public void insert(TodoVO vo) throws Exception {
    String sql =  "insert into tbl_todo (tno, title, dueDate, finished) values(null, ?,?,?)";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

    pstmt.setString(1, vo.getTitle());
    pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
    pstmt.setBoolean(3, vo.isFinished());

    pstmt.executeUpdate();
  }

  public List<TodoVO> selectAllList() throws Exception{
    String sql = "select * from tbl_todo";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
    @Cleanup ResultSet rs = pstmt.executeQuery();

    List<TodoVO> list = new ArrayList<>();

    while (rs.next()) {
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

  public TodoVO selectOne(long tno) throws Exception {
    String sql = "select * from tbl_todo where tno = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setLong(1, tno);
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

  public void delete(long tno) throws Exception {
    String sql = "Delete from tbl_todo where tno = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setLong(1, tno);
    pstmt.executeUpdate();
  }

  public void update(TodoVO vo) throws Exception {
    String sql = "Update tbl_todo set title = ?, dueDate = ?, finished = ? where tno = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

    pstmt.setString(1, vo.getTitle());
    pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
    pstmt.setBoolean(3, vo.isFinished());
    pstmt.setLong(4,vo.getTno());
    pstmt.executeUpdate();
  }
}
