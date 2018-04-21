package com.zhulin.bus.service.point;


import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Point;
import com.zhulin.framework.service.ArcService;

import java.util.List;

public interface PointServiceI extends ArcService<Point>{
    List<Element> queryElementByProjectId(String projectId);
}
