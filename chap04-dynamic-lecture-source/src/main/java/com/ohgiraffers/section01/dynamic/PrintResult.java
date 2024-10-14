package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.menuDTO;

import java.util.List;

public class PrintResult {

    public static void printList(List<menuDTO> menuList){
        for (menuDTO menu : menuList){
            System.out.println(menu);
        }
    }

}
