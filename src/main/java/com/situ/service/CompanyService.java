package com.situ.service;

import com.situ.bean.GamingCompany;

import java.util.List;
import java.util.Map;

public interface CompanyService {
    //增加
    boolean add(GamingCompany gamc) throws Exception;
    //删除
    boolean del(Integer cid) throws Exception;
    //修改
    boolean upd (GamingCompany gamc) throws Exception;

    //查询
    List<GamingCompany> selectAll();

    GamingCompany selectByCid(Integer cid) ;
    public List<Map<String, Object>> selectPercent();

}
