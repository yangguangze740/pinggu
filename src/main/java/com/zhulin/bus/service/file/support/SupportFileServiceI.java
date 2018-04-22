package com.zhulin.bus.service.file.support;

import com.zhulin.bus.bean.RaterFile;
import com.zhulin.bus.bean.SupportFile;
import com.zhulin.bus.bean.SupportFileModify;
import com.zhulin.framework.mapper.ArcMapper;
import com.zhulin.framework.service.ArcService;

public interface SupportFileServiceI extends ArcService<SupportFile>{
    boolean insertModify(SupportFileModify supportFileModify);

    SupportFile readFileFullPathFile(String fileId);
}
