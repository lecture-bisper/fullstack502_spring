package bitc.full502.jpatest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;

@Entity
@Table(name = "t_jpa_product_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDetailEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String description;
  
//  @JoinColumn : 참조키 설정을 위한 어노테이션
  @OneToOne
  @JoinColumn(name = "product_number")
  private ProductEntity product;
}














