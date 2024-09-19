package com.ssg.sb01.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // JSON 데이터를 전송할 때 사용
@Log4j2
public class SampleJSONController {

  @GetMapping("/helloArr")
  public String[] helloArr() {
    log.info("hello array !!!");

    return new String[]{"사과","당근","토마토"};
  }
}
