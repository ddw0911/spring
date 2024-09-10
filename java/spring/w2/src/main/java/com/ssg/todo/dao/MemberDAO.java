package com.ssg.todo.dao;

import com.ssg.todo.domain.MemberVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lombok.Cleanup;

public class MemberDAO {

  public MemberVO getWithPassword(String mid, String mpw) throws Exception {
    String query = "SELECT * FROM tbl_member where mid = '" + mid + "' and mpw = '" + mpw + "'";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(query);
    @Cleanup ResultSet rs = pstmt.executeQuery();
    rs.next();
    MemberVO vo = MemberVO.builder()
        .mid(rs.getString("mid"))
        .mpw(rs.getString("mpw"))
        .mname(rs.getString("mname"))
        .build();
    return vo;
  }

}
