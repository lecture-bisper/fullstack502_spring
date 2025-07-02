package bitc.full502.jpastudy.service;

import bitc.full502.jpastudy.domain.entity.JpaBoardEntity;

import java.util.List;

public interface JpaBoardService {
  void insertBoard();

  void insertBoardList();

  JpaBoardEntity selectBoard(int boardIdx);

  List<JpaBoardEntity> selectBoardList();

  void updateBoard();

  void deleteBoard();
}
