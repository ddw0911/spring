package com.ssg.sb01.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class SampleController {

  @GetMapping("/hello") // resources.templates 의 html 파일 매핑
  public void hello(Model model) {
    log.info("hello !!!");
    model.addAttribute("msg", "hello to you");
  }

  @GetMapping("/ex/ex01")
  public void ex01(Model model) {
    log.info("ex01 !!!");
    List<String> list = Arrays.asList("빨강", "주황", "노랑");
    model.addAttribute("list", list);
  }

   class SampleDTO{
    private String p1,p2,p3;

     public String getP1() {
       return p1;
     }

     public String getP2() {
       return p2;
     }

     public String getP3() {
       return p3;
     }
   }

  @GetMapping("/ex/ex02")
  public void ex02(Model model) {
    log.info("ex02 !!!");

    List<String> list = IntStream.range(1, 10).mapToObj(i -> "Data " + i)
        .collect(Collectors.toList());
    model.addAttribute("list", list);

    Map<String, String> map = new HashMap<>();
    map.put("A", "수박");
    map.put("B", "참외");
    map.put("C", "멜론");
    model.addAttribute("map", map);

    SampleDTO dto = new SampleDTO();
    dto.p1 = "value -- p1";
    dto.p2 = "value -- p2";
    dto.p3 = "value -- p3";

    model.addAttribute("dto", dto);
  }

  @GetMapping("/ex/ex03")
  public void ex03(Model model) {
    log.info("ex03 !!!");
    model.addAttribute("arr", new String[]{"a", "b", "c"});
  }

}
