package bitc.full502.jpastudy.domain.entity;

import jakarta.persistence.*;
import lombok.*;

//  JPA를 이용한 게시판 댓글 테이블
//  댓글번호(기본키), 게시판 글번호(참조키), 댓글내용, 사용자ID, 등록시간, 수정시간

@Entity
@Table(name = "t_jpa_reply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class JpaReplyEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int replyIdx;

  @Column(nullable = false)
  private String replyContents;

  @Column(nullable = false)
  private String replyCreateId;

//  @Column(nullable = false)
//  private int boardIdx;

//  fetch : 지연 실행, 연관되어 있는 테이블의 내용을 조회 시 즉시 조회할 것인지 아니면 필요한 순간에 조회할 것인지 설정
//    LAZY(지연 실행), EAGER(즉시 실행)
  @ManyToOne(fetch = FetchType.LAZY) // 댓글과 게시판은 N:1 관계이므로 @ManyToOne 사용
  @JoinColumn(name = "reply_board_idx") // 게시판의 기본키를 참조키로 가져옴, 사용자가 원하는 컬럼명 사용
  @ToString.Exclude
  private JpaBoardEntity jpaBoard;
}














