package com.zhulin.bus.mapper.demo;

import com.zhulin.bus.bean.Demo;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoMapper extends ArcMapper<Demo> {
    @Override
    List<Demo> selectList(Demo demo);

    @Override
    boolean update(Demo demo);

    @Override
    Demo selectDetail(String id);

    @Override
    boolean insert(Demo demo);

    @Override
    boolean delete(String id);
}
