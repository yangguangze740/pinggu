package com.zhulin.bus.service.file.raterFile.impl;

import com.zhulin.bus.bean.RaterFile;
import com.zhulin.bus.bean.RaterFileModify;
import com.zhulin.bus.mapper.file.rater.RaterFileMapperI;
import com.zhulin.bus.service.file.raterFile.RaterFileServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaterFileServiceImpl implements RaterFileServiceI {

    @Autowired
    private RaterFileMapperI raterFileMapperI;

    @Override
    public List<RaterFile> appReadList(RaterFile raterFile) {
        return raterFileMapperI.selectList(raterFile);
    }

    @Override
    public RaterFile appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(RaterFile raterFile) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return raterFileMapperI.delete(id);
    }

    @Override
    public boolean appCreate(RaterFile raterFile) {
        return false;
    }

    @Override
    public RaterFile readRaterFileFullPathFile(String fileId) {
        return raterFileMapperI.selectRaterFileFullPathFile(fileId);
    }

    @Override
    public boolean insertModify(RaterFileModify raterFileModify) {
        raterFileModify.setRaterFileModifyId(PrimaryKeyUtil.uuidPrimaryKey());

        return raterFileMapperI.insertModify(raterFileModify);
    }
}
