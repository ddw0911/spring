package com.ssg.springtodoservice.controller;

import com.ssg.springtodoservice.dto.TodoDTO;
import com.ssg.springtodoservice.service.TodoService;
import java.net.http.HttpClient.Redirect;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  @RequestMapping("/list")
  public void list(Model model) {
    log.info("list .....");
  }

  @GetMapping("/register")
  public void registerGET() {
    log.info("register GET .....");
  }

  @PostMapping("/register")
  public String registerPOST(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    log.info("register POST .....");

    if(bindingResult.hasErrors()) { // 에러발생 시
      log.info("error .....");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      return "redirect:/todo/register";
    }
    
    log.info(todoDTO);
    todoService.register(todoDTO);
    return "redirect:/todo/list"; // todo/list.jsp 로 이동
  }
}
