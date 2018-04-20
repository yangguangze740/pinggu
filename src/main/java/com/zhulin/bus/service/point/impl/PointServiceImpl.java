package com.zhulin.bus.service.point.impl;

import com.zhulin.bus.bean.Point;
import com.zhulin.bus.service.point.PointServiceI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements PointServiceI{
    @Override
    public List<Point> appReadList(Point point) {
        return null;
    }

    @Override
    public Point appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(Point point) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return false;
    }

    @Override
    public boolean appCreate(Point point) {
        return false;
    }
}
