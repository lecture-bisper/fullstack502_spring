package bitc.full502.jpatest.controller;

import bitc.full502.jpatest.entity.ProductEntity;
import bitc.full502.jpatest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class JPATestController {

  private final ProductService productService;

  @GetMapping("/")
  public String index() {
    return "jpa 사용하기";
  }

  @GetMapping("/jpa")
  public ModelAndView useJpa() throws Exception {
    ModelAndView mv = new ModelAndView("jpa/useJpa");

    return mv;
  }

  @ResponseBody
  @PostMapping("/jpa/findById")
  public Object findById() throws Exception {

    ProductEntity product = productService.selectProduct(5);

    return product;
  }

  @ResponseBody
  @PostMapping("/jpa/findAll")
  public Object findAll() throws Exception {

    List<ProductEntity> productList = productService.selectList();

    return productList;
  }

  @ResponseBody
  @PostMapping("/jpa/saveInsert")
  public void saveInsert() throws Exception {
//    임시로 데이터를 만듬, 클라이언트에서 전달받은 데이터
    ProductEntity product = new ProductEntity();
    product.setName("레드불");
    product.setPrice(2500);
    product.setStock(10);
//    product.setDescription("밤샐때는 레드불");
    product.setCreateDate(LocalDateTime.now());

    productService.insertProduct(product);
  }

  @ResponseBody
  @PostMapping("/jpa/saveAllInsert")
  public void saveAllInsert() throws Exception {
//    클라이언트에서 전달받은 데이터, 임시로 직접 만듬
    ProductEntity item1 = new ProductEntity();
    item1.setName("핫식스");
    item1.setPrice(2200);
    item1.setStock(5);
//    item1.setDescription("밤샐때는 핫식스도 좋아요");
    item1.setCreateDate(LocalDateTime.now());

    ProductEntity item2 = new ProductEntity();
    item2.setName("몬스터 에너지");
    item2.setPrice(2300);
    item2.setStock(5);
//    item2.setDescription("핫식스보다 효과가 확실함");
    item2.setCreateDate(LocalDateTime.now());

    ProductEntity item3 = new ProductEntity();
    item3.setName("포카리 스웨트");
    item3.setPrice(2300);
    item3.setStock(5);
//    item3.setDescription("전통적인 에너지음료, ");
    item3.setCreateDate(LocalDateTime.now());

    List<ProductEntity> itemList = new ArrayList<>();
    itemList.add(item1);
    itemList.add(item2);
    itemList.add(item3);

    productService.insertProductList(itemList);
  }

  @ResponseBody
  @PostMapping("/jpa/saveUpdate")
  public void saveUpdate() throws Exception {
    productService.updateProduct(8);
  }

  @ResponseBody
  @PostMapping("/jpa/deleteById")
  public void deleteById() throws Exception {
    productService.deleteProduct(5);
  }

  @ResponseBody
  @PostMapping("/jpa/deleteAll")
  public void deleteAll() throws Exception {
    productService.deleteAllProducts();
  }
}














