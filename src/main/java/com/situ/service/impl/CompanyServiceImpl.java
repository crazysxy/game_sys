package com.situ.service.impl;

import com.situ.bean.GameInf;
import com.situ.bean.GamingCompany;
import com.situ.mapper.CompanyMapper;
import com.situ.mapper.GameInfoMapper;
import com.situ.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService {
    //private CompanyDao companyDao = new CompanyDaoImpl();
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private GameInfoMapper gameInfoMapper;
    @Override
    public boolean add(GamingCompany gamc) throws Exception {
        if (companyMapper.selecrByCname(gamc.getCname())!=null) {
            throw  new Exception("该公司已存在，不能重复添加");
        }
        return companyMapper.insert(gamc)==1?true:false;
    }

    @Override
    public boolean del(Integer cid) throws Exception {
        if (companyMapper.selectBycid(cid)==null) {
            throw new Exception("该公司不存在，无法删除");
        }
        //GameInfoDao gameInfoDao = new GameInfoDaoImpl();
        List<GameInf> list = gameInfoMapper.selectByCid(cid);
        if(list!=null&&list.size()!=0){
            System.out.println(list);
            System.out.println(list.size());
            throw  new Exception("公司中存在在售游戏，无法删除");
        }

        return this.companyMapper.del(cid)==1?true:false;
    }

    @Override
    public boolean upd(GamingCompany gamc) throws Exception {
        //判断此对象中姓名是否与表中其他名字重复
        GamingCompany gamingCompany = companyMapper.selecrByCname(gamc.getCname());
        if (gamingCompany!=null&&!gamingCompany.getCname().equals(gamc.getCname())){
            throw  new Exception("已存在该公司，无法修改");
        }
        return companyMapper.upd(gamc)==1?true:false;
    }

    @Override
    public List<GamingCompany> selectAll() {

        return companyMapper.selectAll();
    }

    @Override
    public GamingCompany selectByCid(Integer cid) {
        GamingCompany gamingCompany = companyMapper.selectBycid(cid);

        return gamingCompany;
    }

    @Override
    public List<Map<String, Object>> selectPercent() {
        return companyMapper.selectPercent();
    }

}
