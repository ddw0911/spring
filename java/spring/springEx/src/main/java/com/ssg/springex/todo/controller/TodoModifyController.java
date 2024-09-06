package com.ssg.springex.todo.controller;

import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet(name="TodoModifyController", value ="/todo/modify")
public class TodoModifyController extends HttpServlet {

  private TodoService todoService = TodoService.INSTANCE;
  private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long tno = Long.parseLong(req.getParameter("tno"));
    try {
      TodoDTO dto = todoService.getDTO(tno);
      req.setAttribute("dto", dto);
      req.getRequestDispatcher("/todo/modify.jsp").forward(req, resp);
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String finished = req.getParameter("finished");
    TodoDTO dto = TodoDTO.builder()
            .tno(Long.parseLong(req.getParameter("tno")))
            .title(req.getParameter("title"))
            .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATE_TIME_FORMATTER))
            .finished(finished != null && finished.equals("on"))
            .build();
    log.info(dto);
    try {
      todoService.modify(dto);
    } catch (Exception e) {
      e.printStackTrace();
    }
    resp.sendRedirect("/todo/list");
  }
}
