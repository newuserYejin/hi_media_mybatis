package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.SearchCriteria;
import com.ohgiraffers.common.menuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, Integer> map = new HashMap<>();

        map.put("price",price);

        List<menuDTO> menuList =  mapper.selectMenuByPrice(map);

        if (menuList != null && menuList.size() > 0){
            for(menuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();

    }

    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<menuDTO> menuList = mapper.searchMenu(searchCriteria);

        if (menuList != null && menuList.size() > 0){
            for(menuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();

    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<menuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);

        if (menuList != null && menuList.size() > 0){
            for(menuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();

    }
}
