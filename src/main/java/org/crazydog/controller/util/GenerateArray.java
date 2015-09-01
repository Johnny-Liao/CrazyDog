package org.crazydog.controller.util;

import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.crazydog.serviceI.impl.UnitServiceImpl;

import java.util.List;

/**
 * Created by never on 2015/8/31.
 */
public class GenerateArray {

    public static String generateArray(UnitServiceImpl unitService) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("var array = new Array(  \n");
        List<UnitEntity> unitEntities = unitService.getAllEntities();
        for (UnitEntity unitEntity : unitEntities) {
            List<DepartmentEntity> departmentEntities = unitService.getDepartmentEntitiesByUnit(unitEntity);
            buffer.append("new Array(");
            for (DepartmentEntity departmentEntity : departmentEntities)
                buffer.append("\"" + departmentEntity.getId() + "-" + departmentEntity.getDeptName() + "\",");
            //去掉多余的逗号
            buffer.delete(buffer.length() - 1, buffer.length());
            buffer.append("),");
        }
        //去掉多余的逗号
        buffer.delete(buffer.length() - 1, buffer.length());
        buffer.append(");");
        return buffer.toString();
    }

    public static String generateScript(UnitServiceImpl unitService) {
        String script = "<script>";
        script += "function changecity() {\n" +
                "            index = collect.unit.options.selectedIndex;\n" +
                "            collect.dept.length = array[index].length;\n" +
                "            for (var i = 0; i < array[index].length; i++) {\n" +
                "                var text = array[index][i].split(\"-\");\n" +
                "                collect.dept.options[i].text = text[1];\n" +
                "                collect.dept.options[i].value = text[0];\n" +
                "            }\n" +
                "        }";
        script += generateArray(unitService);
        script += "</script>";
        return script;
    }
}
