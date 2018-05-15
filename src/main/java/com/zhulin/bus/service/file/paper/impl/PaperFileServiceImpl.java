package com.zhulin.bus.service.file.paper.impl;

import com.zhulin.bus.bean.Paper;
import com.zhulin.bus.bean.PaperFile;
import com.zhulin.bus.bean.PaperFileModify;
import com.zhulin.bus.bean.Subject;
import com.zhulin.bus.mapper.file.paper.PaperFileMapper;
import com.zhulin.bus.service.file.paper.PaperFileServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ClassRolePermission(group = "paperFile", name = "试卷文件管理", value = "paperFile:m", menuValue = "/admin/paperFile")
public class PaperFileServiceImpl implements PaperFileServiceI{

    @Autowired
    private PaperFileMapper paperFileMapper;

    @MethodRolePermission(group = "paperFile", name = "试卷文件查看", value = "paperFile:mr", groupName = "试卷文件组")
    @Override
    public List<PaperFile> appReadList(PaperFile paperFile) {
        return paperFileMapper.selectList(paperFile);
    }

    @Override
    public PaperFile appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(PaperFile paperFile) {
        return false;
    }

    @MethodRolePermission(group = "paperFile", name = "试卷文件删除", value = "paperFile:md", groupName = "试卷文件组")
    @Override
    public boolean appDelete(String id) {
        return paperFileMapper.delete(id);
    }

    @Override
    public boolean appCreate(PaperFile paperFile) {
        return false;
    }

    @Override
    public boolean insertModify(PaperFileModify paperFileModify) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        paperFileModify.setPaperFileModifyId(id);

        return paperFileMapper.insertModify(paperFileModify);
    }

    @Override
    public PaperFile readPaperFileFullPathFile(String fileId) {
        return paperFileMapper.selectFilePath(fileId);
    }

    @Override
    public List<Paper> queryPaperBySubjectId(String subjectId) {
        return paperFileMapper.selectPaper(subjectId);
    }
}
