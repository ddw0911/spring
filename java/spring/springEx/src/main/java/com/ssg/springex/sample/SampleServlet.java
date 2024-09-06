package com.ssg.springex.sample;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="sampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    System.out.println("Generic Servlet ..."); // WAS(Tomcat 서버)와 라이프사이클이 같다 (리로드, 재배포 되지 않는다는 전제하에)
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("doGet ...." + this);
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("Init ServletConfig ...");
  }

  @Override
  public void destroy() {
    System.out.println("Destroy ServletConfig ...");
  }
}
