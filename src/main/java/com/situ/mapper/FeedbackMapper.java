package com.situ.mapper;

import com.situ.bean.Feedback;
import com.situ.bean.FeedbackVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FeedbackMapper {

    int add(Feedback fb);
    int del(Integer fid);
    List<FeedbackVO> selectBySearchName(@Param("searchGName")String searchGName, @Param("searchCName")String searchCName);
    List<Map<String,Object>> selectAllGname();

}
