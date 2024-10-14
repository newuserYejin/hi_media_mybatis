package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.SearchCriteria;
import com.ohgiraffers.common.menuDTO;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {
    List<menuDTO> selectMenuByPrice(Map<String, Integer> map);

    List<menuDTO> searchMenu(SearchCriteria searchCriteria);

    List<menuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<menuDTO> searchMenuByRandomCode(Map<String, List<Integer>> criteria);

    List<menuDTO> searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria);

    List<menuDTO> searchMenuNameOrCategory(Map<String, Object> criteria);
}
