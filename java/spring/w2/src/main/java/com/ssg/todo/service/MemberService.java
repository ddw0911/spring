package com.ssg.todo.service;

import com.ssg.todo.dao.MemberDAO;
import com.ssg.todo.domain.MemberVO;
import com.ssg.todo.dto.MemberDTO;
import com.ssg.todo.util.ModelMapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
  INSTANCE;

  private MemberDAO memberDAO;
  private ModelMapper modelMapper;

  MemberService() {
    this.memberDAO = new MemberDAO();
    this.modelMapper = ModelMapperUtil.INSTANCE.getModelMapper();
  }

  public MemberDTO login(MemberDTO dto) {
    try {
      MemberVO vo = memberDAO.getWithPassword(dto.getMid(), dto.getMpw());
      return modelMapper.map(vo, MemberDTO.class);
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new RuntimeException("invalid mid");
    }
  }
}
