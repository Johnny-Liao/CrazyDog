package org.crazydog.controller;

import org.crazydog.domain.ContractEntity;
import org.crazydog.serviceI.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by never on 2015/8/28.
 */
@Controller
public class ContractController {
    @Autowired
    private ContractServiceImpl contractService;

    @RequestMapping(value = "/contract", params = "page=unitManage")
    public String contractChange(HttpServletRequest request) {
        List<ContractEntity> contractEntities = contractService.getAllEntities();
        request.setAttribute("contractEntities", contractEntities);
        return "contractExtension";
    }
}
