package btic.full502.board2.mapper;

import btic.full502.board2.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthMapper {

  int isUserInfo(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception;

  UserDTO selectUserInfo(@Param("userId") String userId) throws Exception;
}
