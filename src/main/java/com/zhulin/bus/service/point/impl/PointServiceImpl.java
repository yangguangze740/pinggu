package com.zhulin.bus.service.point.impl;

import com.zhulin.bus.bean.DutyDepartment;
import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Point;
import com.zhulin.bus.mapper.point.PointMapper;
import com.zhulin.bus.service.point.PointServiceI;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointServiceImpl implements PointServiceI{
    @Autowired
    private PointMapper pointMapper;

    @MethodRolePermission(group = "supportFile", name = "审查要点查看", value = "point:fr", groupName = "审查要点管理组")
    @Override
    public List<Point> appReadList(Point point) {
        return pointMapper.selectList(point);
    }

    @MethodRolePermission(group = "supportFile", name = "审查要点详细", value = "point:fd", groupName = "审查要点管理组")
    @Override
    public Point appReadDetail(String id) {
        return pointMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "supportFile", name = "审查要点编辑", value = "point:fe", groupName = "审查要点管理组")
    @Transactional
    @Override
    public boolean appUpdate(Point point) {
        String pointId = point.getPointId();

        //更新用户信息
        int editpoint = pointMapper.updatePoint(point);

        List<String> dutyDepartmentIds = point.getDutyDepartmentIds();

        if(dutyDepartmentIds == null || dutyDepartmentIds.isEmpty()){
            return (editpoint > 0);
        }else {
            //删除原先责任部门
            int deleteDutyDepartmentNum = pointMapper.deleteDutyDepartment(pointId);

            List<DutyDepartment> dutyDepartments = new ArrayList<>();
            for (String id : dutyDepartmentIds) {
                DutyDepartment dutyDepartment = new DutyDepartment();

                dutyDepartment.setDutyDepartmentId(id);
                dutyDepartment.setDutyDepartmentId(pointId);

                dutyDepartments.add(dutyDepartment);
            }
            //添加要点
            int insertDutyDepartmentNum = pointMapper.insertDutyDepartment(dutyDepartments);

            return (deleteDutyDepartmentNum >= 0)&&(editpoint >= 0)&&(insertDutyDepartmentNum == dutyDepartmentIds.size());

        }
    }

    @MethodRolePermission(group = "supportFile", name = "审查要点删除", value = "point:fd", groupName = "审查要点管理组")
    @Transactional
    @Override
    public boolean appDelete(String id) {
        //删除原来关联的责任部门
        int deleteDutyDepartment = pointMapper.deleteDutyDepartment(id);
        //删除要点
        int pointDelete = pointMapper.pointDelete(id);

        return (deleteDutyDepartment >= 0)  && (pointDelete >= 0);
    }

    @MethodRolePermission(group = "supportFile", name = "审查要点添加", value = "point:fc", groupName = "审查要点管理组")
    @Transactional
    @Override
    public boolean appCreate(Point point) {
        String pointId = PrimaryKeyUtil.uuidPrimaryKey();
        point.setPointId(pointId);

        List<DutyDepartment> dutyDepartments = new ArrayList<>();
        List<String> dutyDepartmentIds = point.getDutyDepartmentIds();

        for (String dutyDepartmentId : dutyDepartmentIds) {
            DutyDepartment dutyDepartment = new DutyDepartment();

            dutyDepartment.setPointId(pointId);
            dutyDepartment.setDutyDepartmentId(dutyDepartmentId);

            dutyDepartments.add(dutyDepartment);
        }

        int insertPoint = pointMapper.insertPoint(point);
        int insertDutyDepartment = pointMapper.insertDutyDepartment(dutyDepartments);

        return ((insertPoint == 1) && (insertDutyDepartment == dutyDepartmentIds.size()));
    }

    @Override
    public List<Element> queryElementByProjectId(String projectId) {
        return pointMapper.selectElementByProject(projectId);
    }
}
