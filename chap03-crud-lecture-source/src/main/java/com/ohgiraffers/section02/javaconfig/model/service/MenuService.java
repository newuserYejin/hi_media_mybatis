package com.ohgiraffers.section02.javaconfig.model.service;

import com.ohgiraffers.section02.javaconfig.model.dao.MenuMapper;
import com.ohgiraffers.section02.javaconfig.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section02.javaconfig.common.template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuList;
    }

//    public MenuDTO selectMenuByMenuCode(int code) {
//
//
//    }
//
//    public boolean insertNewMenu(MenuDTO newMenu) {
//
//
//    }
//
//    public boolean updateMenu(MenuDTO updateMenu) {
//
//
//    }
//
//    public boolean deleteMenu(int code) {
//
//
//    }
}
