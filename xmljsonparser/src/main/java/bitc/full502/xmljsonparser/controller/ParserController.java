package bitc.full502.xmljsonparser.controller;

import bitc.full502.xmljsonparser.dto.pharmacy.ItemDTO;
import bitc.full502.xmljsonparser.service.ParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/parser")
public class ParserController {

  private final ParserService parserService;

//  application.properties 에 있는 데이터 가져오기
  @Value("${pharmacy.service.fullData.url}")
  private String fullDataServiceUrl;

  @Value("${pharmacy.service.userKey}")
  private String pharmacyUserKey;

  @GetMapping({"", "/"})
  public String index() {
    return "index";
  }

  @GetMapping("/pharmacy/fullDataFile")
  public ModelAndView pharmacyFullDataFile() throws Exception {
    ModelAndView mv = new ModelAndView("pharmacy/fullDataFile");

    List<ItemDTO> itemList = parserService.getPharmacyItemListFile("C:/fullstack502/pharmacy.xml");
    mv.addObject("itemList", itemList);

    return mv;
  }

//  약국 정보 확인을 위한 view 페이지
  @GetMapping("/pharmacy/fullDataUrl")
  public String pharmacyFullDataUrl() {
    return "pharmacy/fullDataUrl";
  }

//  ajax 통신을 위해서 데이터만 전달
  @ResponseBody
  @PostMapping("/pharmacy/fullDataUrl")
  public Object pharmacyFullDataUrl(
//      파라미터 미 입력 시 기본값 사용
      @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
      @RequestParam(value = "numOfRows", required = false, defaultValue = "10") int numOfRows
  ) throws Exception {

    String serviceKey = "?serviceKey=";
    String opt1 = "&pageNo=";
    String opt2 = "&numOfRows=";

    String serviceUrl = fullDataServiceUrl + serviceKey + pharmacyUserKey + opt1 + pageNo + opt2 + numOfRows;

    List<ItemDTO> itemList = parserService.getPharmacyItemListUrl(serviceUrl);

    return itemList;
  }
}














