package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    
        // SqlSessionFactory는 어플리케이션 스코프(생명주기)를 가진다.
        // 여러개의 Factory응 생성하게 되면 ~~~하기 때문에 싱글톤을 유지하는게 좋다.
        
    private  static SqlSessionFactory sqlSessionFactory;
    
    public static SqlSession getSqlSession(){
        
        // factory를 생성한적이 없다면
        if (sqlSessionFactory == null){
            String resource = "mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // session 오픈
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println("\nsqlSessionFactory의 hashcode = " + sqlSessionFactory.hashCode());
        System.out.println("\nsqlSession의 hashcode = " + sqlSession.hashCode());

        return sqlSession;
    }

    public static void main(String[] args) {

        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());

    }
}
