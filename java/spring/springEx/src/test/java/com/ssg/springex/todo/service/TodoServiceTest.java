package com.ssg.springex.todo.service;

import static org.junit.jupiter.api.Assertions.*;

import com.ssg.springex.todo.domain.TodoVO;
import com.ssg.springex.todo.dto.TodoDTO;
import java.time.LocalDate;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
@Log4j2
class TodoServiceTest {

  private TodoService todoService;

  @BeforeEach // 테스트 전 자동실행
  public void ready(){
    todoService = TodoService.INSTANCE;
  }

  @Test
  public void register() throws Exception {
    TodoDTO dto = TodoDTO.builder()
        .title("Register Test")
        .dueDate(LocalDate.now())
        .finished(true)
        .build();
    log.info(dto); // 테스트 로그 출력
    todoService.register(dto);
  }
}