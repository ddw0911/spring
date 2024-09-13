package com.ssg.springtodoservice.mapper;

import com.ssg.springtodoservice.domain.TodoVO;
import com.ssg.springtodoservice.dto.PageRequestDTO;
import java.util.List;

public interface TodoMapper {

  String getTime();

  void insert(TodoVO todoVO);

  List<TodoVO> selectAll();

  TodoVO selectOne(long tno);

  void delete(long tno);

  void update(TodoVO vo);

  List<TodoVO> selectList(PageRequestDTO page);

  int getCount(PageRequestDTO page);
}
