package com.ohgiraffers.section03.remix.view;


import com.ohgiraffers.section03.remix.model.dto.MenuDTO;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {

        System.out.println("\n요청하신 전체 메뉴 조회 결과 입니다.");

        for (MenuDTO menu : menuList){
            System.out.println(menu);
        }

        System.out.println("=======================================\n");
    }

    public void printErrorMessage(String errorCode){

        String errorMessage = "";

        switch (errorCode){
            case "selectList":
                errorMessage = "메뉴 전체 조회에 실패했습니다.";
                break;
            case "selectOne":
                errorMessage = "메뉴코드로 메뉴 조회에 실패했습니다.";
                break;
            case "insertError":
                errorMessage = "신메뉴 추가에 실패했습니다.";
                break;
            case "updateError":
                errorMessage = "메뉴정보 수정에 실패했습니다.";
                break;
            case "deleteError":
                errorMessage = "메뉴정보 삭제에 실패했습니다.";
                break;
        }

        System.out.println("오류: "+errorMessage);
    }

    public void printMenu(MenuDTO menu) {
        System.out.println("\n"+menu.getMenuCode() + "번의 메뉴의 정보입니다.");
        System.out.println(menu);
        System.out.println("============================================\n");
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch (successCode){
            case "insert":
                successMessage = "신메뉴 추가에 성공했습니다.";
                break;
            case "update":
                successMessage = "메뉴정보 수정을 성공했습니다.";
                break;
            case "delete":
                successMessage = "메뉴 삭제에 성공했습니다.";
                break;
        }

        System.out.println("성공 메세지 = " + successMessage);
    }
}
