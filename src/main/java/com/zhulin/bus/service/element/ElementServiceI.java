package com.zhulin.bus.service.element;


import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Point;
import com.zhulin.framework.service.ArcService;

import java.util.List;

public interface ElementServiceI extends ArcService<Element>{
    List<Element> appReadProjectElements(String projectId);
    List<Point> queryPointByElementId(String elementId);
}
