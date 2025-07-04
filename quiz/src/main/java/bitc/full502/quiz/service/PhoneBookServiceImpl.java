package bitc.full502.quiz.service;

import bitc.full502.quiz.domain.entity.PhoneBookEntity;
import bitc.full502.quiz.domain.repository.PhoneBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PhoneBookServiceImpl implements PhoneBookService {

//  PhoneBookEntity 를 제어하기 위한 PhoneBookRepository 객체, 스프링 프레임워크가 관리
  private final PhoneBookRepository phoneBookRepository;

  @Override
  public List<PhoneBookEntity> selectPhoneBookList() {

//    JpaRepository 에서 제공하는 기본 메소드 findAll() 사용
    return phoneBookRepository.findAll();
  }

  @Override
  public void insertPhoneBook(PhoneBookEntity phoneBook) {
//    JpaRepository 에서 제공하는 기본 메소드 save() 사용
    phoneBookRepository.save(phoneBook);
  }

  @Override
  public PhoneBookEntity selectPhoneBookDetail(int seq) {
//    JpaRepository 에서 제공하는 기본 메소드 findById() 사용
    Optional<PhoneBookEntity> opt = phoneBookRepository.findById(seq);

    if (opt.isPresent()) {
      PhoneBookEntity phoneBook = opt.get();
      return phoneBook;
    }
    else {
      return null;
    }
  }

  @Override
  public void updatePhoneBook(PhoneBookEntity phoneBook) {
//    JpaRepository 에서 제공하는 기본 메소드 save() 사용
    phoneBookRepository.save(phoneBook);
  }

  @Override
  public void deletePhoneBook(int seq) {
//    JpaRepository 에서 제공하는 기본 메소드 deleteById() 사용
    phoneBookRepository.deleteById(seq);
  }

  @Override
  public List<PhoneBookEntity> selectPhoneBookSearchList(String searchText, String opt) {

//    JpaRepository 에서 제공하는 쿼리 메소드를 이용하여 데이터 가져오기
//    opt 에 따라서 검색하는 쿼리 메소드 선택

    List<PhoneBookEntity> phoneBookList = new ArrayList<>();
    PhoneBookEntity phoneBook;

    switch (opt) {
      case "seq":
//        사용자가 만든 쿼리 메소드, PhoneBookEntiry의 seq 필드로 검색
        phoneBook = phoneBookRepository.findBySeq(Integer.parseInt(searchText));
        phoneBookList.add(phoneBook);
        break;

      case "tel":
//        사용자가 만든 쿼리 메소드, PhoneBookEntiry의 tel 필드로 검색
        phoneBook = phoneBookRepository.findByTel(searchText);
        phoneBookList.add(phoneBook);
        break;

      case "name":
//        사용자가 만든 쿼리 메소드, PhoneBookEntiry의 name 필드로 검색
        phoneBookList = phoneBookRepository.findAllByName(searchText);
        break;

      case "nameText":
//        사용자가 만든 쿼리 메소드, PhoneBookEntiry의 name 필드로 일부 텍스트가 포함된 것으로 검색 
//        phoneBookList = phoneBookRepository.findAllByNameContains(searchText);
//        사용자가 만든 쿼리 메소드, PhoneBookEntiry의 name 필드로 일부 텍스트가 포함된 것으로 검색, 내림차순 정렬
        phoneBookList = phoneBookRepository.findAllByNameContainsOrderBySeqDesc(searchText);
        break;

      case "query1":
        phoneBook = phoneBookRepository.selectPhoneBookDetailTel(searchText);
        phoneBookList.add(phoneBook);
        break;

      case "query2":
        phoneBookList = phoneBookRepository.selectPhoneBookDetailListName(searchText);
        break;

      case "query3":
        phoneBookList = phoneBookRepository.selectPhoneBookDetailListNameAndEmail1(searchText, "test5@bitc.ac.kr");
        break;

      case "query4":
        phoneBookList = phoneBookRepository.selectPhoneBookDetailListNameAndEmail2("test5@bitc.ac.kr", searchText);
        break;
    }

    return phoneBookList;
  }
}














