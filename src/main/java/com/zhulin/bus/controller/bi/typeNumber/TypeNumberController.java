package com.zhulin.bus.controller.bi.typeNumber;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.DepartmentType;
import com.zhulin.bus.bean.Type;
import com.zhulin.bus.bean.bi.DepartmentTypeNumber;
import com.zhulin.bus.bean.bi.TempTypeNumber;
import com.zhulin.bus.bean.bi.TypeNumber;
import com.zhulin.bus.service.bi.typeNumber.TypeNumberServiceI;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.bus.service.type.TypeServiceI;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bi/typeNumber")
public class TypeNumberController {

    @Resource
    private TypeNumberServiceI typeNumberServiceI;

    @Resource
    private DepartmentServiceI departmentServiceI;

    @Resource
    private TypeServiceI typeServiceI;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(DepartmentTypeNumber departmentTypeNumber, Model model, HttpServletRequest request){
        return "bus/bi/typeNumber/index";
    }

    @ResponseBody
    @RequestMapping(value = "/number", method = RequestMethod.GET)
    public Map<String, List<DepartmentTypeNumber>> queryNumber(DepartmentTypeNumber departmentTypeNumber, Model model, HttpServletRequest request){
        Map<String, List<DepartmentTypeNumber>> map = new HashedMap();

        List<Department> departments = departmentServiceI.appReadList(new Department());
        List<Type> types = typeServiceI.appReadList(new Type());
        List<DepartmentTypeNumber> typeNames = new ArrayList<>();

        List<DepartmentTypeNumber> departmentNames = new ArrayList<>();
        List<DepartmentTypeNumber> numbers = new ArrayList<>();


        for (Department department : departments) {
            String departmentId = department.getDepartmentId();
            DepartmentTypeNumber queryNumber = new DepartmentTypeNumber();

            DepartmentTypeNumber departmentName = typeNumberServiceI.selectDepartmentNameById(departmentId);

            //该部门下所有类型的文件数和类型名
            List<TempTypeNumber> queryNumbers = typeNumberServiceI.selectNumber(departmentId);

            queryNumber.setTempTypeNumbers(queryNumbers);

            departmentNames.add(departmentName);
            numbers.add(queryNumber);
        }

        List<TypeNumber> typeNumbers = new ArrayList<>();

        for (Type type : types){
            TypeNumber tNumber = new TypeNumber();
            String typeName = type.getTypeName();
            int num = type.getTypeFileNumber();
            List<Integer> ints = new ArrayList<>();
            List<Integer> shouldList = new ArrayList<>();

            //已提交数据
            for (DepartmentTypeNumber tempNumber : numbers){
                List<TempTypeNumber> tempDepartmentType = tempNumber.getTempTypeNumbers();
                int isExi = 0;

                if (tempDepartmentType.size() == 0){
                    ints.add(0);
                } else {
                    for (TempTypeNumber tempTypeNumber : tempDepartmentType){
                        if (tempTypeNumber.getName().equals(typeName)){
                            isExi++;
                            ints.add(tempTypeNumber.getNumber());
                        }
                    }

                    if (isExi == 0){
                        ints.add(0);
                    }
                }

                shouldList.add(num);
            }

            //应提交数据
            DepartmentTypeNumber tempTypeName = new DepartmentTypeNumber();
            DepartmentTypeNumber temp = new DepartmentTypeNumber();
            String shouldName = typeName + "应提交";
            tempTypeName.setName(typeName);
            temp.setName(shouldName);
            typeNames.add(tempTypeName);
            typeNames.add(temp);

            tNumber.setName(typeName);
            tNumber.setNumbers(ints);

            typeNumbers.add(tNumber);

            TypeNumber shouldNumber = new TypeNumber();

            shouldNumber.setName(shouldName);
            shouldNumber.setNumbers(shouldList);

            typeNumbers.add(shouldNumber);
        }

        DepartmentTypeNumber dtNumber = new DepartmentTypeNumber();
        List<DepartmentTypeNumber> tNumbers = new ArrayList<>();

        dtNumber.setTypeNumbers(typeNumbers);
        tNumbers.add(dtNumber);

        map.put("departments", departmentNames);
        map.put("types", typeNames);
        map.put("tNumbers", tNumbers);

        return map;
    }
}
