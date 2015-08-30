package org.crazydog.controller;

import com.sun.deploy.net.HttpRequest;
import org.crazydog.serviceI.BaseService;
import org.crazydog.serviceI.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by johnny on 15-8-27.
 */
@Controller
@RequestMapping("/employeePage")
public class EmployeeController {

    @Autowired
    @Qualifier(value = "employeeServiceImpl")
    private EmployeeServiceImpl employeeService;


    // eg : .../employee?pages=1
    // 处理pages参数，显示相应页数的所有人员信息
    @RequestMapping(method = RequestMethod.GET, value = "/{page}")
    public String getEmployeeByPages(HttpServletRequest request, @PathVariable String page) {
//        request.setAttribute("employees", employeeService.getAllEntities());
//        System.out.println(page + "===========================");
//        int a = Integer.parseInt(page);
//        System.out.println(a + "-----------------------");
        request.setAttribute("employeesList", employeeService.getEmployeeByPage(Integer.parseInt(page)));
        return "employeePage";
    }

}
