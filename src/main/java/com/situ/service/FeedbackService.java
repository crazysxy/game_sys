package com.situ.service;

import com.situ.bean.Feedback;
import com.situ.bean.FeedbackVO;

import java.util.List;
import java.util.Map;

public interface FeedbackService {
    int add(Feedback fb);
    int del(Integer fid);
    List<FeedbackVO> selectBySearchName( String searchGName, String searchCName);
    //long count ( String searchGName, String searchCName);


    List<Map<String,Object>> selectAllGname();
}
