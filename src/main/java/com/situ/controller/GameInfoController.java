package com.situ.controller;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.bean.*;
import com.situ.service.CompanyService;
import com.situ.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/GameInfoController")
public class GameInfoController {
    @Autowired
    private GameInfoService gameInfoService;
    @Autowired
    private CompanyService companyService;

    @GetMapping("/selectAllCname")
    public RespBean selectAllCname(){
        List<GamingCompany> companyList = companyService.selectAll();
        return  RespBean.ok("查询成功", companyList);
    }


    @PostMapping("/addGame")
    public RespBean add(GameInf gameInf) throws Exception {
        System.out.println(gameInf);

        boolean add = gameInfoService.add(gameInf);
        if (!add){
            return RespBean.error("添加失败");
        }
        return  RespBean.ok("添加成功");
    }


    @RequestMapping("/updGameInf")
    public RespBean update(GameInf gameInf) throws Exception {

        System.out.println(gameInf);

        boolean update = gameInfoService.update(gameInf);
        if (!update){
            return RespBean.error("修改失败");
        }
        return  RespBean.ok("修改成功");

    }


    @GetMapping("/selectByPage")
    public RespBean selectByPage( Integer currentPage,String searchName,Integer minPrice,Integer maxPrice){

        if (currentPage==null){
            currentPage = 1;
        }
        if(minPrice==null){
            minPrice=0;
        }
        if(maxPrice==null){
            maxPrice=999999;
        }
        if(minPrice>maxPrice){
           return RespBean.error("最小价格超过最大价格！！！");
        }

        PageHelper.startPage(currentPage, 10);
        List<GameInfoVo> list = gameInfoService.selectByPage(searchName, minPrice, maxPrice);

        PageInfo<GameInfoVo> pageinfo= new PageInfo<>(list);

        System.out.println( "导航页码数："+pageinfo.getNavigatePages());
        System.out.println("所有导航页号"+ Arrays.toString(pageinfo.getNavigatepageNums()));

        return RespBean.ok("查询成功", pageinfo);
    }


    @RequestMapping("/selectByGid")
    public RespBean selectByGid(int gid) throws ServletException, IOException {
        GameInf gameInfoVo = gameInfoService.selectByGid(gid);
        return RespBean.ok("正在修改", gameInfoVo);
    }

    @RequestMapping("/delGame")
    public RespBean del(int gid) throws ServletException, IOException {
        try {
            gameInfoService.changeStatus(gid);
        } catch (Exception e) {
            e.printStackTrace();
           return RespBean.error(e.getMessage());
        }
        return RespBean.ok("删除成功");

    }



    @RequestMapping("/toExcel")
    public RespBean toExcel(Integer currentPage,String searchName,Integer minPrice,Integer maxPrice) throws ServletException, IOException {

        if (currentPage==null){
            currentPage = 1;
        }
        if(minPrice==null){
            minPrice=0;
        }
        if(maxPrice==null){
            maxPrice=999999;
        }
        if(minPrice>maxPrice){
            return RespBean.error("最小价格超过最大价格！！！");
        }

        List<GameInfoVo> list = gameInfoService.selectByPage(searchName, minPrice, maxPrice);

        //以上为获取集合

        //开始导出Excel
        String fileName = UUID.randomUUID().toString();
        String URL="C:\\Users\\crazy\\Desktop\\EasyExcel\\" + fileName + ".xls";
        if(list.size()==0){

            return RespBean.error("没有内容，无法导出");
        }
        EasyExcel.write(URL, GameInfoVo.class)
                .sheet("游戏信息")
                .head(GameInfoVo.class)
                .doWrite(list);
        return RespBean.ok("导出成功");


    }





}
