package bitc.full502.jpastudy2.domain.repository;

import bitc.full502.jpastudy2.domain.entity.EmployeesEntity;
import bitc.full502.jpastudy2.domain.entity.EnumGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Integer> {

  //  쿼리 메소드 : JPA 에서 제공하는 SQL 생성 메소드
  //  선언 방법
  //  리턴타입 {주제키워드 By Entity필드명} (매개변수, ...);
  
//  finds
//  id 를 기준으로 데이터 가져오기
  Optional<EmployeesEntity> findById(int id); // 기본키인 empNo 로 데이터 가져오기, 약식 방법
  Optional<EmployeesEntity> findEmployeesEntityByEmpNo(int empNo); // 정식 방법
  List<EmployeesEntity> findAllByFirstName(String firstName); // firstName 필드를 사용하여 모두 검색
  List<EmployeesEntity> findAllByGender(EnumGender gender); // gender 필드를 사용하여 모두 검색
  List<EmployeesEntity> findAllByHireDate(LocalDate hireDate); // hireDate 필드를 사용하여 모두 검색

//  주제 키워드 count
  int countByLastName(String lastName); // lastName 필드를 사용하여 지정한 이름과 같은 데이터가 몇개인지 출력

//  주제 키워드 exists
  boolean existsByEmpNo(int empNo); // empNo 필드를 사용하여 지정한 사번을 사용하는 사원이 있는지 확인

//  주제 키워드 delete, remove
  void deleteByEmpNo(int empNo);
  void deleteByFirstName(String firstName);
  int removeByLastName(String lastName);
  int removeByEmpNo(int empNo);

//  주제 키워드 and, or
  List<EmployeesEntity> findByFirstNameAndGender(String firstName, EnumGender gender);
  List<EmployeesEntity> findByFirstNameAndLastNameAndGenderAndBirthDate(String firstName, String lastName, EnumGender gender, LocalDate birthDate);
  List<EmployeesEntity> findByFirstNameOrLastName(String firstName, String lastName);
  List<EmployeesEntity> findByFirstNameOrFirstName(String firstName1, String firstName2);

//  주제 키워드 (범위 설정) GreaterThen, LessThen, Between
  List<EmployeesEntity> findByHireDateGreaterThan(LocalDate hireDate);
  List<EmployeesEntity> findByHireDateLessThan(LocalDate hireDate);
  List<EmployeesEntity> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

//  주제 키워드 order by
  List<EmployeesEntity> findByFirstNameOrderByEmpNoDesc(String firstName);

  
//  @Query : 복잡한 쿼리문은 쿼리 메소드로 생성하기 힘들기 때문에 SQL 쿼리문 을 사용할 수 있도록 해주는 어노테이션
//  JPQL 문법을 사용하여 쿼리문 생성
//  검색 조건에 '?순번' 형태로 데이터 사용 (순번은 1부터 시작)
//  사용법 :
//  @Query("select entity객체명 from entity클래스명 as entity객체명 where 검색조건1, 검색조건2, ... ")
//  반환타입 메소드명(매개변수1, 매개변수2, ...)

//  기본 메소드findAll() 과 같은 기능
  @Query("SELECT emp FROM EmployeesEntity AS emp")
  List<EmployeesEntity> selectAll();

//  기본 메소드 findById() 나 쿼리메소드 findByEmpNo() 와 같은 기능
//  ?순번은 1부터 시작, 매개변수의 순서에 따라서 적용됨
  @Query("SELECT emp FROM EmployeesEntity as emp WHERE emp.empNo = ?1")
  EmployeesEntity selectEmployeesEmpNo(int empNo);

//  메소드의 매개변수를 쿼리문에 직접 적용할 수 있음
//  쿼리문에 ':매개변수명' 형태로 사용, 매개변수의 순서에 상관없이 매개변수 이름에 따라서 사용
  @Query("SELECT emp FROM EmployeesEntity as emp WHERE emp.firstName = :first AND emp.lastName = :last")
  List<EmployeesEntity> selectAll2(@Param("first") String firstname, @Param("last") String lastname);
  
//  @Query 는 join 과 같이 복잡한 쿼리문을 생성할 때 사용
//  @Query("SELECT emp, salary FROM EmployeesEntity as emp JOIN SalaryEntity as salary ON emp.empNo = salary.empNo WHERE emp.firstName = ?1 AND emp.gender = ?2")

}





