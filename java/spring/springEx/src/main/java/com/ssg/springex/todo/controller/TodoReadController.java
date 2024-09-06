package com.ssg.springex.todo.controller;

import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="TodoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("todo/read ...");

    Long tno = Long.parseLong(req.getParameter("tno"));
    TodoDTO dto = TodoService.INSTANCE.getDTO(tno);
    req.setAttribute("dto", dto);
    req.getRequestDispatcher("/todo/read.jsp").forward(req,resp);
  }
}
