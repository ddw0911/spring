package com.ssg.todo.util;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;

@Getter
public enum ModelMapperUtil {
  INSTANCE;

  private ModelMapper modelMapper;

  ModelMapperUtil() {
    this.modelMapper=new ModelMapper();
    this.modelMapper.getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(AccessLevel.PRIVATE)
        .setMatchingStrategy(MatchingStrategies.STRICT);
  }
}
