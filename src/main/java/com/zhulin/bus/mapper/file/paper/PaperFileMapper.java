package com.zhulin.bus.mapper.file.paper;

import com.sun.org.apache.regexp.internal.RE;
import com.zhulin.bus.bean.Paper;
import com.zhulin.bus.bean.PaperFile;
import com.zhulin.bus.bean.PaperFileModify;
import com.zhulin.bus.mapper.file.paper.provider.SelectPaperFileProvider;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PaperFileMapper extends ArcMapper<PaperFile>{

    @SelectProvider(type = SelectPaperFileProvider.class, method = "selectPaperFile")
    @Results({
            @Result(id = true, column = "paperFileId", property = "paperFileId"),
            @Result(column = "paperId", property = "paperId"),
            @Result(column = "subjectId", property = "subjectId"),
            @Result(column = "disciplineId", property = "disciplineId"),
            @Result(column = "collegeId", property = "collegeId"),
            @Result(column = "userId", property = "userId"),
            @Result(column = "fileTypeFlag", property = "fileTypeFlag"),
            @Result(column = "paperFileCreateTime", property = "paperFileCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "paperFileName", property = "paperFileName"),
            @Result(column = "paperFileDBName", property = "paperFileDBName"),
            @Result(column = "paperFilePath", property = "paperFilePath"),
            @Result(column = "paperFileRemark", property = "paperFileRemark"),
            @Result(column = "paperName", property = "paperName"),
            @Result(column = "subjectName", property = "subjectName"),
            @Result(column = "disciplineName", property = "disciplineName"),
            @Result(column = "collegeName", property = "collegeName"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "createUserName", property = "createUserName"),
            @Result(column = "modifyUserName", property = "modifyUserName"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "modifyTime", property = "modifyTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class)
    })
    List<PaperFile> selectList(@Param("paperFile") PaperFile paperFile);

    @Insert("INSERT INTO pinggu_college_structure_file_modify (paperFileModifyId, userId, paperFileId, modifyFlag) VALUES (#{paperFileModifyId}, #{userId}, #{paperFileId}, 1)")
    boolean insertModify(PaperFileModify paperFileModify);

    @Update("UPDATE pinggu_college_structure_file SET deleteFlag=1 WHERE paperFileId=#{value}")
    boolean delete(String id);

    @Select("SELECT paperFileId, paperFileName, paperFileDBName, paperFilePath FROM pinggu_college_structure_file WHERE paperFileId=#{id}")
    @Results({
            @Result(id = true, column = "paperFileId", property = "paperFileId"),
            @Result(column = "paperFileName", property = "paperFileName"),
            @Result(column = "paperFileDBName", property = "paperFileDBName"),
            @Result(column = "paperFilePath", property = "paperFilePath")
    })
    PaperFile selectFilePath(String fileId);

    @Select("SELECT paperId, paperName FROM pinggu_college_structure_paper WHERE subjectId=#{value} AND deleteFlag=0")
    @Results({
            @Result(id = true, column = "paperId", property = "paperId"),
            @Result(column = "paperName", property = "paperName")
    })
    List<Paper> selectPaper(String subjectId);
}
