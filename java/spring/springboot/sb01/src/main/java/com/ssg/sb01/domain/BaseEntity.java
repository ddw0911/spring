package com.ssg.sb01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(value= AuditingEntityListener.class) // Entity 가 데이터베이스에 추가 및 변경 될 때 자동으로 시간 설정
@Getter
abstract class BaseEntity {

  @CreatedDate
  @Column(name = "regiDate", updatable = false)
  private LocalDateTime regiDate;

  @LastModifiedDate
  @Column(name="updateDate")
  private LocalDateTime updateDate;
}
