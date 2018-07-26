package com.zhulin.bus.mapper.fileuser;

import com.zhulin.bus.bean.FileDepartment;
import com.zhulin.bus.bean.FileType;
import com.zhulin.bus.bean.FileUser;
import com.zhulin.bus.mapper.fileuser.provider.FileUserInsertProvider;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileUserMapper extends ArcMapper<FileUser> {

    @Override
    @Select("SELECT fileUserId, fileUserName, trueName, password, createUserId, deleteFlag FROM pinggu_file_user WHERE deleteFlag=0")
    @Results({
            @Result(id = true, column = "fileUserId", property = "fileUserId"),
            @Result(column = "fileUserName", property = "fileUserName"),
            @Result(column = "trueName", property = "trueName"),
            @Result(column = "password", property = "password"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "deleteFlag", property = "deleteFlag")
    })
    List<FileUser> selectList(FileUser fileUser);

    @Override
    @Select("SELECT fileUserId, fileUserName, trueName, password, createUserId, deleteFlag FROM pinggu_file_user WHERE fileUserId=#{fileUserId}")
    @Results({
            @Result(id = true, column = "fileUserId", property = "fileUserId"),
            @Result(column = "fileUserName", property = "fileUserName"),
            @Result(column = "trueName", property = "trueName"),
            @Result(column = "password", property = "password"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "deleteFlag", property = "deleteFlag")
    })
    FileUser selectDetail(String id);

    boolean update(FileUser fileUser);

    @Delete("DELETE FROM pinggu_file_user WHERE fileUserId = #{value}")
    boolean delete(String id);

    boolean insert(FileUser fileUser);

    @InsertProvider(type = FileUserInsertProvider.class, method = "insertRaterDepartments")
    int insertRaterDepartment(@Param("list") List<FileDepartment> fileDepartments);

    @Insert("INSERT INTO pinggu_file_user (fileUserId, fileUserName, trueName, password, createUserId) VALUES (#{fileUserId}, #{fileUserName}, #{trueName}, #{password}, #{createUserId})")
    int insertFileUser(FileUser fileUser);

    @InsertProvider(type = FileUserInsertProvider.class, method = "insertFileTypes")
    int inFileType(@Param("list") List<FileType> fileTypes);

    @InsertProvider(type = FileUserInsertProvider.class, method = "insertSupportDepartment")
    int insertSupportDepartment(@Param("list") List<FileDepartment> fileDepartments);
}
