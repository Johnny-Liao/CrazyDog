package org.crazydog.controller;

import org.crazydog.domain.PositionLeaveEntity;
import org.crazydog.domain.UnitEntity;
import org.crazydog.serviceI.impl.searchmodel.PositionLeaveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by johnny on 15-8-30.
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private PositionLeaveServiceImpl positionLeaveService;

    @RequestMapping(method = RequestMethod.POST)
    public String addLeaveInfo(HttpServletRequest request) {
        String empid = request.getParameter("empid");
        String empname = request.getParameter("empname");
        String date = request.getParameter("date");
        String reason = request.getParameter("reason");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utildate = null;
        try {
            utildate = (java.util.Date) format.parse(date);
        } catch (ParseException e) {
            System.out.println("Format date exception!");
        }
        java.sql.Date sqldate = new java.sql.Date(utildate.getTime());

        PositionLeaveEntity positionLeaveEntity = new PositionLeaveEntity();
        positionLeaveEntity.setId(Integer.parseInt(empid));
        positionLeaveEntity.setEmpCode(Integer.parseInt(empid));
        positionLeaveEntity.setName(empname);
        positionLeaveEntity.setLeaveDate(sqldate);
        positionLeaveEntity.setLeaveComment(reason);

        positionLeaveService.modifyEntity(positionLeaveEntity);
        return "redirect:employeePage/1";
    }

    /**
     * 响应删除某个离职操作
     *
     * @return
     */
    @RequestMapping(params = "action=leaveDelete")
    public String deleteUnit(HttpServletRequest request, @RequestParam("leaveId") int leaveId) {

        PositionLeaveEntity positionLeaveEntity = new PositionLeaveEntity();
        positionLeaveEntity.setId(leaveId);
        positionLeaveService.deleteEntity(positionLeaveEntity);

        return "redirect:/employeePage?action=getOffLine";
    }

}
