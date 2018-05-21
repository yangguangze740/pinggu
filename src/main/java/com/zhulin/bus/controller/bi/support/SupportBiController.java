package com.zhulin.bus.controller.bi.support;

import com.zhulin.bus.service.bi.Support.SupportBiServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bi/support")
public class SupportBiController {

    @Autowired
    private SupportBiServiceI supportBiService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(){
        return "bus/bi/typeNumber/index";
    }


}
