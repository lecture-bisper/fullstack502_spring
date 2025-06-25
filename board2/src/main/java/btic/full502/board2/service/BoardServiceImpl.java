package btic.full502.board2.service;

import btic.full502.board2.dto.BoardDTO;
import btic.full502.board2.dto.FileDTO;
import btic.full502.board2.mapper.BoardMapper;
import btic.full502.board2.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardMapper boardMapper;

  @Autowired
  private FileUtils fileUtils;

  @Override
  public List<BoardDTO> selectBoardList() throws Exception {
    return boardMapper.selectBoardList();
  }

//  게시글 상세 보기
//  1. mapper 를 이용하여 매개변수로 받아온 게시글 번호에 맞는 게시글 상세 정보를 가져옴
//  2. 가져온 게시글 상세 정보를 반환
  @Override
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
//    지정한 번호의 게시물 상세정보 가져오기 (첨부파일 목록은 없음)
    BoardDTO board = boardMapper.selectBoardDetail(boardIdx);
//    지정한 게시물의 첨부파일 목록을 가져옴
    List<FileDTO> fileList = boardMapper.selectBoardFileList(boardIdx);
//    가져온 첨부파일 목록을 기존 게시물 상세 정보에 저장
    board.setFileList(fileList);
//    첨부파일 목록까지 가지고 있는 BoardDTO 객체를 반환
    return board;
  }

//  게시글 등록하기
//  1. 매개변수로 데이터 받아오기
//  2. mapper 를 이용하여 매개변수로 받아온 데이터를 데이터베이스에 등록

//  두번째 매개변수로 업로드된 파일 정보를 가지고 있는 MultipartHttpServletRequest 를 받아옴
  public void boardWrite(BoardDTO board, MultipartHttpServletRequest multipart) throws Exception {
//    게시물 정보를 데이터베이스에 등록
//    매개변수로 받아온 BoardDTO 객체 board 에는 현재 boardIdx 가 없음 (기본값 0)
//    데이터베이스 등록 후 데이터베이스 자체에서 board_idx 값을 증가
    boardMapper.boardWrite(board);

//    업로드된 파일 목록을 가져오기
    List<FileDTO> fileList = fileUtils.parseFileInfo(board.getBoardIdx(), board.getCreateId(), multipart);

//    CollectionUtils : 스프링프레임워크에서 제공하는 유틸리티 클래스
//    파일 리스트가 비었는지 확인
    if (CollectionUtils.isEmpty(fileList) == false) {
//    업로드된 파일 목록을 데이터베이스 저장
      boardMapper.insertBoardFileList(fileList);
    }

//    업로드된 파일이 있는지 확인
//    if (ObjectUtils.isEmpty(multipart) == false) {
//      Iterator<String> iterator = multipart.getFileNames();
//      String name;
//
//      while (iterator.hasNext()) {
//        name = iterator.next();
//
//        List<MultipartFile> fileInfoList = multipart.getFiles(name);
//
//        for (MultipartFile fileInfo : fileInfoList) {
//          System.out.println("\n ***** 파일 정보 ***** \b");
//          System.out.println("file name : " + fileInfo.getOriginalFilename());
//          System.out.println("file size : " + fileInfo.getSize());
//          System.out.println("file content type : " + fileInfo.getContentType());
//          System.out.println("\n---------------\n");
//        }
//      }
//    }

  }

//  다운로드할 파일 정보 가져오기
//  1. 매개변수로 파일번호와 게시물번호를 가져옴
//  2. mapper 를 이용하여 지정한 게시물 번호와 파일 번호를 사용하는 파일 정보를 데이터베이스에 가져옴
  @Override
  public FileDTO selectBoardFileInfo(int fileIdx, int boardIdx) {
    return boardMapper.selectBoardFileInfo(fileIdx, boardIdx);
  }
}














