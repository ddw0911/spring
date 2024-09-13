package com.ssg.springtodoservice.controller;

import com.ssg.springtodoservice.domain.TodoVO;
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
    model.addAttribute("dtoList", todoService.getAll());
  }

  @GetMapping({"/read", "/modify"}) // 여러 로직 처리가능하도록 배열처리
  public void read(Model model, Long tno) {
    log.info("read .....");
    TodoDTO dto = todoService.getOne(tno);
    log.info(dto);
    model.addAttribute("dto", dto);
  }

  @GetMapping("/register")
  public void registerGET() {
    log.info("register GET .....");
  }

  @PostMapping("/register")
  public String registerPOST(@Valid TodoDTO todoDTO, BindingResult bindingResult,
      RedirectAttributes redirectAttributes) {
    log.info("register POST .....");

    if (bindingResult.hasErrors()) { // 에러발생 시
      log.info("error .....");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      return "redirect:/todo/register";
    }

    log.info(todoDTO);
    todoService.register(todoDTO);
    return "redirect:/todo/list"; // todo/list.jsp 로 이동
  }

  @PostMapping("/remove")
  public String remove(Long tno, RedirectAttributes redirectAttributes) {
    log.info("remove .....");
    log.info("tno = " + tno);
    todoService.remove(tno);
    return "redirect:/todo/list";
  }

  @PostMapping("/modify")
  public String modify(@Valid TodoDTO dto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    log.info("modify .....");

    if(bindingResult.hasErrors()) {
      log.info("error .....");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      redirectAttributes.addFlashAttribute("tno", dto.getTno());
      return "redirect:/todo/modify";
    }

    log.info(dto);
    todoService.modify(dto);

    return "redirect:/todo/list";
  }
}
