package btic.full502.jquerytest.service;

import btic.full502.jquerytest.dto.AreaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
  @Override
  public List<AreaDTO> getAreaList(String areaName) {
//    반환할 데이터 객체 생성
    List<AreaDTO> areaList = new ArrayList<>();

//    매개변수로 받은 areaName 과 동일한 도시를 찾아서 데이터 연산
    if (areaName.equals("서울")) {
//      AreaDTO 타입의 객체 생성
      AreaDTO se1 = new AreaDTO();
      AreaDTO se2 = new AreaDTO();
      AreaDTO se3 = new AreaDTO();
      AreaDTO se4 = new AreaDTO();

//      각 객체에 구 정보 설정
      se1.setAreaName("강북구");
      se2.setAreaName("강남구");
      se3.setAreaName("강서구");
      se4.setAreaName("강동구");

//      반환할 데이터 리스트인 areaList 에 구 정보가 포함된 AreaDTO 타입의 객체를 저장
      areaList.add(se1);
      areaList.add(se2);
      areaList.add(se3);
      areaList.add(se4);
    }
    else if (areaName.equals("대전")) {
      AreaDTO dj1 = new AreaDTO();
      AreaDTO dj2 = new AreaDTO();
      AreaDTO dj3 = new AreaDTO();
      AreaDTO dj4 = new AreaDTO();

      dj1.setAreaName("동구");
      dj2.setAreaName("중구");
      dj3.setAreaName("서구");
      dj4.setAreaName("유성구");

      areaList.add(dj1);
      areaList.add(dj2);
      areaList.add(dj3);
      areaList.add(dj4);
    }
    else if (areaName.equals("대구")) {
      AreaDTO dg1 = new AreaDTO();
      AreaDTO dg2 = new AreaDTO();
      AreaDTO dg3 = new AreaDTO();
      AreaDTO dg4 = new AreaDTO();

      dg1.setAreaName("북구");
      dg2.setAreaName("남구");
      dg3.setAreaName("동구");
      dg4.setAreaName("서구");

      areaList.add(dg1);
      areaList.add(dg2);
      areaList.add(dg3);
      areaList.add(dg4);
    }
    else if (areaName.equals("부산")) {
      AreaDTO bs1 = new AreaDTO();
      AreaDTO bs2 = new AreaDTO();
      AreaDTO bs3 = new AreaDTO();
      AreaDTO bs4 = new AreaDTO();

      bs1.setAreaName("부산진구");
      bs2.setAreaName("동래구");
      bs3.setAreaName("해운대구");
      bs4.setAreaName("수영구");

      areaList.add(bs1);
      areaList.add(bs2);
      areaList.add(bs3);
      areaList.add(bs4);
    }

//    areaList 에 저장된 데이터를 반환
    return areaList;
  }

  @Override
  public List<AreaDTO> getDistrictList(String areaName) {
    List<AreaDTO> areaList = new ArrayList<>();

    if (areaName.equals("서울")) {
      AreaDTO se1 = new AreaDTO();
      AreaDTO se2 = new AreaDTO();
      AreaDTO se3 = new AreaDTO();
      AreaDTO se4 = new AreaDTO();

      se1.setAreaName("강북구");
      se2.setAreaName("강남구");
      se3.setAreaName("강서구");
      se4.setAreaName("강동구");

      areaList.add(se1);
      areaList.add(se2);
      areaList.add(se3);
      areaList.add(se4);
    }
    else if (areaName.equals("대전")) {
      AreaDTO dj1 = new AreaDTO();
      AreaDTO dj2 = new AreaDTO();
      AreaDTO dj3 = new AreaDTO();
      AreaDTO dj4 = new AreaDTO();

      dj1.setAreaName("동구");
      dj2.setAreaName("중구");
      dj3.setAreaName("서구");
      dj4.setAreaName("유성구");

      areaList.add(dj1);
      areaList.add(dj2);
      areaList.add(dj3);
      areaList.add(dj4);
    }
    else if (areaName.equals("대구")) {
      AreaDTO dg1 = new AreaDTO();
      AreaDTO dg2 = new AreaDTO();
      AreaDTO dg3 = new AreaDTO();
      AreaDTO dg4 = new AreaDTO();

      dg1.setAreaName("북구");
      dg2.setAreaName("남구");
      dg3.setAreaName("동구");
      dg4.setAreaName("서구");

      areaList.add(dg1);
      areaList.add(dg2);
      areaList.add(dg3);
      areaList.add(dg4);
    }
    else if (areaName.equals("부산")) {
      AreaDTO bs1 = new AreaDTO();
      AreaDTO bs2 = new AreaDTO();
      AreaDTO bs3 = new AreaDTO();
      AreaDTO bs4 = new AreaDTO();

      bs1.setAreaName("부산진구");
      bs2.setAreaName("동래구");
      bs3.setAreaName("해운대구");
      bs4.setAreaName("수영구");

      areaList.add(bs1);
      areaList.add(bs2);
      areaList.add(bs3);
      areaList.add(bs4);
    }

    return areaList;
  }

  @Override
  public List<AreaDTO> getTownList(String areaName) {
    List<AreaDTO> townList = new ArrayList<>();

    switch (areaName) {
      case "강남구":
        AreaDTO gn1 = new AreaDTO();
        AreaDTO gn2 = new AreaDTO();
        gn1.setAreaName("강남1동");
        gn2.setAreaName("강남2동");
        townList.add(gn1);
        townList.add(gn2);
        break;

      case "유성구":
        AreaDTO ys1 = new AreaDTO();
        AreaDTO ys2 = new AreaDTO();
        ys1.setAreaName("유성1동");
        ys2.setAreaName("유성2동");
        townList.add(ys1);
        townList.add(ys2);
        break;

      case "남구":
        AreaDTO n1 = new AreaDTO();
        AreaDTO n2 = new AreaDTO();
        n1.setAreaName("남1동");
        n2.setAreaName("남2동");
        townList.add(n1);
        townList.add(n2);
        break;

      case "부산진구":
        AreaDTO j1 = new AreaDTO();
        AreaDTO j2 = new AreaDTO();
        j1.setAreaName("전포1동");
        j2.setAreaName("전포2동");
        townList.add(j1);
        townList.add(j2);
        break;
    }

    return townList;
  }
}














