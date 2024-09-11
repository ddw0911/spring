package com.ssg.springex.mapper;

import org.apache.ibatis.annotations.Select;

// 데이터베이스의 현재시각을 문자열로 처리 (Mapper Interface)
public interface TimeMapper {
  @Select("select now()")
  String getTime();
}
