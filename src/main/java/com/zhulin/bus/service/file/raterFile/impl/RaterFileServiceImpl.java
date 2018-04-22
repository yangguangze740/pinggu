package com.zhulin.bus.service.file.raterFile.impl;

import com.zhulin.bus.bean.RaterFile;
import com.zhulin.bus.bean.RaterFileModify;
import com.zhulin.bus.mapper.file.rater.RaterFileMapperI;
import com.zhulin.bus.service.file.raterFile.RaterFileServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@ClassRolePermission(group = "file", name = "文件管理", value = "file:m", menuValue = "/admin/raterFile")
@Service
public class RaterFileServiceImpl implements RaterFileServiceI {

    @Autowired
    private RaterFileMapperI raterFileMapperI;

    @MethodRolePermission(group = "rater", name = "自评问件查看", value = "rater:mr", groupName = "自评文件组")
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


    @MethodRolePermission(group = "rater", name = "自评问件删除", value = "rater:md", groupName = "自评文件组")
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
