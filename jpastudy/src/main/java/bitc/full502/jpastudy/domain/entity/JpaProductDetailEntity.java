package bitc.full502.jpastudy.domain.entity;

//  상품 상세
//  상품상세번호, 상품설명, 상품명

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_jpa_product_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class JpaProductDetailEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int productDetailIdx; // 상품 설명 번호

  @Column(nullable = false, length = 500)
  private String productDetailDescription; // 상품 설명

//  상품 테이블과 1:1 관계 설정으로 인하여 상품명 컬럼이 필요없음
//  @Column(nullable = false)
//  private String productName; // 상품명

//  상품 상세과 상품은 1:1 관계
  @OneToOne
  @JoinColumn(name = "product_id")
  private JpaProductEntity product;
}














