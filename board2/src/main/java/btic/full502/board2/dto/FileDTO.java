package btic.full502.board2.dto;

import lombok.Data;

@Data
public class FileDTO {

  private int fileIdx; // 첨부 파일 번호
  private int boardIdx; // 첨부 파일이 포함된 게시글의 번호
  private String originalFileName; // 원본 파일명
  private String storedFileName; // 서버에 저장된 파일명
  private long fileSize; // 파일 크기
  private String createId;
  private String createDate;
  private String updateId;
  private String updateDate;
}














