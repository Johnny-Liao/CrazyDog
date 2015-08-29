package org.crazydog.controller;

import org.crazydog.domain.tmp.UnitEntity;
import org.crazydog.serviceI.impl.UnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @RequestMapping(value = "/unit", params = "page=unitManage")
    public String unitManage(HttpServletRequest request) {
        System.out.println(unitService.getClass());
        List<UnitEntity> unitEntities = unitService.getAllEntities();

        request.setAttribute("unitEntities", unitEntities);

        return "unitManage";
    }
}
