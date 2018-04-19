package com.zhulin.bus.service.score.impl;

import com.zhulin.bus.bean.Score;
import com.zhulin.bus.mapper.score.ScoreMapper;
import com.zhulin.bus.service.score.ScoreServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreServiceI{

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> appReadList(Score score) {
        return scoreMapper.selectList(score);
    }

    @Override
    public Score appReadDetail(String id) {
        return scoreMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(Score score) {
        return scoreMapper.update(score);
    }

    @Override
    public boolean appDelete(String id) {
        return scoreMapper.delete(id);
    }

    @Override
    public boolean appCreate(Score score) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        score.setScoreId(id);

        return scoreMapper.insert(score);
    }
}
