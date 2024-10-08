package com.ssg.todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

public enum ModelMapperUtil {
  INSTANCE;

  private ModelMapper modelMapper;

  ModelMapperUtil() {
    this.modelMapper = new ModelMapper();
    this.modelMapper.getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        .setMatchingStrategy(MatchingStrategies.STRICT); // 완벽히 일치할때만 허용
  }

  public ModelMapper getModelMapper() {return this.modelMapper;}
}
