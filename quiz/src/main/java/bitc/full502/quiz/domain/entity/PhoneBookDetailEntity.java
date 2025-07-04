package bitc.full502.quiz.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_phone_book_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBookDetailEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int detailSeq;

  @Column
  private LocalDate birthDate;

  @Column(length = 500)
  private String memo;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "phone_seq")
  @ToString.Exclude
  @JsonBackReference // Json 데이터로 변환 시 순환 참조 방지, 참조키를 사용하는 테이블 용
  private PhoneBookEntity phoneBook;
}














