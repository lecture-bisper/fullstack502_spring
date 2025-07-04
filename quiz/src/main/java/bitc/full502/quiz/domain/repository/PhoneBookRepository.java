package bitc.full502.quiz.domain.repository;

import bitc.full502.quiz.domain.entity.PhoneBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneBookRepository extends JpaRepository<PhoneBookEntity, Integer> {

//  주제키워드 + entity의 변수명 (매개변수)
//  번호로 검색
  PhoneBookEntity findBySeq(int seq);
//  이름으로 검색
  List<PhoneBookEntity> findAllByName(String name);
//  주어진 텍스트가 일부 포함된 이름으로 검색
  List<PhoneBookEntity> findAllByNameContains(String name);
//  주어진 텍스트가 일부 포함된 이름으로 검색, 내림차순 정렬
  List<PhoneBookEntity> findAllByNameContainsOrderBySeqDesc(String name);
//  전화번호로 검색
  PhoneBookEntity findByTel(String tel);

//  이름과 이메일로 검색
  PhoneBookEntity findByNameAndEmail(String name, String email);


//  @Query : JpaRepository 에서 제공하는 기본 메소드와 쿼리 메소드로 처리하기 힘든 복잡한 SQL 쿼리를 JPQL 문법을 사용하여 직접 SQL 쿼리는 생성하도록 해주는 어노테이션
//  반환타입과 매소드명, 매개변수를 추상 메소드로 생성 후 @Query 를 추가
//  JPQL 문법은 일반 SQL 문법과 비슷한 문법으로 테이블명 대신 Entity 클래스명 입력, select 절에 컬럼명이 아닌 Entity 클래스 타입의 객체를 입력
//  where 절의 검색값은 ' ?순번 ' 으로 입력하고 메소드의 매개변수 순서대로 입력됨
//  :name 방식을 사용하면 순서에 상관없이 사용 가능

  @Query("SELECT pb FROM PhoneBookEntity AS pb WHERE pb.tel = ?1")
  PhoneBookEntity selectPhoneBookDetailTel(String tel);

  @Query("SELECT pb FROM PhoneBookEntity AS pb WHERE pb.name = ?1")
  List<PhoneBookEntity> selectPhoneBookDetailListName(String name);

  @Query("SELECT pb FROM PhoneBookEntity AS pb WHERE pb.name = ?1 AND pb.email = ?2")
  List<PhoneBookEntity> selectPhoneBookDetailListNameAndEmail1(String name, String email);

  @Query("SELECT pb FROM PhoneBookEntity AS pb WHERE pb.name = :name AND pb.email = :email")
  List<PhoneBookEntity> selectPhoneBookDetailListNameAndEmail2(@Param("email") String email, @Param("name") String name);

}









