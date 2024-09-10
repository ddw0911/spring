package com.ssg.todo.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
public class TodoVO {
  private long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;
}
