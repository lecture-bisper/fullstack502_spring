package bitc.full502.xmljsonparser.service;

import bitc.full502.xmljsonparser.dto.pharmacy.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserServiceImpl implements ParserService {

  @Override
  public List<ItemDTO> getPharmacyItemListFile(String filePath) throws Exception {

//    jaxb : 자바에서 xml 데이터 파싱을 도와주는 라이브러리
//    jaxb 가 자바 9버전부터 기본 라이브러리에 제외됨

//    Marshal(마샬) : 자바 클래스 타입의 객체를 xml 데이터로 변환
//    UnMarshal(언마샬) : xml 데이터를 자바 클래스 타입의 객체로 변환
    
//    JAXB 라이브러리 사용 선언
//    미리 생성해둔 ResponseDTO 클래스 타입으로 xml 데이터를 파싱하도록 설정
    JAXBContext jc = JAXBContext.newInstance(ResponseDTO.class);
//    JAXB 라이브러리를 사용하여 xml 데이터를 자바 클래스 타입의 객체로 변환하는 언마샬 객체 생성
    Unmarshaller um = jc.createUnmarshaller();

//    xml 데이터를 기반으로 ResponseDTO 클래스 타입의 객체를 생성하므로 xml 데이터를 파싱하여 가져온 데이터 ResponseDTO 클래스 타입의 객체에 강제 타입 변환하여 저장함
//    unmarshal() : 언마샬을 수행하는 메소드, 매개변수로 파일이나 URL 을 받음
    ResponseDTO response = (ResponseDTO) um.unmarshal(new File(filePath));
//    단계별로 데이터 출력
//    HeaderDTO header = response.getHeader();
//    BodyDTO body = response.getBody();
//    ItemsDTO items = body.getItems();
//    List<ItemDTO> itemList = items.getItemList();
//    한번에 데이터 출력
    List<ItemDTO> itemList = response.getBody().getItems().getItemList();

//    가져온 약국 정보 목록을 반환
    return itemList;
  }

  @Override
  public List<ItemDTO> getPharmacyItemListUrl(String serviceUrl) throws Exception {

//    출력할 데이터를 저장할 List 생성
    List<ItemDTO> itemList = new ArrayList<>();

//    서비스 URL 을 저장할 객체
    URL url = null;
//    HttpURLConnection : 자바에서 웹 브라우저 없이 http 서비스에 접속하기 위한 클래스
    HttpURLConnection urlConn = null;

    try {
//      가져온 url 정보로 URL 객체 생성
      url = new URL(serviceUrl);
//      지정한 웹 서비스로 접속
      urlConn = (HttpURLConnection) url.openConnection();
//      데이터 통신 방식 설정
      urlConn.setRequestMethod("GET");

//      xml 데이터 파싱을 위한 JAXB 라이브러리 사용
      JAXBContext jc = JAXBContext.newInstance(ResponseDTO.class);
//      xml 데이터를 자바 클래스 객체로 파싱하기 위한 언 마샬 객체 생성
      Unmarshaller um = jc.createUnmarshaller();

//      xml 데이터를 자바 클래스 타입으로 변환하는 unmarshal() 메소드 호출
//      매개변수로 URL 클래스 타입의 객체를 설정
//      unmarshal() 을 통해서 출력되는 데이터는 Object 타입이므로 ResponseDTO 타입으로 강제 타입변환하여 사용
      ResponseDTO response = (ResponseDTO) um.unmarshal(url);
//      필요한 데이터만 출력
      itemList = response.getBody().getItems().getItemList();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return itemList;
  }
}














