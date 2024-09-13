package com.ssg.springtodoservice.service;

import com.ssg.springtodoservice.dto.TodoDTO;
import java.util.List;

public interface TodoService {

  void register(TodoDTO todoDTO);

  List<TodoDTO> getAll();

  TodoDTO getOne(long tno);

  void remove(long tno);

  void modify(TodoDTO dto);
}
