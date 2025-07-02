package bitc.full502.jpastudy.domain.repository;

import bitc.full502.jpastudy.domain.entity.JpaBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoardEntity, Integer> {
//  기본 메소드
//  count(), findById() findAll(), save(), saveAll(), deleteById(), deleteAll();
}
