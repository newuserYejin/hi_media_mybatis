package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {
    
    // DUAL : 가상의 테이블
    @Select("SELECT CURRENT_DATE() FROM DUAL")
    Date selectSysDate();       // <- 메소드 명임 (연달아 작성하면 해당 메소드 명에 바로 위의 SQL문이 연결된다.)


}
