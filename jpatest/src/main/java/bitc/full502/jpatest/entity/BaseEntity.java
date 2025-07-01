package bitc.full502.jpatest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//  JPA Audit : 감시하다라는 의미로 각 데이터마다 누가 언제 데이터를 생성하고, 변경했는지 감시하는 기능
//  JPA Audit 기능 활성화
//  1. : Application 클래스에 @EnableJpaAuditing 어노테이션 추가
//  2. : @Configuration 어노테이션을 사용하는 설정 클래스 생성 후 @EnableJpaAuditing 어노테이션 추가

//  JPA Audit 기능 활성화 시 Entity 클래스의 상속이 가능함

//  @MappedSuperclass : JPA Entity 클래스가 상속받을 경우 자식 클래스에 매핑 정보를 전달하는 어노테이션, 해당 클래스는 데이터베이스 테이블을 생성하지 않고, 자식 클래스에 자신의 멤버를 상속해줌
//  공통적으로 사용되는 필드를 묶어서 부모 Entity로 선언 후 상속받아 사용함
//  @EntityListeners : Entity를 데이터베이스에 적용하기 전후로 콜백을 요청할 수 있도록 하는 어노테이션
//  AuditingEntityListener : Entity 의 Auditing 정보를 주입하는 JPA Entity 리스너 클래스

@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

//  @CreatedDate : 데이터 생성 날짜 및 시간을 자동으로 주입하는 어노테이션, JPA Auditing 기능이 활성화되어 있어야 함
  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime createDate;

//  @LastModifiedDate : 데이터 수정 날짜 및 시간을 자동으로 주입하는 어노테이션, JPA Auditing 기능이 활성화되어 있어야 함
  @LastModifiedDate
  private LocalDateTime updateDate;

//  @CreatedBy : 누가 데이터를 생성했는지에 대한 값을 자동으로 주입하는 어노테이션, JPA Auditing 기능이 활성화되어 있어야 함
//  @CreatedBy
//  @Column(nullable = true)
//  private String createBy;

//  @LastModifiedBy : 누가 데이터를 수정했는지에 대한 값을 자동으로 주입하는 어노테이션, JPA Auditing 기능이 활성화되어 있어야 함
//  @LastModifiedBy
//  @Column(nullable = true)
//  private String updateBy;
}














