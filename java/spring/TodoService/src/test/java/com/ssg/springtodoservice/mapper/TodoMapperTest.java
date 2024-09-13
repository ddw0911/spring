package com.ssg.springtodoservice.mapper;

import com.ssg.springtodoservice.domain.TodoVO;
import com.ssg.springtodoservice.dto.PageRequestDTO;
import com.ssg.springtodoservice.dto.PageResponseDTO;
import com.ssg.springtodoservice.dto.TodoDTO;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TodoMapperTest {

  @Autowired(required = false)
  private TodoMapper todoMapper;

  @Test
  void testGetTime() {
    log.info(todoMapper.getTime());
  }

  @Test
  void testSelectAll() {
    List<TodoVO> voList = todoMapper.selectAll();
    voList.forEach(vo->log.info(vo));
  }

  @Test
  void testSelectOne() {
    TodoVO vo = todoMapper.selectOne(3);
    log.info(vo);
  }

  @Test
  void selectList() {
    PageRequestDTO pagingDTO = PageRequestDTO.builder()
        .page(30)
        .size(10)
        .build();

    List<TodoVO> voList = todoMapper.selectList(pagingDTO);
    voList.forEach(vo -> log.info(vo));
  }

  @Test
  void testSelectSearch() {
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
        .page(1)
        .size(10)
        .types(new String[]{"t","w"})
        .keyword("test1")
        .build();
    List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
    voList.forEach(vo -> log.info(vo));
  }
}