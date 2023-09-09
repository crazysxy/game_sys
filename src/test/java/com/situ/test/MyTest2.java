package com.situ.test;

import com.situ.bean.GamingCompany;
import com.situ.config.MainConfig;
import com.situ.mapper.CompanyMapper;
import com.situ.service.CompanyService;
import com.situ.service.GameInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = MainConfig.class)
public class MyTest2 {
    @Autowired
    private GameInfoService gameInfoService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyMapper companyMapper;


    @Test
    public void test1(){
        gameInfoService.selectByPage("塞尔达", 0, 500).stream().forEach(System.out::println);
    }

    @Test
    public void TEst2() throws Exception {
        GamingCompany gamingCompany = new GamingCompany(999, "暴雪33", "中国");

        System.out.println(companyService.add(gamingCompany));
    }
    @Test
    public void test3(){
        companyMapper.insert(new GamingCompany(null, "aaa", "aaa"));
    }

    @Test
    public void test4(){

        GamingCompany gamingCompany = companyMapper.selectBycid(1);
        System.out.println(gamingCompany);

    }

    @Test
    public void test5(){
        GamingCompany cdpr = companyMapper.selecrByCname("cdpr");
        System.out.println(cdpr);
    }

}
