package com.ssg.springtodoservice.service;

import com.ssg.springtodoservice.dto.PageRequestDTO;
import com.ssg.springtodoservice.dto.PageResponseDTO;
import com.ssg.springtodoservice.dto.TodoDTO;
import com.ssg.springtodoservice.mapper.TodoMapper;
import java.time.LocalDate;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TodoServiceTest {

  @Autowired(required = false)
  private TodoService todoService;

  @Test
  void testRegister() {
    TodoDTO todoDTO = TodoDTO.builder()
        .title("Test")
        .dueDate(LocalDate.now())
        .writer("ssg")
        .build();

    todoService.register(todoDTO);
  }

  @Test
  void testPaging() {
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
        .page(1)
        .size(10)
        .build();

    PageResponseDTO<TodoDTO> pageResponseDTO = todoService.getList(pageRequestDTO);
    log.info(pageResponseDTO);

//    pageResponseDTO.getDtoList().forEach(todoDTO->log.info(todoDTO));
  }
}