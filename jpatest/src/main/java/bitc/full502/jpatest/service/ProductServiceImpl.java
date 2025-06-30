package bitc.full502.jpatest.service;

import bitc.full502.jpatest.entity.ProductEntity;
import bitc.full502.jpatest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// @Autowired 대신 사용
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

//  @RequiredArgsConstructor 사용 시 final 키워드 필수
//  mybatis의 mapper 대신 JPA의 Repository 를 사용하여 객체 생성
  private final ProductRepository productRepository;

  @Override
  public ProductEntity selectProduct(int i) throws Exception {

    Optional<ProductEntity> item = productRepository.findById((long)i);
    if (item.isPresent()) {
      ProductEntity product = item.get();
      return product;
    }
    else {
      return null;
    }
  }

  @Override
  public List<ProductEntity> selectList() throws Exception {
    List<ProductEntity> itemList = productRepository.findAll();
    return itemList;
  }

  @Override
  public void insertProduct(ProductEntity product) throws Exception {
//    JpaRepository에서 제공하는 save() 메소드를 통해서 데이터베이스 저장
    productRepository.save(product);
  }

  @Override
  public void insertProductList(List<ProductEntity> productList) throws Exception {
//   JpaRepository에서 제공하는 saveAll() 메소드를 통해서 List 의 데이터를 한번에 저장
    productRepository.saveAll(productList);
  }

  @Override
  public void updateProduct(long number) throws Exception {
//    지정한 number 를 기준으로 기존 데이터 검색
    ProductEntity item = productRepository.findById(number).orElse(null);
    item.setName("김혜자 돈까스 도시락");
    item.setDescription("맛있는 돈까스 도시락");
    item.setUpdateDate(LocalDateTime.now());

    productRepository.save(item);
  }

  @Override
  public void deleteProduct(long number) throws Exception {
    productRepository.deleteById(number);
  }

  @Override
  public void deleteAllProducts() throws Exception {
    productRepository.deleteAll();
  }
}














