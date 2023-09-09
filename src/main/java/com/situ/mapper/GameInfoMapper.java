package com.situ.mapper;

import com.situ.bean.GameInf;
import com.situ.bean.GameInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GameInfoMapper {
    int add(GameInf game);
    List<GameInf> selectAll();
    GameInf selectByGid(Integer gid);

    GameInf selectByGname(String gamename);
   List<GameInfoVo> selectByPage(@Param("searchGname") String searchGname, @Param("minPrice") Integer minPrice, @Param("maxPrice") Integer maxPrice);

    //long count( String searchname ,Integer minPrice,Integer maxPrice);

    String getMaxGno();

    List<GameInf> selectByCid(Integer cid);

    int changeStatus(Integer gid);

    int update(GameInf game);
    List<Map<String, Object>> topTen();

    public List<Map<String, Object>> countByYear();
}
