package bitc.full502.board4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

// entity 클래스 : jpa 에서 데이터베이스의 테이블을 구성하기 위한 클래스
//  mybatis의 dto 클래스와 비슷함

@Entity // spring 프레임워크에 해당 클래스가 데이터베이스 테이블을 구성하기 위한 Entity 클래스임을 알려주는 어노테이션
@Table(name = "t_jpa_board") // @Entity 사용 시 기본적으로 클래스명이 데이터베이스의 테이블명이 됨, 사용자가 원하는 테이블명을 사용하려면 @Table 어노테이션을 사용
@NoArgsConstructor // 해당 클래스의 매개변수가 없는 기본 생성자를 자동 생성하는 어노테이션
@AllArgsConstructor // 해당 클래스의 모든 매개변수가 존재하는 생성자를 자동 생성하는 어노테이션
@Getter // Getter 메소드를 자동 생성
@Setter // Setter 메소드를 자동 생성
public class BoardEntity {

  @Id // 해당 필드를 기본키로 설정
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 옵션 사용 방식 설정
  private int boardIdx;

  @Column(name = "title", nullable = false, length = 100)
  private String title;

  @Column(nullable = false, length = 500)
  private String contents;

  @Column(nullable = false, length = 45)
  private String createId;

  @Column(nullable = false)
  private LocalDateTime createDate = LocalDateTime.now(); // 현재 시간으로 기본값 설정

  private String updateId;
  private LocalDateTime updateDate;

  @Column(nullable = false)
  @ColumnDefault("0") // 기본값 설정
  private int hitCnt;
}














