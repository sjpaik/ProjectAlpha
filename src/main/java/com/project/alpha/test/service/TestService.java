package com.project.alpha.test.service;

import com.project.alpha.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public String selectTest(){
        return testRepository.selectTest();
    }

}
