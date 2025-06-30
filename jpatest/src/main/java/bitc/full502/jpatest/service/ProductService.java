package bitc.full502.jpatest.service;

import bitc.full502.jpatest.entity.ProductEntity;

import java.util.List;

public interface ProductService {
  ProductEntity selectProduct(int i) throws Exception;

  List<ProductEntity> selectList() throws Exception;

  void insertProduct(ProductEntity product) throws Exception;
  void insertProductList(List<ProductEntity> productList) throws Exception;
  void updateProduct(long number) throws Exception;

  void deleteProduct(long number) throws Exception;
  void deleteAllProducts() throws Exception;
}














