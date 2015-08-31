package org.crazydog.controller.util;

import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.crazydog.serviceI.impl.UnitServiceImpl;

import java.util.List;

/**
 * Created by never on 2015/8/31.
 */
public class GenerateArray {
    private static StringBuffer buffer = new StringBuffer();

    public static String generateArray(UnitServiceImpl unitService) {
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

    public String generateScript() {
        String script = "function changecity(){\n" +
                " index = form2.sf.options.selectedIndex-1;\n" +
                " form2.city.length = city[index].length;\n" +
                " for(var i = 0;i<city[index].length;i++)\n" +
                "  {\n" +
                "   var text = city[index][i].split(\"-\");\n" +
                "   form2.city.options[i].text = text[1];\n" +
                "   form2.city.options[i].value =text[0];\n" +
                "  }\n" +
                "}";
        return script;
    }
}
