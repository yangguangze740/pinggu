package com.zhulin.bus.controller.bi.question;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Project;
import com.zhulin.bus.bean.Question;
import com.zhulin.bus.bean.bi.QuestionNumber;
import com.zhulin.bus.bean.bi.QuestionNumberBI;
import com.zhulin.bus.service.bi.question.QuestionBiServiceI;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.bus.service.element.ElementServiceI;
import com.zhulin.bus.service.project.ProjectServiceI;
import com.zhulin.framework.controller.ArcController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bi/question")
public class QuestionBiController extends ArcController<QuestionNumber>{

    @Autowired
    private QuestionBiServiceI questionBiServiceI;

    @Autowired
    private DepartmentServiceI departmentServiceI;

    @Autowired
    private ProjectServiceI projectServiceI;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(QuestionNumber questionNumber, HttpServletRequest request, Model model) {
        return "bus/bi/question/index";
    }

    @Override
    public String detail(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String query4Edit(String id, HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String update(QuestionNumber questionNumber, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @Override
    public String delete(String id, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @Override
    public String routeAdd(HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public String saveAdd(QuestionNumber questionNumber, HttpServletRequest request, Model model, RedirectAttributes message) {
        return null;
    }

    @RequestMapping(value = "/number", method = RequestMethod.GET)
    public Map<String, List<QuestionNumber>> questionNumber(QuestionNumber questionNumber, Model model, HttpServletRequest httpServletRequest){
        Map<String, List<QuestionNumber>> map = new HashMap<>();

        List<Department> departments = departmentServiceI.appReadList(new Department());
        List<Project> projects = projectServiceI.appReadList(new Project());
        List<QuestionNumberBI> elements = questionBiServiceI.readAllElement(new QuestionNumberBI());
        List<QuestionNumber> projectNames= questionBiServiceI.readProjectList(questionNumber);
        List<QuestionNumber> elementNames = questionBiServiceI.readElementList(questionNumber);

        //legend
        List<QuestionNumber> legends = new ArrayList<>();
        QuestionNumber allString = new QuestionNumber();
        allString.setName("部门总数");
        legends.add(allString);
        legends.addAll(projectNames);
        legends.addAll(elementNames);

        //部门总数List
        List<QuestionNumber> departmentNumbers = new ArrayList<>();
        QuestionNumber departmentNumber = new QuestionNumber();
        List<Integer> departmentNumberList = new ArrayList<>();

        for (Department department : departments){
            String departmentId = department.getDepartmentId();

            Integer departmentInteger = questionBiServiceI.queryDepartmentNumber(departmentId);
            departmentNumberList.add(departmentInteger);
        }

        departmentNumber.setData(departmentNumberList);
        departmentNumber.setName("部门总数");
        departmentNumber.setStack("总数");

        departmentNumbers.add(departmentNumber);

        //service List
        List<QuestionNumber> series = new ArrayList<>();
        series.add(departmentNumber);

        //各个项目问题清单数
        for (Project project : projects){
            QuestionNumber projectNumber = new QuestionNumber();

            String projectId = project.getProjectId();
            String projectName = project.getProjectName();

            List<Integer> projectIntegers = questionBiServiceI.queryProjectNumberById(projectId);

            projectNumber.setName(projectName);
            projectNumber.setStack("项目");
            projectNumber.setData(projectIntegers);

            series.add(projectNumber);
        }

        //各个要素问题清单数
        for (QuestionNumberBI element : elements){
            QuestionNumber elementNumber = new QuestionNumber();

            String elementId = element.getId();
            String elementName = element.getName();

            List<Integer> elementIntegers = questionBiServiceI.queryElementNumberById(elementId);

            elementNumber.setName(elementName);
            elementNumber.setStack("要素");
            elementNumber.setData(elementIntegers);

            series.add(elementNumber);
        }

        map.put("legends", legends);
        map.put("departmentName", departmentNumbers);
        map.put("series", series);

        return map;
    }
}
