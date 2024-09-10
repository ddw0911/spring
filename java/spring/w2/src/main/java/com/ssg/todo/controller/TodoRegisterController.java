package com.ssg.todo.controller;

import com.ssg.todo.dto.TodoDTO;
import com.ssg.todo.service.TodoService;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet(name="TodoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

  private TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    System.out.println("입력화면 register.jsp 로 GET");
    log.info("register GET ...");

    HttpSession session = req.getSession(); // WAS 가 제공하는 session 불러오기

    if (session.isNew()) { // 새로운 세션인지 체크
      log.info("새로운 JSESSIONID 입니다");
      resp.sendRedirect("/login");
      return;
    }

    if (session.getAttribute("login") == null) {
      log.info("login 정보가 없는 사용자입니다.");
      resp.sendRedirect("/login");
    }

    req.getRequestDispatcher("/todo/register.jsp").forward(req, resp);
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
