package com.ssg.todo.controller;

import com.ssg.todo.dto.TodoDTO;
import com.ssg.todo.service.TodoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@WebServlet(name = "TodoListController", urlPatterns = "/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {

  private TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    System.out.println("todo/list ...call");
//    List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
//    req.setAttribute("dtoList", dtoList); // list 를 name=value 형태로 req 에 저장
    log.info("### todo List ###");
    try {
      List<TodoDTO> dtoList = todoService.listAll();
      req.setAttribute("dtoList", dtoList);
      req.getRequestDispatcher("/todo/list.jsp").forward(req, resp);
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new ServletException("list error");
    }
  }
}
