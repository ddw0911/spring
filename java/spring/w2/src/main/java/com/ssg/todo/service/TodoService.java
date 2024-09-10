package com.ssg.todo.service;

import com.ssg.todo.dao.TodoDAO;
import com.ssg.todo.domain.TodoVO;
import com.ssg.todo.dto.TodoDTO;
import com.ssg.todo.util.ModelMapperUtil;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
// 정해진 숫자만큼 객체를 생성하기 위해 enum
public enum TodoService {
  INSTANCE;; // 싱글톤 패턴 적용 - TodoService.INSTANCE

  private TodoDAO dao;
  private ModelMapper modelMapper;

  TodoService() {
    // 직접 주입 /w 생성자
    this.dao = new TodoDAO();
    this.modelMapper = ModelMapperUtil.INSTANCE.getModelMapper();
    // DI 사용시 생성자에 파라미터로
  }

  public void register(TodoDTO dto) throws Exception {
    // modelMapper 를 이용해 dto 를 vo 로 변환
    TodoVO vo = modelMapper.map(dto, TodoVO.class);
//    System.out.println("vo = " + vo); // log 로 대체
    log.info(vo);
    dao.insert(vo); // int 반환하므로 예외처리는 후에 진행
  }

  public List<TodoDTO> listAll() throws Exception{
    List<TodoVO> voList = dao.selectAllList();
    log.info(voList);

    List<TodoDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, TodoDTO.class)).collect(
        Collectors.toList());
    return dtoList;
  }

  public TodoDTO getDTO(Long tno) throws Exception {
    log.info(tno);
    TodoVO vo = dao.selectOne(tno);
    TodoDTO dto = modelMapper.map(vo, TodoDTO.class);
    return dto;
  }

  public void remove(Long tno) throws Exception{
    log.info(tno);
    dao.delete(tno);
  }

  public void modify(TodoDTO dto) throws Exception {
    log.info(dto);
    TodoVO vo = modelMapper.map(dto, TodoVO.class);
    dao.update(vo);
  }
}
