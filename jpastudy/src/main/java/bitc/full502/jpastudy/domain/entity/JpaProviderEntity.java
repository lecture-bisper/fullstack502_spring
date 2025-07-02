package bitc.full502.jpastudy.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//  제조사 테이블
//  회사ID, 회사이름, 회사주소, 상품이름
@Entity
@Table(name = "t_jpa_provider")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class JpaProviderEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int companyId; // 기본키, 회사 ID

  @Column(nullable = false)
  private String companyName; // 회사명

  @Column(nullable = true)
  private String companyAddr; // 회사 주소

//  상품 테이블과 1:N 관계 설정 시 필요없음
//  @Column(nullable = false)
//  private String productName; // 제조 상품명

//  제조사와 상품의 관계는 1:N 관계
  @OneToMany(mappedBy = "provider")
  @ToString.Exclude
  private List<JpaProductEntity> productList = new ArrayList<>();
}














