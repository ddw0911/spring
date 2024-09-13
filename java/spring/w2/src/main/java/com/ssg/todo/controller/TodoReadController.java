package com.ssg.todo.controller;

import com.ssg.todo.dto.TodoDTO;
import com.ssg.todo.service.TodoService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
      log.info("/todo/read ...");
//    Long tno = Long.parseLong(req.getParameter("tno"));
////    TodoDTO dto = TodoService.INSTANCE.getDTO(tno);
////    req.setAttribute("dto", dto);
//    req.getRequestDispatcher("/todo/read.jsp").forward(req,resp);
      Long tno = Long.parseLong(req.getParameter("tno"));
    try {
      TodoDTO dto = todoService.getDTO(tno);
      req.setAttribute("dto", dto);
      // 쿠키 찾기
      Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos"  );
      String todoListStr = viewTodoCookie.getValue();
      boolean exist = true;

      if (todoListStr != null && todoListStr.indexOf(tno + "-") >= 0) {
        exist = true;
      }

      log.info("exist:" + exist);

      if (!exist) {
        todoListStr += tno + "-";
        viewTodoCookie.setValue(todoListStr);
        viewTodoCookie.setMaxAge(60*60);
        viewTodoCookie.setPath("/");
        resp.addCookie(viewTodoCookie);
      }

      req.getRequestDispatcher("/todo/read.jsp").forward(req, resp);
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new ServletException("read page error");
    }
  }

  private Cookie findCookie(Cookie[] cookies, String cookieName) {
    Cookie targetCookie = null;
    if(cookies != null && cookies.length > 0) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals(cookieName)) {
          targetCookie = cookie;
          break;
        }
      }
    }
    if(targetCookie == null) {
      targetCookie = new Cookie(cookieName,"");
      targetCookie.setPath("/");
      targetCookie.setMaxAge(60*60*1);
    }
    return targetCookie;
  }
}
