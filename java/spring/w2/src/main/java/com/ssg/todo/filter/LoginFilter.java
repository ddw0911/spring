package com.ssg.todo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/todo/*"})
public class LoginFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest rq = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;

    HttpSession session = rq.getSession();
    if(session.getAttribute("login") == null) {
      resp.sendRedirect("/login"); // 세션에 login 정보가 없으면 로그인 페이지로
      return;
    }

    filterChain.doFilter(rq, resp); // 다음단계(servlet, jsp)로 갈 수 있도록 필터링

  }
}
