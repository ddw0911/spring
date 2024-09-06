package com.ssg.todo.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class TodoDTO {
  private long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;
}
