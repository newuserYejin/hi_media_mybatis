package com.ohgiraffers.section01.xmlconfig.view;

import com.ohgiraffers.section01.xmlconfig.controller.MenuController;

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
            }


        } while (true);
        
    }
}
