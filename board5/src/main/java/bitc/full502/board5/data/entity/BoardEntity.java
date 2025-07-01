package bitc.full502.board5.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.EnableMBeanExport;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_jpa_bbs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int boardIdx; // 게시물 번호
  @Column(nullable = false)
  private String title; // 제목
  @Column(nullable = false, length = 500)
  private String contents; // 내용
  @Column(nullable = false, name = "create_id")
  private String createId; // 사용자 ID
  @Column(nullable = false)
  private LocalDateTime createDate = LocalDateTime.now(); // 등록시간
  @Column
  private LocalDateTime updateDate; // 수정시간
  @Column
  @ColumnDefault("0")
  private int hitCnt; // 조회수

//  참조키 설정
  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<ReplyEntity> replyList = new ArrayList<>();
}














