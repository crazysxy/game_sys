package com.situ.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.bean.Feedback;
import com.situ.bean.FeedbackVO;
import com.situ.bean.RespBean;
import com.situ.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("feedbackController")
public class FeedbackController {
    @Autowired
    private  FeedbackService feedbackService;

    @GetMapping("/selectAllFeedback")
    public RespBean select( String searchGname,String searchCname,Integer currentPage) throws ServletException, IOException {

        if (currentPage==null){
            currentPage = 1;
        }
        System.out.println(searchCname);
        System.out.println(searchGname);

        PageHelper.startPage(currentPage, 10);
        List<FeedbackVO> feedbackVOS = feedbackService.selectBySearchName(searchGname, searchCname);
        PageInfo<FeedbackVO> pageinfo= new PageInfo<>(feedbackVOS);
        System.out.println("所有导航页号"+ Arrays.toString(pageinfo.getNavigatepageNums()));

        return RespBean.ok("查询成功",pageinfo);

    }

    @GetMapping("/selectAllGname")
    public  RespBean selectAllGname() throws ServletException, IOException {
        List<Map<String, Object>> maps = feedbackService.selectAllGname();

        return RespBean.ok("查询成功", maps);

    }

    @RequestMapping("/delFeedback")
    public  RespBean del(Integer fid) throws ServletException, IOException {

        int del = feedbackService.del(fid);

        return RespBean.ok("删除成功");

    }

    @RequestMapping("/addFeedback")
    public RespBean add(Feedback feedback) throws ServletException, IOException {

        System.out.println(feedback);
        int add = feedbackService.add(feedback);
        return RespBean.ok("添加成功");

    }




}
