package bitc.full502.jpastudy.domain.repository;

import bitc.full502.jpastudy.domain.entity.JpaProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<JpaProductEntity, Integer> {
}
