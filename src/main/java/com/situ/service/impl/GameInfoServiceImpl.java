package com.situ.service.impl;

import com.situ.bean.GameInf;
import com.situ.bean.GameInfoVo;
import com.situ.mapper.GameInfoMapper;
import com.situ.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("GameInfoService")
public class GameInfoServiceImpl implements GameInfoService {
    //private GameInfoDao gameInfoDao = new GameInfoDaoImpl();
    @Autowired
    private GameInfoMapper gameInfoMapper;

    @Override
    public boolean add(GameInf gameInf) throws Exception {
        GameInf gameInf1 = gameInfoMapper.selectByGname(gameInf.getGameName());
        if(gameInf1!=null) {
            //throw new Exception("已存在该游戏，无法添加");
            return false;
        }
        String maxGno = gameInfoMapper.getMaxGno();
        int maxg=Integer.parseInt(maxGno)+1;
        gameInf.setGno(maxg + "");
        int add = gameInfoMapper.add(gameInf);
        return add==1?true:false;

    }


    @Override
    public boolean changeStatus(Integer gid) throws Exception {

        GameInf gameInf = gameInfoMapper.selectByGid(gid);

        if(gameInf==null){
            throw  new Exception("不存在该游戏，删除失败");
        }
        return gameInfoMapper.changeStatus(gid)==1?true:false;
    }

    @Override
    public List<GameInfoVo> selectByPage(String searchGname, Integer minPrice, Integer maxPrice) {

        return gameInfoMapper.selectByPage(searchGname, minPrice, maxPrice);
    }

    //@Override
    //public Page<GameInfoVo> selectByPage(Page<GameInfoVo> page, String searchName,Integer minPrice,Integer maxPrice) {
    //    gameInfoMapper.selectByPage(page, searchName,minPrice,maxPrice);
    //    return page;
    //}

    //@Override
    //public long count(String searchName ,Integer minPrice,Integer maxPrice) {
    //    return  gameInfoMapper.count(searchName,minPrice,maxPrice);
    //}

    @Override
    public String getMaxGno() {
        return gameInfoMapper.getMaxGno();
    }

    @Override
    public GameInf selectByGid(Integer gid) {
        return gameInfoMapper.selectByGid(gid);
    }

    @Override
    public boolean update(GameInf gameInf) throws Exception {
        GameInf gameInf1 = gameInfoMapper.selectByGname(gameInf.getGameName());
        if(gameInf1!=null&&gameInf1.getGameName().equals(gameInf.getGameName())){
            //throw  new Exception("已存在该游戏，无法修改");
            return false;
        }
        return gameInfoMapper.update(gameInf)==1?true:false;
    }

    @Override
    public List<Map<String, Object>> topTen() {
        return gameInfoMapper.topTen();
    }

    @Override
    public List<Map<String, Object>> countByYear() {
        return gameInfoMapper.countByYear();
    }
}
