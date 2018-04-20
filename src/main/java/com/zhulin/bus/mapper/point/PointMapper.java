package com.zhulin.bus.mapper.point;


import com.zhulin.bus.bean.Point;
import com.zhulin.framework.mapper.ArcMapper;

import java.util.List;

public interface PointMapper extends ArcMapper<Point>{
    @Override
    List<Point> selectList(Point point);

    @Override
    boolean update(Point point);

    @Override
    Point selectDetail(String id);

    @Override
    boolean insert(Point point);

    @Override
    boolean delete(String id);
}
