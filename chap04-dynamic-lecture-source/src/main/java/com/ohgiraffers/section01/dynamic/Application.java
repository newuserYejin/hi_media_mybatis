package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.SearchCriteria;

import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("===마이바티스 동작 SQL 학습 메뉴===");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기");
            System.out.print("원하시는 메뉴를 선택하세요: ");

            int no = sc.nextInt();

            switch (no){
                case 1:
                    ifsubMenu();
                    break;
                case 2:
                    chooseSubMenu();
                    break;
                case 9:
                    System.out.println("프로그램 종료");
                    return;
            }
            
        } while (true);

    }

    private static void chooseSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("==========choose 서브메뉴=========");
            System.out.println("1. 카테고리 상위 분류별 메뉴보여주기(식사, 음료, 디저트)");
            System.out.println("9. 이전 메뉴로 돌아가기");

            System.out.print("메뉴번호를 입력해주세요: ");

            int num = sc.nextInt();

            switch (num){
                case 1:
                    menuService.searchMenuBySupCategory(inputSupCAtegory());
                    break;
                case 9:
                    System.out.println("choose 메뉴를 종료합니다.");
                    return;
            }

        } while (true);

    }

    private static SearchCriteria inputSupCAtegory() {
        Scanner sc = new Scanner(System.in);

        System.out.print("원하시는 상위 카테고리를 골라주세요(식사, 음료, 디저트): ");
        String value = sc.nextLine();

        return new SearchCriteria("category", value);
    }

    private static void ifsubMenu(){

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {

            System.out.println("==================if 서브메뉴=================");
            System.out.println("1. 원하는 금액대의 적합한 추천메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 or 카테고리 명으로 검색해서 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("원하는 메뉴를 선택해주세요: ");

            int no = sc.nextInt();

            switch (no){
                case 1:
                    menuService.selectMenuByPrice(inputPrice());
                    break;
                case 2:
                    menuService.searchMenu(inputSearchCriteria());
                    break;
                case 9:
                    System.out.println("서브 메뉴 종료");
                    return;
            }

        } while (true);

    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);
        System.out.print("검색 기준을 입력해주세요(menuName or category): ");
        String condition = sc.nextLine();

        System.out.print("검색어를 입력해주세요: ");
        String keyword = sc.nextLine();

        return new SearchCriteria(condition,keyword);
    }

    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);

        System.out.print("검색하실 금액의 최대 금액을 입력해주세요: ");

        int price = sc.nextInt();

        return price;
    }


}
