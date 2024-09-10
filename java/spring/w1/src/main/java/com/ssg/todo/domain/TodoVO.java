package com.ssg.todo.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {
  private long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;
}
