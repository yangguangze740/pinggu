package com.zhulin.bus.service.bi.support.impl;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Project;
import com.zhulin.bus.bean.bi.DepartmentNumber;
import com.zhulin.bus.bean.bi.ElementNumber;
import com.zhulin.bus.bean.bi.ProjectNumber;
import com.zhulin.bus.bean.bi.SupportFileNumber;
import com.zhulin.bus.mapper.bi.support.DepartmentSupportFileBiMapper;
import com.zhulin.bus.mapper.department.DepartmentMapper;
import com.zhulin.bus.mapper.element.ElementMapper;
import com.zhulin.bus.mapper.project.ProjectMapper;
import com.zhulin.bus.service.bi.support.DepartmentSupportFileBiServiceI;
import com.zhulin.common.def.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentSupportFileBiServiceImpl implements DepartmentSupportFileBiServiceI {

    @Autowired
    private DepartmentSupportFileBiMapper departmentSupportFileBiMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ElementMapper elementMapper;

    @Override
    public Map<String, Object> readDepartmentSupportFileBarBi() {

        List<Department> departments = departmentMapper.selectList(new Department());
        List<Project> projects = projectMapper.selectList(new Project());
        List<Element> elements = elementMapper.selectList(new Element());

        List<ProjectNumber> projectNumberList = new ArrayList<>();
        List<ElementNumber> elementNumberList = new ArrayList<>();

        // 总数
        DepartmentNumber departmentNumber = new DepartmentNumber();
        departmentNumber.setName(Constants.BI_DEPARTMENT_SUPPORT_FILE_FILE_SUM);
        List<SupportFileNumber> totalFileNumber = departmentSupportFileBiMapper.selectDepartmentFileNumber();
        departmentNumber.setSupportFileNumbers(totalFileNumber);

        // 项目分类总数
        for (Project project : projects) {
            ProjectNumber projectFileNumber = new ProjectNumber();

            projectFileNumber.setName(project.getProjectName());

            List<SupportFileNumber> projectNumber = departmentSupportFileBiMapper.selectProjectFileNumber(project.getProjectId());
            projectFileNumber.setSupportFileNumbers(projectNumber);

            projectNumberList.add(projectFileNumber);
        }

        // 要素分类总数
        for (Element element : elements) {
            ElementNumber elementFileNumber = new ElementNumber();

            elementFileNumber.setName(element.getElementName());

            List<SupportFileNumber> elementNumber = departmentSupportFileBiMapper.selectElementNumber(element.getElementId());
            elementFileNumber.setSupportFileNumbers(elementNumber);

            elementNumberList.add(elementFileNumber);
        }

        Map<String, Object> mapData = new HashMap<>();

        mapData.put("departments", departments.stream().map(Department::getDepartmentName).collect(Collectors.toList()));

        List<String> types = new ArrayList<>();

        types.add(Constants.BI_DEPARTMENT_SUPPORT_FILE_FILE_SUM);
        types.addAll(projects.stream().map(Project::getProjectName).collect(Collectors.toList()));
        types.addAll(elements.stream().map(Element::getElementName).collect(Collectors.toList()));

        mapData.put("types", types);

        mapData.put("departmentNumber", departmentNumber);
        mapData.put("projectNumbers", projectNumberList);
        mapData.put("elementNumbers", elementNumberList);

        return mapData;
    }
}
