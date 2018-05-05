package com.zhulin.bus.service.discipline.impl;

import com.zhulin.bus.bean.Discipline;
import com.zhulin.bus.mapper.discipline.DisciplineMapper;
import com.zhulin.bus.service.discipline.DisciplineServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineServiceI{

    @Autowired
    private DisciplineMapper disciplineMapper;

    @Override
    public List<Discipline> appReadList(Discipline discipline) {
        return disciplineMapper.selectList(discipline);
    }

    @Override
    public Discipline appReadDetail(String id) {
        return disciplineMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(Discipline discipline) {
        return disciplineMapper.update(discipline);
    }

    @Override
    public boolean appDelete(String id) {
        return disciplineMapper.delete(id);
    }

    @Override
    public boolean appCreate(Discipline discipline) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        discipline.setDisciplineId(id);

        return disciplineMapper.insert(discipline);
    }
}
