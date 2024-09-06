package com.ssg.springex.todo.controller;

import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet(name="TodoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

  private TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    System.out.println("todo/read ...");
      log.info("todo/read ...");
//    Long tno = Long.parseLong(req.getParameter("tno"));
////    TodoDTO dto = TodoService.INSTANCE.getDTO(tno);
////    req.setAttribute("dto", dto);
//    req.getRequestDispatcher("/todo/read.jsp").forward(req,resp);
      Long tno = Long.parseLong(req.getParameter("tno"));
    try {
      TodoDTO dto = todoService.getDTO(tno);
      req.setAttribute("dto", dto);
      req.getRequestDispatcher("/todo/read.jsp").forward(req, resp);
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new ServletException("read page error");
    }
  }
}
