package bitc.full502.board5.data.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_jpa_reply")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReplyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int replyIdx;

//  @Column(nullable = false)
//  private int boardIdx;

  @Column(nullable = false, length = 200)
  private String contents;

  @Column(nullable = false)
  private String createId;

  @Column
  private LocalDateTime createDate = LocalDateTime.now();

  private LocalDateTime updateDate;

//  참조키 설정
  @ManyToOne
  @JoinColumn(name = "board_idx")
  @ToString.Exclude
  private BoardEntity board;
}














