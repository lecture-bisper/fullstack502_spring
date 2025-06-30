package bitc.full502.jpatest.repository;

import bitc.full502.jpatest.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//  Repository : Mybatis의 mapper 기능을 하는 인터페이스
//  JpaRepository 를 상속받아서 JpaRepository 가 제공하는 기본 메소드와 쿼리 메소드를 생성하여 사용할 수 있음
//  mybatis 에서 mapper 인터페이스 + xml 파일 인 것으로 생각하면 됨

//  Repository -> CrudRepository -> PagingAndSortingRepository -> JpaRepository 의 상속관계를 가지고 있음
//  사용자는 JpaRespository 를 상속받아 사용함
//  JpaRepository 상속 시 컬렉션 타입으로 첫번째 매개변수에 사용할 Entity 클래스명, 두번째 매개변수에 해당 Entity 클래스의 기본키(@Id) 픽ㄹ드의 데이터 타입을 입력
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

  //  기본 메소드 : JpaRepository 가 제공하는 메소드로 데이터베이스의 select, insert, update, delete 의 기능을 쉽게 사용할 수 있도록하는 메소드
  //  count() : sql 의 count() 명령과 동일한 기능을 제공하는 JPA 기본 메소드
  //  findById() : sql의 select 기능을 사용할 수 있도록 해주는 JPA 기본 메소드
  //  findAll() : sql의 select 기능을 사용할 수 있도록 해주는 JPA 기본 메소드, 모든 데이터 가져오기
  //  save() : sql의 insert, update 기능을 사용할 수 있도록 해주는 JPA 기본 메소드
  //  saveAll() : 여러개의 데이터에 대해서 save() 기능을 사용하는 JPA 기본 메소드
  //  deleteById() : sql의 delete 기능을 사용할 수 있도록 해주는 JPA 기본 메소드
  //  deleteAll() : sql의 delete 기능을 사용할 수 있도록 해주는 JPA 기본 메소드, 모든 데이터 삭제

  //  쿼리 메소드 : JpaRepository 에서 제공하는 기본 메소드를 가지고 원하는 모든 기능을 사용할 수 없기 때문에 특정 키워드를 사용하여 사용자 정의 메소드를 생성하는 방식의 메소드

  //  쿼리 메소드 생성 방법
  //  리턴타입 + {주제 키워드 + 서술어} 를 조합하여 메소드를 생성 ( {} 안의 부분의 반복 사용 가능)
  //  List<Person> findByLastnameAndEmail(String lastName, String email);

  //  쿼리 메소드의 주제 키워드
  //  find ... By : select 명령을 수행하는 키워드, read ... By, get ... By, query ... By, search ... By, stream ... By 등이 추가로 존재함

  Optional<ProductEntity> findProductEntityByNumber(Long number); // 기본 사용 방식
  Optional<ProductEntity> findByNumber(Long number); // entity 를 이미 지정했기 때문에 entity 생략가능
  Optional<List<ProductEntity>> findAllByName(String name); // 이름을 기준으로 모든 데이터를 가져옴
  ProductEntity queryByName(String name); // 다른 키워드로 데이터 가져오기
  
//  exists ... By : 특정 데이터가 존재하는지 여부를 확인하는 키워드, true/false 반환
  boolean existsByNumber(Long number); // 지정한 번호의 데이터가 있는지 확인
  
//  count ... By : select 명령을 수행 후 쿼리 결과로 나온 레코드의 수를 출력하는 키워드
  int countByName(String name); // 지정한 이름을 사용하는 데이터가 몇개인지 확인
  
//  delete ... By, remove ... By : delete 명령을 수행하는 키워드, delete ... By 는 리턴값이 없음, remove ... By 는 삭제 수를 반환
  void deleteByNumber(Long number); // 지정한 번호를 기준으로 데이터 삭제, 반환값 없음
  int removeByName(String name); // 지정한 이름으로 데이터 삭제, 삭제된 데이터 수 반환

//  First<number> ... , Top<number> ... : select 명령을 수행한 후 조회된 결과를 제한하는 키워드
//  주제 키워드와 By 사이에 입력
  List<ProductEntity> findFirst5ByName(String name); // 조회된 결과 중 처음 5개 데이터만 출력
  List<ProductEntity> findTop5ByNumber(Long number); // 조회된 결과 중 가장 큰 것 5개만 출력
  
//  Is : 조건 키워드, 값의 일치 여부를 조건으로 사용, Equals 와 동일한 기능을 제공
  ProductEntity findByNumberIs(Long number); // 지정한 번호와 같은 데이터를 조회
  ProductEntity findByNumberEquals(Long number); // 지정한 번호와 같은 데이터를 조회

//  (Is)Not : 값의 불일치 조건을 사용하는 키워드, Is 생략 가능
  ProductEntity findByNumberIsNot(Long number); // 지정한 번호와 같지 않은 데이터를 조회
  ProductEntity findByNumberNot(Long number); // 지정한 번호와 같지 않은 데이터를 조회(Is 생략)

//  (Is)Null, (Is)NotNull : 값이 null 인지 확인하는 조건 키워드, Is 생략 가능
  List<ProductEntity> findByUpdateDateNull(); // 수정된 데이터가 null 인 것만 조회 (Is 생략)
  List<ProductEntity> findByUpdateDateIsNull(); // Is 사용
  List<ProductEntity> findByUpdateDateNotNull(); // 수정된 데이터가 null 이 아닌 것만 조회 (Is 생략)
  List<ProductEntity> findByUpdateDateIsNotNull(); // Is 사용

//  (Is)True, (Is)False : Boolean 데이터 타입으로 지정된 컬럼 값을 확인하는 키워드
//  List<ProductEntity> findByIsActiveTrue();
//  List<ProductEntity> findByIsActiveIsTrue();
//  List<ProductEntity> findByIsActiveFalse();
//  List<ProductEntity> findByIsActiveIsFalse();

//  And, Or : 조건을 추가하는 키워드
  ProductEntity findByNumberAndName(Long number, String name); // and 명령으로 조회 조건 추가, 지정한 번호와 이름이 같은 데이터를 조회
  List<ProductEntity> findByNumberOrName(Long number, String name); // or 명령으로 조회 조건 추가, 지정한 번호나 이름을 가지고 있는 데이터를 조회

//  (Is)GreaterThen, (Is)LessThen, (Is)Between : 숫자나 datetime 컬럼을 대상으로 비교 연산에 사용할 수 있는 조건 키워드
//  경계값을 포함할 경우 Equal 키워드를 추가
  List<ProductEntity> findByPriceGreaterThan(Long price); // 지정한 가격 초과 데이터 조회
  List<ProductEntity> findByPriceIsGreaterThan(Long price);
  List<ProductEntity> findByPriceIsGreaterThanEqual(Long price); // 지정한 가격 이상의 데이터 조회

  List<ProductEntity> findByPriceLessThan(Long price); // 지정한 가격 미만 데이터 조회
  List<ProductEntity> findByPriceIsLessThan(Long price);
  List<ProductEntity> findByPriceIsLessThanEqual(Long price); // 지정한 가격 이하의 데이터 조회

  List<ProductEntity> findByPriceBetween(Long lowPrice, Long highPrice); // 지정한 낮은 데이터부터 높은 데이터까지의 모든 데이터를 조회
  List<ProductEntity> findByPriceIsBetween(Long lowPrice, Long highPrice);

//  (Is)Like, (Is)Containing, (Is)StartingWith, (Is)EndingWith : 데이터가 일부 일치하는지 여부를 확인하는 조건 키워드

//  Like : 키워드가 포함되어 있을 경우
  List<ProductEntity> findByNameLike(String name); // 지정한 문자열이 포함되어 있는 이름 조회
  List<ProductEntity> findByNameIsLike(String name);
  
//  Containing : 키워드가 문자열의 양 끝에 있을 경우
  List<ProductEntity> findByNameContains(String name); // 지정한 문자열이 양끝에 포함되어 있는 이름 조회
  List<ProductEntity> findByNameContaining(String name);
  List<ProductEntity> findByNameIsContaining(String name);

//  StartingWith : 키워드가 시작 문자열일 경우
  List<ProductEntity> findByNameStartsWith(String name); // 지정한 문자열로 시작하는 이름 조회
  List<ProductEntity> findByNameStartingWith(String name);
  List<ProductEntity> findByNameIsStartingWith(String name);

//  EndingWith : 키워드가 끝 문자열일 경우
  List<ProductEntity> findByNameEndsWith(String name); // 지정한 문자열로 끝나는 이름 조회
  List<ProductEntity> findByNameEndingWith(String name);
  List<ProductEntity> findByNameIsEndingWith(String name);

//  Order ... Asc|Desc ... Asc|Desc : 쿼리문의 결과를 지정한 컬럼을 기준으로 정렬하는 키워드
  List<ProductEntity> findByNameOrderByNumberAsc(String name); // 지정한 이름으로 데이터를 조회 후 번호를 기준으로 오름차순 정렬
  List<ProductEntity> findByNameOrderByNumberDesc(String name); // 지정한 이름으로 데이터를 조회 후 번호를 기준으로 내림차순 정렬
  List<ProductEntity> findByNameOrderByPriceAscStockDesc(String name); // 지정한 이름으로 데이터를 조회 후 가격을 기준으로 오름차순 정렬을 먼저하고, 재고 수량을 기준으로 내림차순 정렬

//  정렬 사용 시 Sort 객체를 사용하여 정렬하는 것이 가능함
//  쿼리 메소드 생성 후 매개변수에 Sort 객체를 추가하여 정렬
//  List<ProductEntity> findByName(String name); 과 같이 쿼리 메소드를 생성 후 실행 시 Sort 객체를 추가하여 실행
//  productRepository.findByName("도시락", Sort.by(Order.asc("price")));
//  productRepository.findByName("도시락", Sort.by(Order.asc("price"), Order.desc("stock")));


//  @Query : 복잡한 쿼리문은 쿼리 메소드로 생성하기 힘들기 때문에 추가된 어노테이션
//  JPQL(JPA SQL) 문법을 사용하여 SQL 쿼리를 생성
//  복잡한 쿼리 생성 시 도움을 줌
//  검색 조건에 '?순번' 형태로 데이터를 사용함

//  사용법 :
//  @Query("select entity객체명 from entity클래스명 AS entity객체명 where 검색조건1, 검색조건2, ... ")
//  반환타입 메소드명(매개변수1, 매개변수2, ... );
}









