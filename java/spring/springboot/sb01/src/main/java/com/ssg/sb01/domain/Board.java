package com.ssg.sb01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Entity 객체
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터베이스에 추가될 때 생성( autoincrement ) 되는 번호를 이용 - 키생성 전략
  private Long bno;

  @Column(length = 500, nullable = false)
  private String title;

  @Column(length = 1000, nullable = false)
  private String content;

  @Column(length = 100, nullable = false)
  private String writer;
}
