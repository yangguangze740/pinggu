package com.zhulin.bus.mapper.file.paper.provider;

import com.google.common.base.Strings;
import com.zhulin.bus.bean.PaperFile;

import java.util.Map;

public class SelectPaperFileProvider {
    public String selectPaperFile(Map map){
        PaperFile paperFile = (PaperFile) map.get("paperFile");

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT paperFileId, F.paperId, F.subjectId, F.disciplineId, F.collegeId, F.userId, fileTypeFlag, paperFileCreateTime, paperFileName, paperFileDBName, paperFilePath, paperFileRemark, P.paperName, S.subjectName, D.disciplineName, C.collegeName, U.userName FROM pinggu_college_structure_file F LEFT JOIN pinggu_college_structure_paper P ON P.paperId=F.paperId LEFT JOIN pinggu_college_structure_subject S ON S.subjectId=F.subjectId LEFT JOIN pinggu_college_structure_discipline D ON D.disciplineId=F.disciplineId LEFT JOIN pinggu_college_structure_college C ON C.collegeId=F.collegeId LEFT JOIN pinggu_general_user U ON U.userId=F.userId WHERE F.deleteFlag=0 ");

        String collegeId = paperFile.getCollegeId();
        if (!Strings.isNullOrEmpty(collegeId)){
            builder.append(" AND F.collegeId=#{paperFile.collegeId}");
        }

        String disciplineId = paperFile.getDisciplineId();
        if (!Strings.isNullOrEmpty(disciplineId)) {
            builder.append(" AND F.disciplineId=#{paperFile.disciplineId}");
        }

        String subjectId = paperFile.getSubjectId();
        if (!Strings.isNullOrEmpty(subjectId)) {
            builder.append(" AND F.subjectId=#{paperFile.subjectId}");
        }

        String paperId = paperFile.getPaperId();
        if (!Strings.isNullOrEmpty(paperId)) {
            builder.append(" AND F.paperId=#{paperFile.paperId}");
        }

        return builder.toString();
    }
}
