package bitc.full502.board5.data.repository;

import bitc.full502.board5.data.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {


}
