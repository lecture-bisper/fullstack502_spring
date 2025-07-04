package bitc.full502.quiz.service;

import bitc.full502.quiz.domain.entity.PhoneBookEntity;

import java.util.List;

public interface PhoneBookService {
  List<PhoneBookEntity> selectPhoneBookList();

  void insertPhoneBook(PhoneBookEntity phoneBook);

  PhoneBookEntity selectPhoneBookDetail(int seq);

  void updatePhoneBook(PhoneBookEntity phoneBook);

  void deletePhoneBook(int seq);

  List<PhoneBookEntity> selectPhoneBookSearchList(String searchText, String opt);
}
