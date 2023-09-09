package com.situ.service;

import com.situ.bean.GameInf;
import com.situ.bean.GameInfoVo;

import java.util.List;
import java.util.Map;

public interface GameInfoService {
    boolean add(GameInf gameInf) throws Exception;
    boolean changeStatus(Integer gid) throws Exception;
    List<GameInfoVo> selectByPage( String searchGname, Integer minPrice,  Integer maxPrice);


    //Page<GameInfoVo> selectByPage(Page<GameInfoVo> page,String searchName ,Integer minPrice,Integer maxPrice);
    //long count(String searchName ,Integer minPrice,Integer maxPrice);

    String getMaxGno();
    GameInf selectByGid(Integer gid);
    boolean update(GameInf gameInf) throws Exception;

    List<Map<String, Object>> topTen();

    List<Map<String, Object>> countByYear();
}
