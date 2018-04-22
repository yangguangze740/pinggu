package com.zhulin.bus.service.score.impl;

import com.zhulin.bus.bean.Score;
import com.zhulin.bus.mapper.score.ScoreMapper;
import com.zhulin.bus.service.score.ScoreServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@ClassRolePermission(group = "problem", name = "问题管理", value = "problem:m", menuValue = "/admin/score")
@Service
public class ScoreServiceImpl implements ScoreServiceI{

    @Autowired
    private ScoreMapper scoreMapper;

    @MethodRolePermission(group = "score", name = "分数查看", value = "score:mr", groupName = "分数组")
    @Override
    public List<Score> appReadList(Score score) {
        return scoreMapper.selectList(score);
    }

    @MethodRolePermission(group = "score", name = "分数详细", value = "score:mr", groupName = "分数组")
    @Override
    public Score appReadDetail(String id) {
        return scoreMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "score", name = "分数编辑", value = "score:mu", groupName = "分数组")
    @Override
    public boolean appUpdate(Score score) {
        return scoreMapper.update(score);
    }

    @MethodRolePermission(group = "score", name = "分数删除", value = "score:md", groupName = "分数组")
    @Override
    public boolean appDelete(String id) {
        return scoreMapper.delete(id);
    }

    @MethodRolePermission(group = "score", name = "分数添加", value = "score:mc", groupName = "分数组")
    @Override
    public boolean appCreate(Score score) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        score.setScoreId(id);

        return scoreMapper.insert(score);
    }
}
