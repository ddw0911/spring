package com.ssg.springex.controller;

import java.time.LocalDate;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class SampleController {

  @GetMapping("/hello")
  public void hello() {
    log.info("hello spring web mvc");
  }

  @GetMapping("/ex1")
  public void ex1(String name, int age) {
    log.info("ex1.....");
    log.info("ex1 에서 처리한 이름 " + name);
    log.info("ex1 에서 처리한 나이 " + age);
  }

  // @RequestParam 을 이용해 defaultValue 를 설정
  @GetMapping("/ex2")
  public void ex2(@RequestParam(name="name", defaultValue = "aaa") String name, @RequestParam(name="age", defaultValue = "20") int age) {
    log.info("ex2..........");
    log.info("ex2...name " + name);
    log.info("ex2...name " + age);
  }

  @GetMapping("/ex3")
  public void ex3(LocalDate dueDate) {
    log.info("ex3.....");
    log.info("ex3 에서 처리한 dueDate " + dueDate);
  }
}
