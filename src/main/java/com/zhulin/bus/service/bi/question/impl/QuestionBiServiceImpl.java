package com.zhulin.bus.service.bi.question.impl;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Project;
import com.zhulin.bus.bean.Question;
import com.zhulin.bus.bean.bi.QuestionNumber;
import com.zhulin.bus.bean.bi.QuestionNumberBI;
import com.zhulin.bus.mapper.bi.question.QuestionBiMapper;
import com.zhulin.bus.mapper.department.DepartmentMapper;
import com.zhulin.bus.mapper.element.ElementMapper;
import com.zhulin.bus.mapper.project.ProjectMapper;
import com.zhulin.bus.service.bi.question.QuestionBiServiceI;
import com.zhulin.common.def.Constants;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuestionBiServiceImpl implements QuestionBiServiceI{

    @Autowired
    private QuestionBiMapper questionBiMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ElementMapper elementMapper;

    @Override
    public List<Question> appReadList(Question question) {
        return null;
    }

    @Override
    public Question appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(Question question) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return false;
    }

    @Override
    public boolean appCreate(Question question) {
        return false;
    }

    @Override
    public Map<String, Object> queryData(QuestionNumber questionNumber) {
        Map<String, Object> map = new HashMap<>();

        List<Department> departments = departmentMapper.selectList(new Department());
        List<Element> elements = elementMapper.selectList(new Element());
        List<Project> projects = projectMapper.selectList(new Project());

        //xAix
        map.put("departments", departments.stream().map(Department::getDepartmentName).collect(Collectors.toList()));

        //legend
        List<String> types = new ArrayList<>();

        types.add(Constants.BI_DEPARTMENT_SUPPORT_FILE_FILE_SUM);
        types.addAll(projects.stream().map(Project::getProjectName).collect(Collectors.toList()));
        types.addAll(elements.stream().map(Element::getElementName).collect(Collectors.toList()));

        map.put("types", types);

        //departmentNumberList
        QuestionNumber departmentNumber = new QuestionNumber();

        departmentNumber.setName(Constants.BI_DEPARTMENT_SUPPORT_FILE_FILE_SUM);
        List<Integer> departmentNumbers = questionBiMapper.selectDepartmentNumberById();
        departmentNumber.setStack("总数");
        departmentNumber.setData(departmentNumbers);

        map.put("departmentNumber", departmentNumber);

        //projectNumberList
        List<QuestionNumber> projectNumberList = new ArrayList<>();

        for (Project project : projects){
            QuestionNumber projectNumber = new QuestionNumber();

            projectNumber.setName(project.getProjectName());
            projectNumber.setStack("项目");

            List<Integer> projectNumbers = questionBiMapper.selectProjectNumberById(project.getProjectId());
            projectNumber.setData(projectNumbers);

            projectNumberList.add(projectNumber);
        }

        //elementNumberList
        List<QuestionNumber> elementNumberList = new ArrayList<>();

        for (Element element : elements){
            QuestionNumber elementNumber = new QuestionNumber();

            elementNumber.setName(element.getElementName());
            elementNumber.setStack("要素");

            List<Integer> elementNumbers = questionBiMapper.selectElementNumberById(element.getElementId());
            elementNumber.setData(elementNumbers);

            elementNumberList.add(elementNumber);
        }

        map.put("projectNumbers", projectNumberList);
        map.put("elementNumbers", elementNumberList);

        return map;
    }

}
