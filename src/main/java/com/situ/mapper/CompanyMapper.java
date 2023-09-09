package com.situ.mapper;

import com.situ.bean.GamingCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CompanyMapper {
    int insert(GamingCompany gamc);
    //删除
    int del(Integer cid);
    //修改
    int upd(GamingCompany gamc);
    //查询所有
    List<GamingCompany> selectAll();
    //根据cid查询
    GamingCompany selectBycid(Integer cid);
    //根据cname查询
    GamingCompany selecrByCname(@Param("cname") String cname);
    List<Map<String, Object>> selectPercent();

}
