package com.ssg.springex.todo.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="TodoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

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
    System.out.println("입력을 처리하고 목록 페이지로 이동");
    resp.sendRedirect("/todo/list");
  }
}
