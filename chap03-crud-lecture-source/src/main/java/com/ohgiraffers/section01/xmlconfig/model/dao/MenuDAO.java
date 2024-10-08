package com.ohgiraffers.section01.xmlconfig.model.dao;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    /*
     * DAO(Data Access Object)
     * - 쿼리문 전달하고 결과 받아오는 역할
     * */

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession){

        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int code) {
        return sqlSession.selectOne("MenuMapper.selectMenuByMenuCode",code);
    }

    public int insertNewMenu(SqlSession sqlSession, MenuDTO newMenu) {
        return sqlSession.insert("MenuMapper.insertNewMenu", newMenu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO updateMenu) {
        return sqlSession.update("MenuMapper.updateMenu", updateMenu);
    }

    public int deleteMenu(SqlSession sqlSession, int code) {
        return sqlSession.delete("MenuMapper.deleteMenu", code);
    }
}
