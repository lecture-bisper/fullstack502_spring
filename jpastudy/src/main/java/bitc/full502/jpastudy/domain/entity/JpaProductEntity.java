package bitc.full502.jpastudy.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.EnableMBeanExport;

//  상품 테이블
//  상품ID, 상품이름, 상품가격, 상품재고, 제조사, 상세설명
@Entity
@Table(name = "t_jpa_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class JpaProductEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int productId; // 상품 코드

  @Column(nullable = false)
  private String productName; // 상품명

  @Column(nullable = false)
  private long productPrice; // 상품 가격

  @Column(nullable = false)
  @ColumnDefault("0")
  private int productStock; // 재고 수량

//  제조사 테이블과 N:1 관계 설정 시 제조사명 필요없음
//  @Column(nullable = false)
//  private String providerName; // 제조사 명

//  상품 상세 테이블과 1:1 관계 설정 시 상품 설명 컬럼이 필요없음
//  private String description; // 상품 설명

//  상품과 상품 상세는 1:1 관계
  @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude
  private JpaProductDetailEntity productDetail;

//  상품과 제조사는 N:1 관계
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id")
  @ToString.Exclude
  private JpaProviderEntity provider;
}














