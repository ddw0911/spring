package com.ssg.springex.todo.controller;

import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="TodoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("todo/list ...call");
//    List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
//    req.setAttribute("dtoList", dtoList); // list 를 name=value 형태로 req 에 저장
    req.getRequestDispatcher("/todo/list.jsp").forward(req, resp);
  }
}
