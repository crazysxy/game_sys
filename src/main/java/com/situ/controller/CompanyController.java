package com.situ.controller;


import com.situ.bean.GamingCompany;
import com.situ.bean.RespBean;
import com.situ.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@RestController("/CompanyController")
public class CompanyController {
    @Autowired
    private CompanyService companyService;


    @GetMapping("/selectAllCompany")
    public RespBean selectAll(){
        List<GamingCompany> companies = companyService.selectAll();
        return  RespBean.ok("查询成功", companies);
    }

    @GetMapping("selectByCid")
    public RespBean selectByCid( String cid) {
        if (cid == null || !cid.matches("\\d+$")) {
            System.out.println("111");
            return RespBean.error("非法的参数");
        }
        int cid0 = Integer.parseInt(cid);
        GamingCompany gamingCompany = companyService.selectByCid(cid0);
         return  RespBean.ok("查找成功", gamingCompany);

    }
    @PostMapping("addCompany")
    public RespBean add( GamingCompany company) throws ServletException, IOException {

        String cname = company.getCname();
        String country = company.getCountry();
        String regex="^[\\u4e00-\\u9fa5_a-zA-Z0-9\\s*]{2,20}$";

        if(!cname.matches(regex)||!country.matches(regex)){
            return RespBean.error("参数校验错误");
        }
        if(cname==null||country==null){
            return RespBean.error("非法的参数");
        }
        try {
            companyService.add(company);
            return RespBean.ok("添加成功");

        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error(e.getMessage());
        }

    }

    @RequestMapping("deleteCompany")
    public RespBean delete(String cid) throws ServletException, IOException {
        System.out.println(cid);
        if(cid ==null || !cid.matches("\\d+$")){
            return RespBean.error("非法的参数");
        }
        try {
            companyService.del(Integer.parseInt(cid));
            return RespBean.ok("删除成功~");
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error(e.getMessage());
        }
    }

    @RequestMapping("updateCompany")
    public RespBean update(GamingCompany company) throws ServletException, IOException {
        System.out.println(company);
        //获取请求参数
        Integer cid=company.getCid();
        String cname = company.getCname();
        String country = company.getCountry();
        String regex="^[\\u4e00-\\u9fa5_a-zA-Z0-9\\s]{2,20}$";

        if(!cname.matches(regex)||!country.matches(regex)){

            return  RespBean.error("参数校验错误");
        }
        //修改
        try {
            companyService.upd(company);
            return RespBean.ok("修改成功");

        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error(e.getMessage());
        }


    }




}
