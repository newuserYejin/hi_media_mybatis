package com.ohgiraffers.section02.javaconfig.view;


import com.ohgiraffers.section02.javaconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuView {
    
    /*
    * 1. 메뉴전체조회
    * 2. 메뉴 코드로 조회
    * 3. 신규메뉴 등록
    * 4. 메뉴 수정
    * 5. 메뉴 삭제
    * */

    public void display() {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        
        do {
            System.out.println("================메뉴 관리 시스템================");
            System.out.println("1. 메뉴전체 조회하기");
            System.out.println("2. 메뉴 코드로 조회하기");
            System.out.println("3. 신규 메뉴 등록하기");
            System.out.println("4. 메뉴 수정하기");
            System.out.println("5. 메뉴 삭제하기");
            System.out.println("=======================================");
            System.out.print("실행할 메뉴를 선택해주세요: ");
            int num = sc.nextInt();

            switch (num){
                case 1 :
                    menuController.selectAllMenu();
                    break;
//                case 2:
//                    menuController.selectMenuByCode(inputMenuCode());
//                    break;
//                case 3:
//                    menuController.insertNewMenu(inputMenu());
//                    break;
//                case 4:
//                    menuController.updateMenu(updateMenuInfo());
//                    break;
//                case 5:
//                    menuController.deleteMenu(deleteMenuCode());
//                    break;
            }


        } while (true);
        
    }

    private static Map<String, String> inputMenuCode(){

        Scanner sc = new Scanner(System.in);
        System.out.print("검색하실 메뉴의 코드를 입력해주세요: ");
        String menuCode = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();

        parameter.put("menuCode",menuCode);

        return parameter;
    }

    private static Map<String, String> inputMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.print("메뉴의 이름을 입력해주세요: ");
        String menuName = sc.nextLine();

        System.out.print("메뉴의 가격을 입력해주세요: ");
        String menuPrice = sc.nextLine();

        System.out.print("메뉴의 카테고리 코드를 입력해주세요: ");
        String category = sc.nextLine();

        Map<String, String> newMenu = new HashMap<>();

        newMenu.put("menuName",menuName);
        newMenu.put("menuPrice",menuPrice);
        newMenu.put("category",category);

        return newMenu;
    }

    private static Map<String, String> updateMenuInfo(){
        Scanner sc = new Scanner(System.in);

        System.out.print("수정하실 메뉴의 번호를 입력해주세요: ");
        String menuCode = sc.nextLine();
        System.out.print("수정하실 메뉴의 이름를 입력해주세요: ");
        String menuName = sc.nextLine();
        System.out.print("수정하실 메뉴의 가격를 입력해주세요: ");
        String menuPrice = sc.nextLine();
        System.out.print("수정하실 메뉴의 카테고리 코드를 입력해주세요: ");
        String categoryCode = sc.nextLine();

        Map<String,String > updateMenu = new HashMap<>();

        updateMenu.put("menuCode",menuCode);
        updateMenu.put("menuName",menuName);
        updateMenu.put("menuPrice",menuPrice);
        updateMenu.put("category",categoryCode);

        return updateMenu;
    }

    private static int deleteMenuCode(){
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제하실 메뉴의 번호를 입력해주세요: ");
        int code = sc.nextInt();

        return code;
    }
}
