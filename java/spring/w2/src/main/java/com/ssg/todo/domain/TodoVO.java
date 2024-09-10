package com.ssg.todo.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor // Builder 가 모든 인자를 받아 객체생성하는 생성자 필요하므로
public class TodoVO {
  private Long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;

}
