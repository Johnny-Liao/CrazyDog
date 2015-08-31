package org.crazydog.controller;

import org.crazydog.daoI.impl.DepartmentdaoImpl;
import org.crazydog.domain.*;
import org.crazydog.serviceI.impl.EmployeeServiceImpl;
import org.crazydog.serviceI.impl.PositionChangeServiceImpl;
import org.crazydog.serviceI.impl.UnitServiceImpl;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by johnny on 15-8-30.
 */
@Controller
@RequestMapping("/dispatch")
public class DispatchController {

    @Autowired
    private PositionChangeServiceImpl positionChangeService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private UnitServiceImpl unitService;

    @Autowired
    private DepartmentdaoImpl departmentdao;


    /**
     * deal with the dispatch position.
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addDispatchInfo(HttpServletRequest request) {

        // get the parameters
        String empid = request.getParameter("empid");
        String date = request.getParameter("date");
        // only need the id from the front page.
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

        // set id.
        positionChangeEntity.setId(Integer.parseInt(empid));

        // get the employee
        EmployeeEntity employeeEntity = employeeService.getEntity(Integer.parseInt(empid));

        positionChangeEntity.setEmployeeEntity(employeeEntity);

        // get the unit and dept from employee
        UnitEntity beforUnit = employeeEntity.getUnitEntity();
        DepartmentEntity befordept =employeeEntity.getDepartmentEntity();

        positionChangeEntity.setUnitByBeforUnitId(beforUnit);
        positionChangeEntity.setDepartmentByBeforDeptId(befordept);
// we should do it simple.
//        unitService.getUnitByName()
        List<UnitEntity> afterUnits = unitService.getUnitByName(afterunit);//getEntity(Integer.parseInt(afterunitid));
        UnitEntity afterUnit = afterUnits.get(0);
        DepartmentEntity afterDept = departmentdao.getDepartmentByName(afterdept);//.getEntity(Integer.parseInt(afterdeptid));


        positionChangeEntity.setUnitByAfterUnitId(afterUnit);
        positionChangeEntity.setDepartmentByAfterDeptId(afterDept);
System.out.println("AfterUnit:============" + afterUnit);
System.out.println("AfterDept:============" + afterDept);



        positionChangeEntity.setChangeTime(sqldate);
        positionChangeEntity.setChangeCause(reason);




        positionChangeService.modifyEntity(positionChangeEntity);


        return "redirect:employeePage/1";
    }



    /**
     * 响应删除dispatch info
     *
     * @return
     */
    @RequestMapping(params = "action=dispatchDelete")
    public String dispatchDelete(HttpServletRequest request, @RequestParam("dispatchId") int dispatchId) {

        PositionChangeEntity positionChangeEntity = new PositionChangeEntity();
        positionChangeEntity.setId(dispatchId);

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(Integer.parseInt(request.getParameter("empid")));
        positionChangeEntity.setEmployeeEntity(employeeEntity);



        List<UnitEntity> unitEntityBefors =  unitService.getUnitByName(request.getParameter("unitnameb"));
        UnitEntity unitEntityBefor = unitEntityBefors.get(0);
        positionChangeEntity.setUnitByBeforUnitId(unitEntityBefor);

        List<UnitEntity> unitEntityAfters =  unitService.getUnitByName(request.getParameter("unitnameb"));
        UnitEntity unitEntityAfter = unitEntityAfters.get(0);
        positionChangeEntity.setUnitByAfterUnitId(unitEntityAfter);


        DepartmentEntity departmentEntityBefor = departmentdao.getDepartmentByName(request.getParameter("deptnameb"));
        DepartmentEntity departmentEntityAfter =  departmentdao.getDepartmentByName(request.getParameter("deptnamea"));
        positionChangeEntity.setDepartmentByBeforDeptId(departmentEntityBefor);
        positionChangeEntity.setDepartmentByAfterDeptId(departmentEntityAfter);




        positionChangeService.deleteEntity(positionChangeEntity);

        return "redirect:/employeePage?action=getPositionChange";
    }
}
