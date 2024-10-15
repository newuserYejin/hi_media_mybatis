package com.ohgiraffers.section01.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementService {

    private ElementMapper mapper;

    public void selectCacheTest() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        for (int i = 0; i<10;i++){
            // 시간 체크
            Long startTime = System.currentTimeMillis();
            
            List<String> menuNameList = mapper.selectCacheTest();
            System.out.println(menuNameList);
            
            Long endTime = System.currentTimeMillis();
            
            Long interval = endTime - startTime;
            System.out.println("수행 시간 = " + interval);
            
        }
        sqlSession.close();
    }
}
