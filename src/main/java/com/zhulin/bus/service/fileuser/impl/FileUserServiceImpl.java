package com.zhulin.bus.service.fileuser.impl;


import com.zhulin.bus.bean.FileDepartment;
import com.zhulin.bus.bean.FileType;
import com.zhulin.bus.bean.FileUser;
import com.zhulin.bus.mapper.fileuser.FileUserMapper;
import com.zhulin.bus.service.fileuser.FileUserServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
@ClassRolePermission(group = "fileuser", name = "文件阅览用户管理", value = "fileuser:m", menuValue = "/admin/file/user")
public class FileUserServiceImpl implements FileUserServiceI{

    @Resource
    private FileUserMapper fileUserMapper;

    @Override
    public List<FileUser> appReadList(FileUser fileUser) {

        return fileUserMapper.selectList(fileUser );
    }

    @MethodRolePermission(group = "fileuser", name = "阅览用户详细", value = "fileuser:md", groupName = "阅览用户组")
    @Override
    public FileUser appReadDetail(String id) {
        return fileUserMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "fileuser", name = "阅览用户更新", value = "fileuser:mu", groupName = "阅览用户组")
    @Transactional
    @Override
    public boolean appUpdate(FileUser fileUser) {
        return false;
    }

    @MethodRolePermission(group = "fileuser", name = "阅览用户删除", value = "fileuser:mde", groupName = "阅览用户组")
    @Transactional
    @Override
    public boolean appDelete(String id) {
        return fileUserMapper.delete(id);
    }

    @MethodRolePermission(group = "fileuser", name = "阅览用户添加", value = "fileuser:md", groupName = "阅览用户组")
    @Transactional
    @Override
    public boolean appCreate(FileUser fileUser) {

        String fileUserId = PrimaryKeyUtil.uuidPrimaryKey();
        fileUser.setFileUserId(fileUserId);

        List<FileDepartment> fileDepartments = new ArrayList<>();

        if (null != fileUser.getDepartmentIds()) {
            List<String> departmentIds = fileUser.getDepartmentIds();

            for(String departmentId : departmentIds){

                FileDepartment fileDepartment = new FileDepartment();

                fileDepartment.setDepartmentId(departmentId);
                fileDepartment.setFileUserId(fileUserId);

                fileDepartments.add(fileDepartment);
            }
        }


        List<FileDepartment> supportFileDepartments = new ArrayList<>();

        if (null != fileUser.getSupportDepartmentIds()) {
            List<String> supportDepartmentIds = fileUser.getSupportDepartmentIds();

            for(String supportDepartmentId : supportDepartmentIds){

                FileDepartment fileDepartment =  new FileDepartment();

                fileDepartment.setSupportDepartmentId(supportDepartmentId);
                fileDepartment.setFileUserId(fileUserId);

                supportFileDepartments.add(fileDepartment);
            }
        }

        List<FileType> fileTypes = new ArrayList<>();

        if (null != fileUser.getTypeIds()) {
            List<String> typeIds = fileUser.getTypeIds();

            for (String typeId : typeIds) {

                FileType fileType = new FileType();

                fileType.setFileUserId(fileUserId);
                fileType.setTypeId(typeId);

                fileTypes.add(fileType);
            }
        }

        int insertFileNum = fileUserMapper.insertFileUser(fileUser);
        if (!fileDepartments.isEmpty()) {
            int insertFileDepartmentNum = fileUserMapper.insertRaterDepartment(fileDepartments);
        }

        if (!fileTypes.isEmpty()) {
            int insertFileTypeNum = fileUserMapper.inFileType(fileTypes);
        }

        if (!supportFileDepartments.isEmpty()) {
            int insertSupportDepartmentNum =  fileUserMapper.insertSupportDepartment(supportFileDepartments);
        }

//        return (insertFileNum == 1) && (insertFileDepartmentNum == departmentIds.size()) && (insertFileTypeNum == typeIds.size());
        return insertFileNum == 1;
    }
}
