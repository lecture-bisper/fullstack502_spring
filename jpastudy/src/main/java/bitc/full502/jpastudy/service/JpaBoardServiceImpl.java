package bitc.full502.jpastudy.service;

import bitc.full502.jpastudy.domain.entity.JpaBoardEntity;
import bitc.full502.jpastudy.domain.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JpaBoardServiceImpl implements JpaBoardService {

  private final JpaBoardRepository jpaBoardRepository;


//  1개 저장
  @Override
  public void insertBoard() {
    JpaBoardEntity board = new JpaBoardEntity();
    board.setTitle("테스트 제목 1");
    board.setContents("테스트 내용 1");
    board.setCreateId("test1");

//    JpaRepository 기본 메소드 save() 를 사용하여 insert 실행
    jpaBoardRepository.save(board);
  }

  @Override
  public void insertBoardList() {
    List<JpaBoardEntity> boardList = new ArrayList<>();
    JpaBoardEntity board1 = new JpaBoardEntity();
    board1.setTitle("목록 테스트 제목 1");
    board1.setContents("목록 테스트 내용 1");
    board1.setCreateId("test1");

    JpaBoardEntity board2 = new JpaBoardEntity();
    board2.setTitle("목록 테스트 제목 2");
    board2.setContents("목록 테스트 내용 2");
    board2.setCreateId("test2");

    JpaBoardEntity board3 = new JpaBoardEntity();
    board3.setTitle("목록 테스트 제목 3");
    board3.setContents("목록 테스트 내용 3");
    board3.setCreateId("test3");

    boardList.add(board1);
    boardList.add(board2);
    boardList.add(board3);

//    JpaRepository 기본 메소드 saveAll() 을 사용하여 여러개의 데이터를 한번에 insert
    jpaBoardRepository.saveAll(boardList);
  }

//  게시물 정보 가져오기
  @Override
  public JpaBoardEntity selectBoard(int boardIdx) {

//    JpaRepository 기본 메소드 findById() 를 사용하여 지정한 데이터를 가져옴

//    Optional<T> : Jpa를 통해서 데이터를 조회하여 가져올 경우 지정한 기본키를 가지고 있는 데이터가 없는 경우 발생함, 조회된 데이터가 없을 경우 null 이 전달되므로 스프링 프레임워크 내에서 NullPointerException 이 발생할 가능성이 있음
//      조회된 데이터가 없어서 발생하는 오류를 제거하기 위해서 스프링 프레임워크에서 제공하는 데이터타입
//    JpaBoardEntity optBoard = jpaBoardRepository.findById(boardIdx);
    Optional<JpaBoardEntity> optBoard = jpaBoardRepository.findById(boardIdx);
    
//    orElse() : 지정한 명령어 사용 후 오류 발생 시 추가 처리할 수 있는 메소드
//    JpaBoardEntity board = jpaBoardRepository.findById(boardIdx).orElse(null);

//    isPresent() : Optional 에서 제공하는 메소드로 지정한 Entity 에 데이터가 있는지 확인, true/false
//    get() : Optional 에서 제공하는 메소드로 isPresent() 의 결과가 true 일 경우 Optional 타입에서 데이터를 출력함
    if (optBoard.isPresent()) {
      JpaBoardEntity board = optBoard.get();
      return board;
    }
    else {
      return null;
    }
  }

  @Override
  public List<JpaBoardEntity> selectBoardList() {
//    JpaRepository 기본 메소드 findAll() 을 사용하여 모든 데이터를 가져옴
//    List 로 가져오기 때문에 null 은 발생하지 않음
    return jpaBoardRepository.findAll();
  }

  @Override
  public void updateBoard() {
//    수정 : findById() 로 지정한 게시물 가져오기 -> setter 사용하여 데이터 수정 -> save()
//    JpaRepository 기본 메소드 findById() 로 지정한 게시물 정보 가져옴
    Optional<JpaBoardEntity> optBoard = jpaBoardRepository.findById(5);

    if (optBoard.isPresent()) {
      JpaBoardEntity board = optBoard.get();
//      가져온 데이터를 사용자가 원하는 데이터로 수정
      board.setTitle("수정된 테스트 제목 1");
      board.setContents("수정된 테스트 내용 1");

//    JpaRepository 기본 메소드 save() 로 수정한 데이터 정보 저장
      jpaBoardRepository.save(board);
    }
    
    System.out.println("save() 로 데이터 수정");
  }

  @Override
  public void deleteBoard() {
//    삭제 : findById()로 지정한 데이터 가져오기 -> deleteById() 로 삭제

    Optional<JpaBoardEntity> optBoard = jpaBoardRepository.findById(5);

    if (optBoard.isPresent()) {
      JpaBoardEntity board = optBoard.get();
//      jpaBoardRepository.delete(board); // 가져온 데이터를 가지고 삭제
    }

    jpaBoardRepository.deleteById(4); // 지정한 ID 값을 기준으로 삭제
//      jpaBoardRepository.deleteAll(); // 테이블의 내용 모두 삭제

    System.out.println("delete() 로 데이터 삭제");
  }
}














