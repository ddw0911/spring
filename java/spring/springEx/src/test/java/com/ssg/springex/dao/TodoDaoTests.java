package com.ssg.springex.dao;

import com.ssg.springex.todo.dao.TodoDAO;
import com.ssg.springex.todo.domain.TodoVO;
import com.sun.tools.javac.comp.Todo;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TodoDaoTests {

  TodoDAO dao = new TodoDAO();

  @Test
  public void testInsert() throws Exception {
    TodoVO vo = TodoVO.builder()
        .title("Sample Title....")
        .dueDate(LocalDate.of(2024,9,5))
        .build();

    dao.insert(vo);
  }

  @Test
  public void testList() throws Exception {
    List<TodoVO> list = dao.selectAllList();
    list.forEach(System.out::println);
  }

  @Test
  public void testSelect() throws Exception {
    TodoVO vo = dao.selectOne(2);
    System.out.println(vo);
  }

  @Test
  public void testUpdate() throws Exception {
    TodoVO vo = TodoVO.builder()
        .tno(1L)
        .title("Updated Title")
        .dueDate(LocalDate.now())
        .finished(true)
        .build();
    dao.update(vo);
    System.out.println(vo);
  }
}
