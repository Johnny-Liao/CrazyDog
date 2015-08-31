package org.crazydog.controller;

import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.crazydog.serviceI.impl.UnitServiceImpl;
import org.crazydog.serviceI.impl.searchmodel.UnitSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 部门和单位的页面响应有本类负责
 * Created by never on 2015/8/28.
 */
@Controller
public class UnitController {

    @Autowired
    @Qualifier("unitServiceImpl")
    private UnitServiceImpl unitService;

    /**
     * 将所有的单位都显示出来，因为服务单位绝对不是很多，所以一次性取出，没必要做分页
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/unit", params = "action=getAll")
    public String getAllUnits(HttpServletRequest request) {

        List<UnitEntity> unitEntities = unitService.getAllEntities();

        request.setAttribute("unitEntities", unitEntities);

        //将这页面需要的信息填充完毕之后跳转到showAllUnits界面
        return "showAllUnits";
    }

    /**
     * 添加单位
     * <p>
     * 从客户端传递过来的参数必须同时拥有单位编码和单位名称
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/unit", params = "action=addUnit")
    public String addUnit(HttpServletRequest request) {

        //getParameterMap方法返回的是Map<String, String[]>
        //这种类型的map因为很有可能像selector这样的空间含有多值

        @SuppressWarnings("unchecked")
        Map<String, String[]> map = request.getParameterMap();
        Set<String> set = map.keySet();
        List<UnitEntity> list = new ArrayList<UnitEntity>(map.size() - 1);
        //因为从前端传来的参数一般都是成对的，在构建下面的UnitEntity也必须成对
        //所以事先讲这个参数去除
        if (set.contains("action"))
            set.remove("action");

        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            String key1 = iterator.next();
            String key2 = iterator.next();
            UnitEntity unitEntity = new UnitEntity();

            //将含有unit_code、unit_name的参数取出填充
            if (key1.contains("unit_code"))
                unitEntity.setUnitCode(request.getParameter(key1));
            else if (key2.contains("unit_code"))
                unitEntity.setUnitCode(request.getParameter(key2));
            if (key1.contains("unit_name"))
                unitEntity.setUnitName(request.getParameter(key1));
            else if (key2.contains("unit_name"))
                unitEntity.setUnitName(request.getParameter(key2));

            list.add(unitEntity);
        }

        for (UnitEntity unitEntity : list)
            unitService.addEntity(unitEntity);

        //重新填充页面并返回到显示所有的单位的页面
        return getAllUnits(request);
    }

    /**
     * 显示某个单位下所有的部门
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/unit", params = "action=showAllDepts")
    public String modifyUnit(HttpServletRequest request, @RequestParam("unitId") int unitId) {

        UnitEntity unitEntity = unitService.getEntity(unitId);
        List<DepartmentEntity> departmentEntities = unitService.getDepartmentEntitiesByUnit(unitEntity);
        request.setAttribute("unitEntity", unitEntity);
        request.setAttribute("departmentEntities", departmentEntities);

        return "showAllDepts";
    }

    /**
     * 响应删除某个单位的操作
     *
     * @return
     */
    @RequestMapping(value = "/unit", params = "action=unitDelete")
    public String deleteUnit(HttpServletRequest request, @RequestParam("unitId") int unitId) {

        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(unitId);
        unitService.deleteEntity(unitEntity);

        //删除单位之后在重新返回到显示所有的单位的界面
        return getAllUnits(request);
    }

    /**
     * 响应高级搜索的请求
     *
     * @param request
     * @param unitCode
     * @param unitName
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/unit", params = "action=search")
    public String advanceSearch(HttpServletRequest request, @RequestParam("unitCode") String unitCode, @RequestParam("unitName") String unitName) throws UnsupportedEncodingException {

        //有时间完善一下这里的unitCode的不区分大小写的功能
        if ("".equals(unitCode) || "服务单位编码".equals(unitCode))
            unitCode = null;
        if ("".equals(unitName) || "服务单位名称".equals(unitName))
            unitName = null;

        UnitSearchModel model = new UnitSearchModel(unitCode, unitName);
        List<UnitEntity> unitEntities = unitService.advanceSearch(model);

        request.setAttribute("unitEntities", unitEntities);
        return "showAllUnits";
    }

    /**
     * 给某个单位添加部门
     *
     * @param request
     * @param unitId
     * @return
     */
    @RequestMapping(value = "/unit", params = "action=addDepts")
    public String addDepartMents(HttpServletRequest request, @RequestParam("unitId") int unitId) {

        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(unitId);

        @SuppressWarnings("unchecked")
        Map<String, String[]> map = request.getParameterMap();
        Set<String> set = map.keySet();
        //如果能够在实现知道容器的大小直接指定也是一条最佳实践
        List<DepartmentEntity> departmentEntities = new ArrayList<DepartmentEntity>(map.size() - 2);
        for (String tmp : set) {
            //判断一个字符串既不是action也不是unitId的逻辑是：和action不equals同时和unitId不equals
            if (!"action".equals(tmp) && !"unitId".equals(tmp)) {
                String deptName = request.getParameter(tmp);
                if (deptName != null && !"".equals(deptName)) {
                    DepartmentEntity departmentEntity = new DepartmentEntity();
                    departmentEntity.setDeptName(deptName);
                    departmentEntity.setUnitByUnitId(unitEntity);
                    departmentEntities.add(departmentEntity);
                }
            }
        }

        unitService.addDepartments(unitEntity, departmentEntities);

        //增加玩部门之后在显示所有的部门
        return modifyUnit(request, unitId);
    }

    /**
     * 删除某个部门
     *
     * @param request
     * @param deptId
     * @param unitId
     * @return
     */
    @RequestMapping(value = "/unit", params = "action=deleteDept")
    public String deleteDept(HttpServletRequest request, @RequestParam("deptId") int deptId, @RequestParam("unitId") int unitId) {

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(deptId);
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(unitId);
        departmentEntity.setUnitByUnitId(unitEntity);
        unitService.deleteDepartment(departmentEntity);

        return modifyUnit(request, unitId);
    }
}
