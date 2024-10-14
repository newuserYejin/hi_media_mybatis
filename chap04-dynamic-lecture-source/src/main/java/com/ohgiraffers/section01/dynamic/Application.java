package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

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
                case 3:
                    forEachSubMenu();
                    break;
                case 4:
                    trimSubMenu();
                    break;
                case 9:
                    System.out.println("프로그램 종료");
                    return;
            }
            
        } while (true);

    }

    private static void trimSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        System.out.println("========trim 서브메뉴========");
        System.out.println("1. 검색조건이 있는경우 메뉴코드로 조회, 단 없으면 전체 조회");
        System.out.println("2. 메뉴 혹은 카테고리로 검색, 단 메뉴와 카테고리 둘 다 일치하는 겨우로 검색, 검색 조건 없으면 전체 조회");
        System.out.println("3. 원하는 메뉴 정보만 수정하기");
        System.out.println("9. 이전 메뉴로 이동");

        System.out.println("\n원하는 메뉴를 선택하세요: ");

        int no = sc.nextInt();

        switch (no){
            case 1:
                menuService.searchMenuCodeOrSearchAll(inputAllOrOne());
                break;
            case 2:
                menuService.searchMenuNameOrcategory(searchCriteriaMap());
                break;
            case 9:
                return;
        }

    }

    private static Map<String, Object> searchCriteriaMap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("검색 조건 (category or name or both or null): ");
        String condition = sc.nextLine();

        Map<String , Object> criteria = new HashMap<>();
        if ("category".equals(condition)){
            System.out.print("검색할 카테고리 코드를 입력해주세요: ");
            int categoryValue = sc.nextInt();
            criteria.put("categoryValue", categoryValue);
        } else if("name".equals(condition)){
            System.out.print("검색하실 메뉴명을 입력해주세요: ");
            String nameValue = sc.nextLine();
            criteria.put("nameValue",nameValue);
        } else if("both".equals(condition)){
            System.out.print("검색하실 메뉴명을 입력해주세요: ");
            String nameValue = sc.nextLine();
            System.out.print("검색할 카테고리 코드를 입력해주세요: ");
            int categoryValue = sc.nextInt();

            criteria.put("nameValue",nameValue);
            criteria.put("categoryValue",categoryValue);
        }

        return criteria;
    }

    private static SearchCriteria inputAllOrOne() {

        Scanner sc = new Scanner(System.in);
        System.out.println("검색조건을 입력하시겠습니까?(예 or 아니요): ");
        boolean hasSearchValue = "예".equals(sc.nextLine()) ? true : false;

        SearchCriteria searchCriteria = new SearchCriteria();

        if (hasSearchValue){
            System.out.print("검색할 메뉴 코드를 입력해주세요: ");
            String code = sc.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(code);
        }

        return searchCriteria;
    }

    private static void forEachSubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {

            System.out.println("=======for Each 메뉴=========");
            System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회하기");
            System.out.println("9. 이전메뉴");

            System.out.print("\n원하시는 메뉴를 선택해주세요: ");

            int no = sc.nextInt();

            switch (no){
                case 1:
                    menuService.searchMenuByRandomCode(createRandomCodeList());
                    break;
                case 9:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
            }

        }while (true);

    }

    private static List<Integer> createRandomCodeList() {
        Set<Integer> set = new HashSet<>();
//        while (set.size() < 5){
//            int temp = ((int) (Math.random() * 20)) +1;
//            set.add(temp);
//        }

        for (int i = 1; i< 5; i++){
            int temp = ((int) (Math.random() * 20)) +1;
            set.add(temp);
        }

        List<Integer> menuCodeList = new ArrayList<>(set);
        Collections.sort(menuCodeList);

        System.out.println(set);

        return menuCodeList;
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
