package bitc.full502.jpastudy.domain.entity;

//  jpa 를 이용한 게시판 테이블
//  게시글번호(기본키), 제목, 내용, 사용자ID, 등록시간, 수정시간, 조회수

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity // 현재 클래스가 데이터베이스 테이블이 되는 클래스
@Table(name = "t_jpa_board") // 데이터베이스 테이블명 직접 설정
@Getter // Getter 메소드 자동 추가
@Setter // Setter 메소드 자동 추가
@NoArgsConstructor // 클래스의 기본 생성자 자동 생성, JPA 에서 사용하는 Entity 클래스에는 기본 생성자가 필수
@AllArgsConstructor // 클래스의 모든 필드에 대한 초기값이 있는 생성자 자동 생성, 필수는 아님
@ToString(callSuper = true) // toString 메소드 자동 추가, callSuper = true 는 상속해주는 부모의 필드에도 toString() 추가
@EqualsAndHashCode(callSuper = true) // equals(), hashCode() 메소드 자동 추가, 부모 클래스의 필드에도 추가
public class JpaBoardEntity extends BaseEntity {

  @Id // 기본키 설정
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 설정(mysql 는 identity 사용)
  private int boardIdx;

  @Column(nullable = false, length = 200) // notnull 설정, 크기 200
  private String title;

  @Column(nullable = false, length = 500)
  private String contents;

  @Column(nullable = false)
  private String createId;

  @Column(nullable = false)
  @ColumnDefault("0") // 기본값 설정
  private int hitCnt;

//  BaseEntity 에서 상속받아 사용
//  @Column(nullable = false)
//  private LocalDateTime createDate = LocalDateTime.now();
//  private LocalDateTime updateDate;

//  영속성 전이 : JPA 를 사용하여 테이블의 관계를 설정하여 사용 시 메인 엔티티의 데이터가 변경될 경우 서브 엔티티의 데이터도 함께 수정되는 것
//  cascade : 영속성 전이 설정을 위한 속성
//    ALL : 모든 영속 상태 변경에 대해서 영속성 전이를 적용
//    PERSIST : 엔티티가 영속화할 때 연관된 엔티티도 함께 영속화
//    MERGE : 엔티티를 영속성 컨텍스트에 병합할 때 연관된 엔티티도 병함
//    REMOVE : 엔티티를 제어할 때 연관된 엔티티도 함께 제거
//    REFRESH : 엔티티를 새로 고침할 때 연관된 엔티티도 새로 고침
//    DETACH : 엔티티를 영속성 컨텍스트에서 제외하면 연관된 엔티티도 제외

//  JPA 에서 사용하는 테이블 관계 어노테이션
//  @OneToOne - 1:1 관계 설정 시 사용
//  @OneToMany - 1:N 관계 설정 시 사용
//  @ManyToOne - N:1 관계 설정 시 사용
//  @ManyToMany - N:N 관계 설정 시 사용, JPA에서 N:N 관계는 잘 사용하지 않음
//    N:N 관계에 있는 Entity 사이에 중간 Entity 를 생성하여 A Entity 와 중간 Entity 를 1:N 관계로 설정하고, B Entity 와 중간 Entity 를 1:N 관계로 설정하여 사용

//  게시판과 댓글은 1:N 관계이므로 OneToMany 를 사용
  @OneToMany(mappedBy = "jpaBoard", cascade = CascadeType.ALL)
  @ToString.Exclude // 상호참조 중지
  private List<JpaReplyEntity> jpaReplyList;
}














