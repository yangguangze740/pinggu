package com.zhulin.bus.service.file.raterFile;

import com.zhulin.bus.bean.RaterFile;
import com.zhulin.bus.bean.RaterFileModify;
import com.zhulin.framework.service.ArcService;

public interface RaterFileServiceI extends ArcService<RaterFile>{
    RaterFile readRaterFileFullPathFile(String fileId);

    boolean insertModify(RaterFileModify raterFileModify);
}
