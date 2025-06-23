package btic.full502.jquerytest.service;

import btic.full502.jquerytest.dto.AreaDTO;

import java.util.List;

public interface AreaService {
  List<AreaDTO> getAreaList(String areaName);

  List<AreaDTO> getDistrictList(String areaName);

  List<AreaDTO> getTownList(String areaName);
}
