package org.crazydog.controller;

import org.crazydog.serviceI.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by johnny on 15-8-27.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    @Qualifier(value = "employeeServiceImpl")
    private BaseService employeeService;

    @Autowired
    @Qualifier(value = "resumeServiceImpl")
    private BaseService resumeService;

 /*   @Autowired
    @Qualifier(value = "departmentServiceImpl")
    private BaseService departmentService;*/

    @Autowired
    @Qualifier(value = "unitServiceImpl")
    private BaseService unitService;


    // eg : .../employee?pages=1
    // 处理pages参数，显示相应页数的所有人员信息
    @RequestMapping(method = RequestMethod.GET, params = "pages")
    public String getEmployeeByPages(@RequestParam("pages") String page, Model model) {
        model.addAttribute("employees", employeeService.getAllEntities());
        model.addAttribute("resumes", resumeService.getAllEntities());
//        model.addAttribute("departments", resumeService.getAllEntities());
        model.addAttribute("units", unitService.getAllEntities());
        return page;
    }

}
