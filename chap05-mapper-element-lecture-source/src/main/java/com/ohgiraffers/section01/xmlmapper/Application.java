package com.ohgiraffers.section01.xmlmapper;

import javax.lang.model.element.Element;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ElementService elementService = new ElementService();

        do {

            System.out.println("=========Mapper Element 테스트 메뉴=========");
            System.out.println("1. CacheTest");
            System.out.println("2. resultMap");
            System.out.println("3. sql");
            System.out.println("4. insert");

            System.out.print("\n원하시는 메뉴를 선택하세요: ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    elementService.selectCacheTest();
                    break;
                case 2:
                    resultMapSubMenu();
                    break;
            }

        } while (true);

    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);

        ElementService elementService = new ElementService();

        do {

            System.out.println("==========ResultMap 서브메뉴=========");
            System.out.println("1. resultMap 테스트");
            System.out.println("2. constructor 테스트");                   // 생성자를 통한 결과 값 매핑
            System.out.println("3. associate 테스트");                     // 관계 맺어진 테이블이 1:1의 포함관계일 경우
            System.out.println("4. collection 테스트");                    // 1 : M 포함 관계일 경우
            System.out.print("\n메뉴 번호를 입력해주세요: ");

            int no = sc.nextInt();

            switch (no){
                case 1:
                    elementService.selectResultMapTest();
                    break;
                case 2:
                    elementService.selectResultMapConstructor();
                    break;
                case 3:
                    elementService.selectResultMapAssociation();
                    break;
                case 4:
                    break;
            }

        }while (true);

    }

}
