package org.crazydog.controller;

import org.crazydog.domain.EmployeeEntity;
import org.crazydog.domain.PositionChangeEntity;
import org.crazydog.domain.PositionLeaveEntity;
import org.crazydog.serviceI.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by johnny on 15-8-27.
 */
@Controller
@RequestMapping("/employeePage")
public class EmployeeController {

    @Autowired
//    @Qualifier("employeeServiceImpl")
    private EmployeeServiceImpl employeeService;


    // eg : .../employee?pages=1
    // 处理pages参数，显示相应页数的所有人员信息
    @RequestMapping(method = RequestMethod.GET, value = "/{page}")
    public String getEmployeeByPages(HttpServletRequest request, @PathVariable String page) {
        request.setAttribute("employeesList", employeeService.getEmployeeByPage(Integer.parseInt(page)));
        request.setAttribute("page", page);
        return "employeePage";
    }


    /**
     * 跳转到离职人员处理
     * @return
     */
    @RequestMapping(params = "leave", method = RequestMethod.GET)
    public  String dealWithLeave(HttpServletRequest request,@RequestParam("empid")String empid, @RequestParam("empname")String empname) {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String needDate = format.format(date);

        request.setAttribute("empid", empid);
        request.setAttribute("empname", empname);
        request.setAttribute("date", needDate);
        return "leave";
    }

    /**
     * 跳转到调岗人员处理
     * @return
     */
    @RequestMapping(params = "dispatch", method = RequestMethod.GET)
    public  String dealWithDispatch(HttpServletRequest request) {

        // just get the emp id
        String empid = request.getParameter("empid");
System.out.println(empid + "========================================");

        // get the employee from the database
        EmployeeEntity employeeEntity = employeeService.getEntity(Integer.parseInt(empid));

System.out.println(employeeEntity + "========================================");

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String needDate = format.format(date);

        request.setAttribute("emp", employeeEntity);
        request.setAttribute("date", needDate);
        return "dispatch";
    }

    /**
     * 获取所有的离职员工的信息
     *
     * @param request
     * @return
     */
    @RequestMapping(params = "action=getOffLine")
    public String getPositionOffLines(HttpServletRequest request) {
        List<PositionLeaveEntity> positionLeaveEntities = employeeService.getAllPositionLeaveEntities();

        request.setAttribute("positionLeaveEntities", positionLeaveEntities);

        return "getOffLine";
    }

    @RequestMapping(params = "action=getPositionChange")
    public String getPositionChanges(HttpServletRequest request) {
        List<PositionChangeEntity> positionChangeEntities = employeeService.getAllPositionChangeEntities();

        request.setAttribute("positionChangeEntities", positionChangeEntities);

        return "getPositionChange";
    }
}
