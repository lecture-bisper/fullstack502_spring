package bitc.full502.xmljsonparser.service;

import bitc.full502.xmljsonparser.dto.pharmacy.ItemDTO;

import java.util.List;

public interface ParserService {
  List<ItemDTO> getPharmacyItemListFile(String filePath) throws Exception;

  List<ItemDTO> getPharmacyItemListUrl(String serviceUrl) throws Exception;
}
