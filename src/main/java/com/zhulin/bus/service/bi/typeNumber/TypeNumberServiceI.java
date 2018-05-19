package com.zhulin.bus.service.bi.typeNumber;

import com.zhulin.bus.bean.Type;
import com.zhulin.bus.bean.bi.DepartmentTypeNumber;
import com.zhulin.bus.bean.bi.TempTypeNumber;
import com.zhulin.bus.bean.bi.TypeNumber;
import com.zhulin.bus.mapper.bi.typeNumber.TypeNumberMapperI;
import com.zhulin.framework.service.ArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface TypeNumberServiceI extends ArcService<DepartmentTypeNumber>{
    List<TempTypeNumber> selectNumber(String departmentId);

    List<DepartmentTypeNumber> selectAllDepartment();


    DepartmentTypeNumber selectDepartmentNameById(String departmentId);

    List<DepartmentTypeNumber> selectTypeName(DepartmentTypeNumber departmentTypeNumber);
}
