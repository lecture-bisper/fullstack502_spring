package bitc.full502.jpastudy.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // 현재 클래스가 부모 Entity 클래스임을 알려줌
@EntityListeners(AuditingEntityListener.class) // JPA Audit 기능 사용
public class BaseEntity {

  @CreatedDate // JPA 가 데이터베이스에 등록 시간 자동 주입
  @Column(updatable = false)
  private LocalDateTime createDate;

  @LastModifiedDate // JPA 가 데이터베이스에 수정 시간 자동 주입
  private LocalDateTime updateDate;
}














