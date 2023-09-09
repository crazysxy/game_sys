package com.situ.test;

import com.situ.bean.Feedback;
import com.situ.bean.GameInf;
import com.situ.config.MainConfig;
import com.situ.mapper.CompanyMapper;
import com.situ.service.CompanyService;
import com.situ.service.FeedbackService;
import com.situ.service.GameInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = MainConfig.class)
public class MyTest3 {
    @Autowired
    private GameInfoService gameInfoService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private FeedbackService feedbackService;


    @Test
    public void test1(){
        feedbackService.selectAllGname().stream().forEach(System.out::println);
    }
    @Test
    public void test2(){
        feedbackService.add(new Feedback(null, 1, "443"));
    }

    @Test
    public void test3() throws Exception {
        GameInf gameInf = new GameInf(null, "10099", "hhh", "rpg", "0", "6", new Date(), new BigDecimal("99"));
        gameInfoService.add(gameInf);
    }



}
