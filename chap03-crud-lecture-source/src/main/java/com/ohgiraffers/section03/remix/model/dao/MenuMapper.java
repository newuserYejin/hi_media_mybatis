package com.ohgiraffers.section03.remix.model.dao;

import com.ohgiraffers.section03.remix.model.dto.MenuDTO;

import java.util.List;

public interface MenuMapper {

    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByMenuCode(int code);

    int insertNewMenu(MenuDTO newMenu);

    int updateMenu(MenuDTO updateMenu);
}
