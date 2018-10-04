package com.project.alpha.test.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

    @Autowired
    private SqlSessionTemplate template;

    public String selectTest(){
        return template.selectOne("test.selectTest");
    }

}
