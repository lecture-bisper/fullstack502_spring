package bitc.full502.jpastudy2.service;

import bitc.full502.jpastudy2.domain.entity.EmployeesEntity;
import bitc.full502.jpastudy2.domain.entity.EnumGender;
import bitc.full502.jpastudy2.domain.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesService {

  private final EmployeesRepository employeesRepository;

  @Override
  public void finds() throws Exception {
    System.out.println("\n ----- findBy 쿼리메소드 사용 -----\n");
    Optional<EmployeesEntity> emp1 = employeesRepository.findById(10001);
    Optional<EmployeesEntity> emp2 = employeesRepository.findEmployeesEntityByEmpNo(10002);
    List<EmployeesEntity> empList1 = employeesRepository.findAllByFirstName("mario");
    List<EmployeesEntity> empList2 = employeesRepository.findAllByGender(EnumGender.M);
    List<EmployeesEntity> empList3 = employeesRepository.findAllByHireDate(LocalDate.now());

    System.out.println("\n ----- findBy 쿼리메소드 사용 완료 -----\n");
  }

  @Override
  public void exists() throws Exception {
    System.out.println("\n ----- existsBy 쿼리메소드 사용 -----\n");

    boolean result = employeesRepository.existsByEmpNo(10101);
    result = employeesRepository.existsByEmpNo(100);

    System.out.println("\n ----- existsBy 쿼리메소드 사용 완료 -----\n");
  }

  @Override
  public void count() throws Exception {
    System.out.println("\n ----- countBy 쿼리메소드 사용 -----\n");

    int count = employeesRepository.countByLastName("Swab");

    System.out.println("\n ----- countBy 쿼리메소드 사용 완료 -----\n");
  }

  @Override
  public void delete() throws Exception {

  }

  @Override
  public void limit() throws Exception {

  }

  @Override
  public void equals() throws Exception {

  }

  @Override
  public void isNot() throws Exception {

  }

  @Override
  public void isNull() throws Exception {

  }

  @Override
  public void isNotNull() throws Exception {

  }

  @Override
  public void and() throws Exception {

  }

  @Override
  public void or() throws Exception {

  }

  @Override
  public void between() throws Exception {

  }

  @Override
  public void like() throws Exception {

  }

  @Override
  public void orderBy() throws Exception {

  }
}














