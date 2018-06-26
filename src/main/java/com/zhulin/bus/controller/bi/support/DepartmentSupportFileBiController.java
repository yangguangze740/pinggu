package com.zhulin.bus.controller.bi.support;

import com.zhulin.bus.service.bi.support.DepartmentSupportFileBiServiceI;
import com.zhulin.bus.service.department.DepartmentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/bi/support")
public class DepartmentSupportFileBiController {

    @Resource
    private DepartmentSupportFileBiServiceI supportBiService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(){
        return "bus/bi/support/index";
    }

    @ResponseBody
    @RequestMapping("/department")
    public Map<String, Object> supportFileNumber(){

        Map<String, Object> mapData = supportBiService.readDepartmentSupportFileBarBi();

        return mapData;
    }
}
