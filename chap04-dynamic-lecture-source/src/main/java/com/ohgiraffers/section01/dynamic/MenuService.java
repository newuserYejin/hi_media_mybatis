package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.SearchCriteria;
import com.ohgiraffers.common.menuDTO;
import org.apache.ibatis.session.SqlSession;

import javax.script.ScriptEngine;
import java.beans.Introspector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private DynamicSqlMapper mapper;

    private PrintResult print;

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

//            System.out.println("===============외부로 넘겨서 출력하기================");
//            print.printList(menuList);
            
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

            print.printList(menuList);
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

    public void searchMenuByRandomCode(List<Integer> randomCodeList) {
        SqlSession sqlSession =getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> criteria = new HashMap<>();
        criteria.put("randomCodeList",randomCodeList);

        List<menuDTO> menuList = mapper.searchMenuByRandomCode(criteria);

        if (menuList != null && menuList.size() > 0){
            for(menuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuCodeOrSearchAll(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<menuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if (menuList != null && menuList.size() > 0){
            for(menuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuNameOrcategory(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<menuDTO> menuList = mapper.searchMenuNameOrCategory(criteria);

        if (menuList != null && menuList.size() > 0){
            for(menuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.modifyMenu(criteria);

        if (result > 0){
            System.out.println("변경에 성공했습니다.");
            sqlSession.commit();
        } else {
            System.out.println("메뉴 정보 변경에 실패했습니다.");
            sqlSession.rollback();
        }


    }
}
