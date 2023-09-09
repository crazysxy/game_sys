package com.situ.service.impl;

import com.situ.bean.Feedback;
import com.situ.bean.FeedbackVO;
import com.situ.mapper.FeedbackMapper;
import com.situ.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("FeedbackService")
public class FeedbackServiceImpl implements FeedbackService {
    //private FeedbackDao feedbackDao = new FeedbackDaoImpl();
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Override
    public int add(Feedback fb) {
        return feedbackMapper.add(fb);
    }

    @Override
    public int del(Integer fid) {
        return feedbackMapper.del(fid);

    }

    @Override
    public List<FeedbackVO> selectBySearchName( String searchGName, String searchCName) {
        return feedbackMapper.selectBySearchName(searchGName, searchCName);
    }

    //@Override
    //public long count(String searchGName, String searchCName) {
    //    return feedbackMapper.count(searchGName, searchCName);
    //}

    @Override
    public List<Map<String, Object>> selectAllGname() {
        return feedbackMapper.selectAllGname();
    }
}
