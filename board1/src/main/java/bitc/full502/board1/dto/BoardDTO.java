package bitc.full502.board1.dto;

import lombok.Data;

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

//  public int getBoardIdx() {
//    return boardIdx;
//  }
//
//  public void setBoardIdx(int boardIdx) {
//    this.boardIdx = boardIdx;
//  }
//
//  public String getTitle() {
//    return title;
//  }
//
//  public void setTitle(String title) {
//    this.title = title;
//  }
//
//  public String getContents() {
//    return contents;
//  }
//
//  public void setContents(String contents) {
//    this.contents = contents;
//  }
//
//  public String getCreateId() {
//    return createId;
//  }
//
//  public void setCreateId(String createId) {
//    this.createId = createId;
//  }
//
//  public String getCreateDate() {
//    return createDate;
//  }
//
//  public void setCreateDate(String createDate) {
//    this.createDate = createDate;
//  }
//
//  public String getUpdateId() {
//    return updateId;
//  }
//
//  public void setUpdateId(String updateId) {
//    this.updateId = updateId;
//  }
//
//  public String getUpdateDate() {
//    return updateDate;
//  }
//
//  public void setUpdateDate(String updateDate) {
//    this.updateDate = updateDate;
//  }
//
//  public int getHitCnt() {
//    return hitCnt;
//  }
//
//  public void setHitCnt(int hitCnt) {
//    this.hitCnt = hitCnt;
//  }
}
