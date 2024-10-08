package com.ohgiraffers.section01.xmlconfig.model.service;

import com.ohgiraffers.section01.xmlconfig.model.dao.MenuDAO;
import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.common.Template.getSqlSession;

public class MenuService {

    /*comment
     * Service 계층의 역할
     * -비지니스 로직 (하나의 일련의 과정 ex) 쿠팡에서 메뉴 주문)
     * -SqlSession 생성 -> DB 접속 준비
     * -DAO(데이터베이스 접근 객체) 의 메소드 호출
     * -트렌젝션(commit, rollback) 제어
     * -SqlSession 닫기
     * */

    private final MenuDAO menuDAO;

    public MenuService(){
        this.menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu(){

        SqlSession sqlSession = getSqlSession();

        // DAO는 데이터베이스와 직접 소통하는 클래스. session이 있어야 DB와 소통 가능
        List<MenuDTO> menuList =  menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int code) {

        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.selectMenuByMenuCode(sqlSession,code);

        sqlSession.close();

        return menu;
    }

    public boolean insertNewMenu(MenuDTO newMenu) {

        SqlSession sqlSession =getSqlSession();
         int result =  menuDAO.insertNewMenu(sqlSession, newMenu);

         // dml(insert, delete, update)는 트랜젝셩 제어 필요. -> 저장할지 말지

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean updateMenu(MenuDTO updateMenu) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.updateMenu(sqlSession, updateMenu);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteMenu(int code) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.deleteMenu(sqlSession, code);

        if (result > 0){
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }

        return result > 0 ? true : false;
    }
}
