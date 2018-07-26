package com.zhulin.bus.service.fileuser.impl;


import com.zhulin.bus.bean.FileDepartment;
import com.zhulin.bus.bean.FileType;
import com.zhulin.bus.bean.FileUser;
import com.zhulin.bus.mapper.fileuser.FileUserMapper;
import com.zhulin.bus.service.fileuser.FileUserServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class FileUserServiceImpl implements FileUserServiceI{

    @Autowired
    private FileUserMapper fileUserMapper;

    @Override
    public List<FileUser> appReadList(FileUser fileUser) {

        return fileUserMapper.selectList(fileUser );
    }

    @Override
    public FileUser appReadDetail(String id) {
        return fileUserMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(FileUser fileUser) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return fileUserMapper.delete(id);
    }

    @Transactional
    @Override
    public boolean appCreate(FileUser fileUser) {

        String fileUserId = PrimaryKeyUtil.uuidPrimaryKey();
        fileUser.setFileUserId(fileUserId);

        List<FileDepartment> fileDepartments = new ArrayList<>();
        List<String> departmentIds = fileUser.getDepartmentIds();

        for(String departmentId : departmentIds){

            FileDepartment fileDepartment = new FileDepartment();

            fileDepartment.setDepartmentId(departmentId);
            fileDepartment.setFileUserId(fileUserId);

            fileDepartments.add(fileDepartment);
        }

        List<FileDepartment> supportFileDepartments = new ArrayList<>();
        List<String> supportDepartmentIds = fileUser.getSupportDepartmentIds();

        for(String supportDepartmentId : supportDepartmentIds){

            FileDepartment fileDepartment =  new FileDepartment();

            fileDepartment.setSupportDepartmentId(supportDepartmentId);
            fileDepartment.setFileUserId(fileUserId);

            supportFileDepartments.add(fileDepartment);
        }

        List<FileType> fileTypes = new ArrayList<>();
        List<String> typeIds = fileUser.getTypeIds();

        for (String typeId : typeIds) {

            FileType fileType = new FileType();

            fileType.setFileUserId(fileUserId);
            fileType.setTypeId(typeId);

            fileTypes.add(fileType);
        }

        int insertFileNum = fileUserMapper.insertFileUser(fileUser);
        int insertFileDepartmentNum = fileUserMapper.insertRaterDepartment(fileDepartments);
        int insertFileTypeNum = fileUserMapper.inFileType(fileTypes);
        int insertSupportDepartmentNum =  fileUserMapper.insertSupportDepartment(supportFileDepartments);

        return (insertFileNum == 1) && (insertFileDepartmentNum == departmentIds.size()) && (insertFileTypeNum == typeIds.size());
    }
}
