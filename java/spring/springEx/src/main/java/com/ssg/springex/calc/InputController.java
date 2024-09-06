package com.ssg.springex.calc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="inputController" , urlPatterns="/calc/input")
public class InputController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("InputController... doGet ..processing");
    RequestDispatcher rd = req.getRequestDispatcher("/calc/input.jsp"); // 요청에 대한 처리를 배포

    rd.forward(req, resp); // 배포
  }
}
