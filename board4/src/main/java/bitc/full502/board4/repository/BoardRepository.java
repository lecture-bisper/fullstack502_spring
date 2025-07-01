package bitc.full502.board4.repository;

import bitc.full502.board4.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//  Repository 인터페이스 : Jpa 에서 데이터베이스를 컨트롤하기 위한 인터페이스
//  mybatis의 mapper 인터페이스와 비슷함 (mapper + xml)

//  Repository -> CrudRepository -> PagingAndSortingRespository -> JpaRepository 의 상속관계를 가지고 있음
//  사용자는 JpaRepository 를 상속받아 사용 시 모든 기능을 사용할 수 있음
//  사용 시 JpaRepository에 컬렉션으로 실제로 사용할 Entity 및 해당 Entity의 기본키 타입을 매개변수로 사용

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

//  JpaRepository 에서 제공하는 기본 메소드와 쿼리 메소드를 모두 사용할 수 있음
//  기본 메소드
//  count() : sql 의 count() 명령과 동일
//  save() : sql 의 insert, update 명령과 동일
//  saveAll() : 여러개의 데이터를 한번에 save() 하는 기능
//  findById() : sql 의 select 명령과 동일, 기본키를 기준으로 검색
//  findAll() : sql 의 select 명령과 동일, 모든 데이터 가져오기
//  deleteById() : sql 의 delete 명령과 동일, 기본키를 기준으로 검색
//  deleteAll() : sql 의 delete 명령과 동일, 모든 데이터 삭제

//  쿼리 메소드 : JpaRepository 의 기본 메소드로 원하는 기능을 다 사용할 수 없기 때문에 사용자가 원하는 쿼리문을 생성하도록 도와주는 사용자 정의 메소드
  List<BoardEntity> findAllByOrderByBoardIdxDesc();
  
//  @Query : JpaRepository 에서 제공하는 기본 메소드, 쿼리 메소드로 만들기 힘든 복잡한 SQL 쿼리의 경우 JPQL 문법을 사용하여 SQL 쿼리문을 직접 생성하여 사용할 수 있도록 하는 어노테이션
}
