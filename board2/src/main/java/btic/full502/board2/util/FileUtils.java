package btic.full502.board2.util;

import btic.full502.board2.dto.FileDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//  @Bean : 스프링 프레임워크 혹은 각종 서드 파티 회사에서 제공하는 라이브러리의 클래스를 사용 시 사용하는 어노테이션
//  @Component : 사용자가 직접 작성한 클래스를 스프링 프레임워크에서 관리하도록 맡기기 위해서 사용하는 어노테이션
//  @Bean, @Component 는 스프링 프레임워크에서 객체를 생성하고 사용하고 관리하는 라이브러리를 뜻하는 어노테이션

@Component
public class FileUtils {

  public List<FileDTO> parseFileInfo(int boardIdx, String createId, MultipartHttpServletRequest multipart) throws Exception {

//    ObjectUtils : 스프링 프레임워크에서 제공하는 유틸리티 클래스
//    지정한 객체가 비었는지 아닌지 확인
    if (ObjectUtils.isEmpty(multipart)) {
//      업로드된 데이터가 없을 경우 null 을 반환
      return null;
    }

//    업로드된 데이터가 있을 경우 데이터 가져오기

//    변환할 파일정보 데이터용 List 생성
    List<FileDTO> fileList = new ArrayList<>();

//    지정한 날짜를 기준으로 패턴 생성, 4자리 년도, 2자리 월, 2자리 일 형식으로 패턴을 생성
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    현재 위치를 기준으로 현재 시간을 가져옴
    ZonedDateTime current = ZonedDateTime.now();

//    업로드된 파일을 저장할 서버의 폴더 위치를 설정
//    기준이 되는 폴더와 위에서 생성한 패턴에 맞는 날짜 정보를 사용하여 전체 경로 문자열을 생성
    String path = "C:/fullstack502/uploads/" + current.format(formatter);

//    위에서 생성한 전체 경로를 기준으로 File 클래스 타입의 객체 생성
    File file = new File(path);

//    위에서 생성한 전체 경로에 해당하는 폴더가 존재하는지 여부 확인, 있으면 true 없으면 false
    if (file.exists() == false) {
//      File 객체를 사용하여 지정한 경로의 폴더를 생성
      file.mkdirs();
    }

//    MultipartHttpServletRequest 객체에서 업로드된 파일 정보 중 파일 이름 목록을 모두 가져옴
    Iterator<String> iterator = multipart.getFileNames();
    
    String newFileName; // 새파일명을 저장할 변수
    String originalFileExt; // 확장자명을 저장할 변수
    String contentType; // 파일 형식을 구분하기 위한 변수

//    가져온 파일 이름 목록을 while 문을 사용하여 출력
//    hasNext() : Iterator 타입의 객체에서 출력할 데이터가 있는지 확인하는 메소드
    while (iterator.hasNext()) {
//      next() : Iterator 타입의 객체에서 데이터를 출력
//      파일 이름을 하나 가져옴
      String name = iterator.next();
//      가져온 파일 이름으로 해당 파일의 전체 정보를 가져옴
      List<MultipartFile> multipartFileList = multipart.getFiles(name);

//      가져온 파일 목록에서 반복문을 사용하여 내용을 하나씩 출력
      for (MultipartFile uploadFile : multipartFileList) {

//        현재 파일의 파일 타입을 가져옴
        contentType = uploadFile.getContentType();
        
//        파일 타입이 있는지 여부 확인
        if (ObjectUtils.isEmpty(contentType)) {
          break;
        }
        else {
//          파일 타입이 있을 경우 확장자명을 생성
          if (contentType.contains("image/jpeg")) {
            originalFileExt = ".jpg";
          }
          else if (contentType.contains("image/png")) {
            originalFileExt = ".png";
          }
          else if (contentType.contains("image/gif")) {
            originalFileExt = ".gif";
          }
          else {
            break;
          }
        }

//        System.nanoTime() : 자바에서 제공하는 메소드로 현재 시간을 기준으로 nano 초로 표시함
//        현재 시간을 기준으로 확장자명과 합하여 새로운 파일명을 생성함
        newFileName = System.nanoTime() + originalFileExt;

//        FileDTO 클래스 타입의 객체 생성
        FileDTO fileDTO = new FileDTO();
//        가져온 파일 정보를 FileDTO 객체에 저장
        fileDTO.setBoardIdx(boardIdx); // 게시물 번호
        fileDTO.setFileSize(uploadFile.getSize()); // 파일 크기
        fileDTO.setOriginalFileName(uploadFile.getOriginalFilename()); // 원본 파일명
        // 위에서 생성한 전체 경로 + 현재시간을 기준으로 생성한 새 파일명을 합하여 전체 경로가 있는 파일명을 생성
        fileDTO.setStoredFileName(path + "/" + newFileName);
        fileDTO.setCreateId(createId); // 사용자 ID

//        반환할 파일 리스트에 FileDTO 객체를 저장
        fileList.add(fileDTO);

//        File 객체를 전체 경로 + 현재시간 기준 새파일명 으로 객체 생성
        file = new File(path + "/" + newFileName);
//        지정한 전체 경로로 업로드된 파일을 복사함 (서버의 실제 디스크), 해당 명령 이전까지는 스프링 프레임워크 서버의 메모리 상에만 존재함
        uploadFile.transferTo(file);
      }
    }

//    생성된 List<FileDTO> 객체를 반환
    return fileList;
  }
}














