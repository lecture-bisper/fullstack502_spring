package bitc.full502.quiz.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_phone_book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PhoneBookEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int seq;

  @Column(nullable = false, length = 45)
  private String name;

  @Column(nullable = false, length = 11, unique = true)
  private String tel;

  @Column(length = 100)
  private String email;

  @Column
  private String addr;

  @OneToOne(mappedBy = "phoneBook", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude
  @JsonManagedReference // Json 데이터로 변환 시 순환 참조 방지, 기준이 되는 테이블용
  private PhoneBookDetailEntity phoneBookDetail;
}














