package com.ohgiraffers.section03.remix.model.service;

import com.ohgiraffers.section03.remix.model.dao.MenuMapper;
import com.ohgiraffers.section03.remix.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section03.remix.common.template.getSqlSession;


public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int code) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO selectMenu = menuMapper.selectMenuByMenuCode(code);

        sqlSession.close();

        return selectMenu;
    }

    public boolean insertNewMenu(MenuDTO newMenu) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.insertNewMenu(newMenu);

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

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.updateMenu(updateMenu);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        return result > 0 ? true : false;
    }

//
//    public boolean deleteMenu(int code) {
//
//
//    }
}
