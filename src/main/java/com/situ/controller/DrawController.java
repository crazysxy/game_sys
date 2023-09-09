package com.situ.controller;

import com.situ.bean.RespBean;
import com.situ.service.CompanyService;
import com.situ.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/draw")
public class DrawController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private GameInfoService gameInfoService;


    @RequestMapping("/selectPercent")
    public RespBean selectPercent() throws ServletException, IOException {

        List<Map<String, Object>> maps = companyService.selectPercent();

        return RespBean.ok("库中游戏厂商的占比", maps);

    }

@RequestMapping("/topTen")
    public RespBean topTen() throws ServletException, IOException {

        List<Map<String, Object>> maps = gameInfoService.topTen();
        return RespBean.ok("价格前十的游戏", maps);

    }


    @RequestMapping("/countByYear")
    public RespBean countByYear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Map<String, Object>> maps = gameInfoService.countByYear();

        //按年份分组查找游戏数量
        return RespBean.ok("", maps);

    }
}
