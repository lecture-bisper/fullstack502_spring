package bitc.full502.jpatest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

//  @Entity : JPA에서 해당 클래스가 데이터베이스의 테이블이라는 것을 알려주는 어노테이션
//  테이블 생성 시 클래스 명이 테이블 명이 됨
//  사용자가 원하는 데이터베이스 테이블 명을 사용하고자 할 경우, @Table 어노테이션과 name 속성을 사용함
@Entity
//  @Table : 지정한 엔티티와 실제 데이터베이스 테이블을 연동하는 어노테이션
//  name 속성을 사용하여 사용자가 원하는 이름의 테이블을 생성할 수 있음
@Table(name = "t_jpa_product")
//  @Getter : 롬복 라이브러리에서 제공하는 어노테이션으로 Getter 메소드를 자동으로 생성
@Getter
//  @Setter : 롬복 라이브러리에서 제공하는 어노테이션으로 Setter 메소드를 자동으로 생성
@Setter
//  @NoArgsConstructor : 롬복 라이브러리에서 제공하는 어노테이션으로 매개변수가 없는 기본 생성자를 자동으로 생성
@NoArgsConstructor
//  @AllArgsConstructor : 롬복 라이브러리에서 제공하는 어노테이션으로 필드의 개수만큼 매개변수가 존재하는 생성자를 자동으로 생성
//@AllArgsConstructor
//  @ToString : 롬복 라이브러리에서 제공하는 어노테이션으로 toString 메소드를 자동으로 생성
//  @EqualsAndHashCode : 롬복 라이브러리에서 제공하는 어노테이션으로 equals(), hashCode() 메소드를 자동으로 생성
//  callSuper : 부모 클래스의 필드를 해당 클래스에 포함하는 역할을 하는 속성, 롬복 라이브러리에서 제공
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends BaseEntity {

//  @Id : 해당 필드가 데이터베이스의 기본키(PK) 컬럼임을 나타내는 어노테이션
  @Id
//  @GeneratedValue : 데이터가 추가될 경우 값을 자동으로 증가시킬지 여부를 지정하는 어노테이션(mysql의 ai 옵션)
//  AUTO : 설정에서 선택한 데이터베이스에 따라 자동으로 동작
//  IDENTITY : 기본 키의 생성을 데이터베이스 설정에 따름(mysql)
//  SEQUENCE : 데이터베이스 시퀀스를 사용하여 기본 키를 설정 (oracle 에서 사용)
//  TABLE : 키 생성 테이블을 사용
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long number;

//  @Column : 지정한 필드를 데이터베이스의 컬럼과 연동시키는 어노테이션
//  해당 어노테이션이 없어도 기본적으로 컬럼으로 자동인식 함(기본값 사용)
//  컬럼이 가지고 있는 특성을 적용 시 사용
//  기본적으로 자바 클래스에서 카멜 명명법을 사용 시 데이터베이스에서는 스네이크 명명법으로 적용

//  추가 옵션
//  unique : 컬럼의 유니크 속성 여부 설정 (false 기본)
//  nullable : 컬럼의 null 허용 여부 설정 (true 기본)
//  updatable : 컬럼의 수정 허용 여부 설정 (true 기본)
//  length : 컬럼에 저장될 최대 데이터 크기 설정 (문자열 시 255 기본)
//  name : 실제 데이터베이스 테이블의 컬럼명을 설정 (사용자가 원하는 컬럼명으로 설정 시 사용), 미입력 시 필드명이 그대로 컬럼명으로 인식됨
//  precision : BigDecimal, BigInteger 타입 사용 시 소수점의 자리를 포함하여 전체 자리 수 설정
//  scale : BigDecimal, BigInteger 타입 사용 시 표현할 소수점의 자리 수 설정
  @Column(nullable = false, length = 45)
  private String name;

  @Column(nullable = false)
  private long price;

  @Column(nullable = false)
  private int stock;

//  부모 Entity 인 BaseEntity 에서 createDate, updateDate 필드를 상속받아 사용
//  @Column(updatable = false)
//  private LocalDateTime createDate;
//
//  @LastModifiedDate
//  private LocalDateTime updateDate;

//  새로 추가된 컬럼
//  @Column(nullable = false)
//  private String description;

//  @OneToOne : Jpa Entity 간의 관계 설정 시 1:1 관계를 설정하는 어노테이션
//  mappedBy : 어느 Entity 가 기준이 되는 Entity 인지 설정, @OneToOne 어노테이션 사용 시 양방향 매핑이 아니면 사용하지 않아도 됨
//  @ToString.Exclude : 두 개의 entity에 대한 관계 설정 시 ToString 을 사용하면 순환참조가 발생하기 때문에 순환 참조를 제거하기 위해서 사용함, 양방향 관계 설정이 아닐 경우 사용할 필요없음
  @OneToOne(mappedBy = "product")
  @ToString.Exclude
  private ProductDetailEntity productDetail;

  @ManyToOne
  @JoinColumn(name = "provider_id")
  @ToString.Exclude
  private ProviderEntity provider;
}














