package org.crazydog.controller;

import org.crazydog.domain.EmployeeEntity;
import org.crazydog.domain.PositionChangeEntity;
import org.crazydog.serviceI.impl.PositionChangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by johnny on 15-8-30.
 */
@Controller
@RequestMapping("/dispatch")
public class DispatchController {

    @Autowired
    private PositionChangeServiceImpl positionChangeService;

    @RequestMapping(method = RequestMethod.POST)
    public String addLeaveInfo(HttpServletRequest request) {

        // get the parameters
        String empid = request.getParameter("empid");
        String empname = request.getParameter("empname");
        String unit = request.getParameter("unit");
        String dept = request.getParameter("dept");
        String date = request.getParameter("date");
        String afterunit = request.getParameter("afterunit");
        String afterdept = request.getParameter("afterdept");
        String reason = request.getParameter("reason");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utildate = null;
        try {
            utildate = (java.util.Date) format.parse(date);
        } catch (ParseException e) {
            System.out.println("Format date exception!");
        }
        java.sql.Date sqldate = new java.sql.Date(utildate.getTime());


        PositionChangeEntity positionChangeEntity = new PositionChangeEntity();

        // set employee id and name.
        positionChangeEntity.setId(Integer.parseInt(empid));
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(Integer.parseInt(empid));
        positionChangeEntity.setEmployeeEntity(employeeEntity);

        // not set
        /*String unit = request.getParameter("unit");
        String dept = request.getParameter("dept");
        String date = request.getParameter("date");
        String afterunit = request.getParameter("afterunit");
        String afterdept = request.getParameter("afterdept");
        String reason = request.getParameter("reason");*/

        return "redirect:employeePage/1";
    }
}
