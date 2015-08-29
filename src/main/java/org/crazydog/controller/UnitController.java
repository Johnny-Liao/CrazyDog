package org.crazydog.controller;

import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.crazydog.serviceI.impl.UnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by never on 2015/8/28.
 */
@Controller
public class UnitController {

    @Autowired
    @Qualifier("unitServiceImpl")
    private UnitServiceImpl unitService;


    /**
     * 映射显示所有单位的页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/unit")
    public String unitManage(HttpServletRequest request, @RequestParam("page") String page) {
        List<UnitEntity> unitEntities = unitService.getAllEntities();

        request.setAttribute("unitEntities", unitEntities);

        String unitId = request.getParameter("unitId");
        if (unitId != null) {
            //取出unitEntity
            UnitEntity unitEntity = unitService.getEntity(Integer.valueOf(unitId));
            List<DepartmentEntity> departmentEntities = unitService.getDepartmentEntitiesByUnit(unitEntity);
            request.setAttribute("unitEntity", unitEntity);
            request.setAttribute("departmentEntities", departmentEntities);
        }

        return page;
    }

    /**
     * 响应删除某个单位的操作
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/unit", params = "action=unitDelete")
    public String deleteUnit(HttpServletRequest request) {
        String unitId = request.getParameter("unitId");
        UnitEntity unitEntity = new UnitEntity();
        if (unitId != null) {
            unitEntity.setId(Integer.valueOf(unitId));
        }
        unitService.deleteEntity(unitEntity);
        //重新加载一次
        return "unitManage";
    }

    /**
     * 响应修改某个单位的操作
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/unit", params = "action=unitModify")
    public String modifyUnit(HttpServletRequest request) {
        String unitId = request.getParameter("unitId");
        UnitEntity unitEntity = new UnitEntity();
        if (unitId != null) {
            unitEntity.setId(Integer.valueOf(unitId));
        }
//        unitService.deleteEntity(unitEntity);
        //重新加载一次
        return "unitManage";
    }
}
