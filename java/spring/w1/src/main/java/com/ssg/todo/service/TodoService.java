package com.ssg.todo.service;

import com.ssg.todo.dao.TodoDAO;
import com.ssg.todo.dto.TodoDTO;
import java.util.List;
import org.modelmapper.ModelMapper;

public enum TodoService {
  INSTANCE;
  private TodoDAO todoDAO;
  private ModelMapper modelMapper;

  public void register(TodoDTO dto) {

  }

  public List<TodoDTO> getList() {
    return null;
  }
}
