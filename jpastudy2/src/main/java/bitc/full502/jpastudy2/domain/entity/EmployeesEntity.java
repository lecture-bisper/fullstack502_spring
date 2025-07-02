package bitc.full502.jpastudy2.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesEntity {

  @Id
  private int empNo;

  @Column(nullable = false)
  private LocalDate birthDate;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

//  @Column(nullable = false, length = 1)
//  private String gender;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 1)
  private EnumGender gender;

  @Column(nullable = false)
  private LocalDate hireDate;
}














