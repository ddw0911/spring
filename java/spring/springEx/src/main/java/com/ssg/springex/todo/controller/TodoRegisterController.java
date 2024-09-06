package com.ssg.springex.todo.controller;

import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet(name="TodoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

  private TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("입력화면 register.jsp 로 GET");
    RequestDispatcher rd = req.getRequestDispatcher("/todo/register.jsp");
    rd.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    System.out.println("입력을 처리하고 목록 페이지로 이동");
    log.info("입력을 처리하고 목록 페이지로 이동");
    TodoDTO dto = TodoDTO.builder()
            .title(req.getParameter("title"))
            .dueDate(LocalDate.parse(req.getParameter("dueDate")))
            .build();
    log.info(dto);

    try {
      todoService.register(dto);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    resp.sendRedirect("/todo/list");
  }
}
