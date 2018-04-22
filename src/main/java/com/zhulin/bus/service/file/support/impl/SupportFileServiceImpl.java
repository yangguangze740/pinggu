package com.zhulin.bus.service.file.support.impl;

import com.zhulin.bus.bean.RaterFile;
import com.zhulin.bus.bean.SupportFile;
import com.zhulin.bus.bean.SupportFileModify;
import com.zhulin.bus.mapper.file.support.SupportFileMapperI;
import com.zhulin.bus.service.file.support.SupportFileServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportFileServiceImpl implements SupportFileServiceI{

    @Autowired
    private SupportFileMapperI supportFileMapperI;

    @Override
    public List<SupportFile> appReadList(SupportFile supportFile) {
        return supportFileMapperI.selectList(supportFile);
    }

    @Override
    public SupportFile appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(SupportFile supportFile) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return supportFileMapperI.delete(id);
    }

    @Override
    public boolean appCreate(SupportFile supportFile) {
        return false;
    }

    @Override
    public boolean insertModify(SupportFileModify supportFileModify) {
        supportFileModify.setSupportFileModifyId(PrimaryKeyUtil.uuidPrimaryKey());

        return supportFileMapperI.insertModify(supportFileModify);
    }

    @Override
    public SupportFile readFileFullPathFile(String fileId) {
        return supportFileMapperI.selectFileFullPathFile(fileId);
    }
}
