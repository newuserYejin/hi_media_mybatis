package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.Date;

public class Application {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";


    public static void main(String[] args) {

        // 환경설정
        Environment environment = new Environment(
                "dev" ,           // 생성하는 환경의 이름 dev로 생성
                new JdbcTransactionFactory(),       // DB에 관한 반영을 수동 커밋으로 설정 -> 기본으로는 자동 커밋(ManagedTransactionFactory)
                new PooledDataSource(DRIVER,URL,USER,PASSWORD)      // ConnectionPool 사용  <-> UnPoolDataSource() : ConnectionPool 미사용
        );

        // 만들어둔 환경정보 바탕으로 MyBatis 구성 (DB와 업속할 정보 생성)
        Configuration configuration = new Configuration(environment);
        
        // DB 접근 클래스 등록
        configuration.addMapper(Mapper.class);

        // Session 구성 (jdbc의 connection)
        // SqlSession 을 만들기 위한 준비 단계 : SqlSessionFactory <- 객체 생성 인터페이스 , SqlSessionFactoryBuilder <- SqlSessionFactory 인터페이스 하위 구현 객체 생성, build()

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);

        /*
        * openSession() : SqlSession 인터페이스 타입 객체 반환, false 전달 시 DML 수행후 autocommit 설정을 꺼주게 된다.(권장사항)
        * */
        SqlSession sqlSession =factory.openSession(false);

        // 등록 Mapper의 내부에 작성한 기능 실행
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        Date date = mapper.selectSysDate();

        System.out.println("date = " + date);

        sqlSession.close();


    }
}