package com.ohgiraffers.section01.xmlconfig.view;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {

        System.out.println("\n요청하신 전체 메뉴 조회 결과 입니다.");

        for (MenuDTO menu : menuList){
            System.out.println(menu);
        }

        System.out.println("=======================================\n");
    }
}
