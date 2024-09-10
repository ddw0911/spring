package com.ssg.todo.controller;

import com.ssg.todo.dto.MemberDTO;
import com.ssg.todo.service.MemberService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

  //doGet 은 로그인 화면, doPost 는 로그인처리
  private MemberService memberService = MemberService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info("login...");
    req.getRequestDispatcher("/todo/login.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    String mid = req.getParameter("mid");
//    String mpw = req.getParameter("mpw"); // param 수집
//    String login = mid + mpw;
    MemberDTO dto = MemberDTO.builder()
        .mid(req.getParameter("mid"))
        .mpw(req.getParameter("mpw"))
        .mname(req.getParameter("mname"))
        .build();

    HttpSession session = req.getSession();
    session.setAttribute("login", memberService.login(dto));
    resp.sendRedirect("/todo/list");
  }
}
