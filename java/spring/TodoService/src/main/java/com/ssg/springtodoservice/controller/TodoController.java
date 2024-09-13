package com.ssg.springtodoservice.controller;

import com.ssg.springtodoservice.domain.TodoVO;
import com.ssg.springtodoservice.dto.PageRequestDTO;
import com.ssg.springtodoservice.dto.PageResponseDTO;
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

//  @RequestMapping("/list")
//  public void list(Model model) {
//    log.info("list .....");
////    model.addAttribute("dtoList", todoService.getAll());
//
//  }

  @GetMapping("/list")
  public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
    log.info(pageRequestDTO);
    if(bindingResult.hasErrors()) {
      pageRequestDTO = PageRequestDTO.builder().build();
    }
    model.addAttribute("pageResponseDTO", todoService.getList(pageRequestDTO));
  }

  @GetMapping({"/read", "/modify"}) // 여러 로직 처리가능하도록 배열처리
  public void read(Model model, Long tno, PageRequestDTO pageRequestDTO) {
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
  public String remove(Long tno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {
    log.info("remove .....");
    log.info("tno = " + tno);
    todoService.remove(tno);
    redirectAttributes.addAttribute("page", 1);
    redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
    return "redirect:/todo/list";
  }

  @PostMapping("/modify")
  public String modify(@Valid TodoDTO dto, PageRequestDTO pageRequestDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    log.info("modify .....");

    if(bindingResult.hasErrors()) {
      log.info("error .....");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      redirectAttributes.addFlashAttribute("tno", dto.getTno());
      return "redirect:/todo/modify";
    }

    log.info(dto);
    todoService.modify(dto);
    redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
    redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
    return "redirect:/todo/list";
  }
}
