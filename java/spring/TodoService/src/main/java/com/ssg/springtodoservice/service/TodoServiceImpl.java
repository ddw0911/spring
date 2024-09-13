package com.ssg.springtodoservice.service;

import com.ssg.springtodoservice.domain.TodoVO;
import com.ssg.springtodoservice.dto.PageRequestDTO;
import com.ssg.springtodoservice.dto.PageResponseDTO;
import com.ssg.springtodoservice.dto.TodoDTO;
import com.ssg.springtodoservice.mapper.TodoMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {


  // 의존성 주입이 필요한 객체를 final 로 고정시키고 생성자를 생성 시 주입
  private final TodoMapper todoMapper;
  private final ModelMapper modelMapper;

  @Override
  public void register(TodoDTO todoDTO) {
    log.info(modelMapper);
    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    log.info(todoVO);
    todoMapper.insert(todoVO);
  }

  //  @Override
//  public List<TodoDTO> getAll() {
//    List<TodoDTO> dtoList = todoMapper.selectAll().stream()
//        .map(vo -> modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());
//    return dtoList;
//  }
  @Override
  public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
    List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
    List<TodoDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, TodoDTO.class)).collect(
        Collectors.toList());

    int total = todoMapper.getCount(pageRequestDTO);

    PageResponseDTO pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
        .dtoList(dtoList)
        .total(total)
        .pageRequestDTO(pageRequestDTO)
        .build();
    return pageResponseDTO;
  }

  @Override
  public TodoDTO getOne(long tno) {
    TodoVO vo = todoMapper.selectOne(tno);
    TodoDTO dto = modelMapper.map(vo, TodoDTO.class);
    return dto;
  }

  @Override
  public void remove(long tno) {
    todoMapper.delete(tno);
  }

  @Override
  public void modify(TodoDTO dto) {
    TodoVO vo = modelMapper.map(dto, TodoVO.class);
    todoMapper.update(vo);
  }


}
