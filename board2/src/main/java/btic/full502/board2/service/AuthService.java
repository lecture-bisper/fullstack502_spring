package btic.full502.board2.service;

import btic.full502.board2.dto.UserDTO;

public interface AuthService {

  int isUserInfo(String userId, String userPw) throws Exception;

  UserDTO selectUserInfo(String userId) throws Exception;
}
