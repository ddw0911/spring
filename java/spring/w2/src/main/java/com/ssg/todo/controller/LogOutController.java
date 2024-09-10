package com.ssg.todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/logout")
public class LogOutController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    log.info("logout...");

    HttpSession session = req.getSession();
    session.removeAttribute("login"); // 세션의 데이터 삭제
    session.invalidate(); // 세션 종료 (속성도 삭제하므로 removeAttribute 생략가능)

    resp.sendRedirect("/login");
    }
}
