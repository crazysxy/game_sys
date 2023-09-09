package com.situ.test;

import com.situ.config.MainConfig;
import com.situ.mapper.FeedbackMapper;
import com.situ.mapper.UserMapper;
import com.situ.service.FeedbackService;
import com.situ.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = MainConfig.class)
public class MyTest01 {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Test
    public void test1() {
        System.out.println(userMapper.findUserByUsernameAndPassword("admin", "admin"));
    }

    @Test
    public void test2(){
        System.out.println(userService.findUserByUsernameAndPassword("root", "root"));
    }

    @Test
    public void test3(){

        feedbackService.selectBySearchName(null,"任天堂").stream().forEach(System.out::println);
    }
    @Test
    public void test4(){

        feedbackMapper.selectBySearchName(null, "任").stream().forEach(System.out::println);
        //feedbackMapper.selectBySearchName("塞尔达","任天堂").stream().forEach(System.out::println);
    }


}
