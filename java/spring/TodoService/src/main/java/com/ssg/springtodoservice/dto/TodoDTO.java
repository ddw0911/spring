package com.ssg.springtodoservice.dto;


import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//  스프링 MVC 에서 파라미터 검증은 Controller 에서 /w @Valid , BindingResult 객체 -> Hibernate validate 라이브러리 필요
public class TodoDTO {
  private long tno;
  @NotEmpty // 필수
  private String title;
  @Future // 현재 이후 시점만
  private LocalDate dueDate;
  @NotEmpty
  private String writer;
  private boolean finished;

}
