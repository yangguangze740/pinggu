package com.zhulin.bus.service.file.paper;

import com.zhulin.bus.bean.Paper;
import com.zhulin.bus.bean.PaperFile;
import com.zhulin.bus.bean.PaperFileModify;
import com.zhulin.framework.service.ArcService;

import java.util.List;

public interface PaperFileServiceI extends ArcService<PaperFile>{
    boolean insertModify(PaperFileModify paperFileModify);


    PaperFile readPaperFileFullPathFile(String fileId);

    List<Paper> queryPaperBySubjectId(String subjectId);
}
