package btic.full502.board2.service;

import btic.full502.board2.dto.UserDTO;
import btic.full502.board2.mapper.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private AuthMapper authMapper;

//  사용자 존재 여부 확인
//  1. 매개변수로 id/pw 를 받아옴
//  2. mapper 를 이용하여 사용자가 전달한 id/pw 를 사용하는 사용자 정보가 데이터베이스에 있는지 확인
//  3. 확인한 결과를 반환
  @Override
  public int isUserInfo(String userId, String userPw) throws Exception {
    return authMapper.isUserInfo(userId, userPw);
  }
  
//  사용자 정보 가져오기
//  1. 매개변수로 id 를 받아옴
//  2. mapper 를 이용하여 전달받은 id 를 사용하는 사용자 정보를 데이터베이스에서 가져옴
//  3. 가져온 사용자 정보를 반환
  @Override
  public UserDTO selectUserInfo(String userId) throws Exception {
    return authMapper.selectUserInfo(userId);
  }
}














