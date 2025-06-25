package btic.full502.board2.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoardDTO {

  private int boardIdx;
  private String title;
  private String contents;
  private String createId;
  private String createDate;
  private String updateId;
  private String updateDate;
  private int hitCnt;

//  첨부파일 목록을 저장하는 list
  private List<FileDTO> fileList;

}














