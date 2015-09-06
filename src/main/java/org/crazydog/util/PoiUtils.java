package org.crazydog.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.crazydog.daoI.impl.ResumedaoImpl;
import org.crazydog.domain.ResumeEduEntity;
import org.crazydog.domain.ResumeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifei on 2015/9/2.
 */
public class PoiUtils {

    @Autowired
    @Qualifier("resumedaoImpl")
    private static  ResumedaoImpl resumedao;

    /**
     * 传入文件的路径，文件格式为*.xls,模板如crazydog.xls
     * @param filePath
     */
    public static void PoiUtils(String filePath) {
        ResumeEntity entity =  new ResumeEntity();;
        List<ResumeEduEntity> eduentity = new ArrayList<ResumeEduEntity>();
        XSSFWorkbook wookbook = null;

        try {
            // 创建对Excel工作簿文件的引用
            wookbook = new XSSFWorkbook(new FileInputStream(filePath));
            // 在Excel文档中，第一张工作表的缺省索引是0
            // 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);
            XSSFSheet sheet = wookbook.getSheet("Sheet1");
            //获取到Excel文件中的所有行数
            int rows = sheet.getPhysicalNumberOfRows();
            //遍历行

            for (int i = 1; i < rows; i++) {
                // 读取左上端单元格
                XSSFRow row = sheet.getRow(i);
                // 行不为空
                if (row != null) {
                    //获取到Excel文件中的所有的列
                    int cells = row.getPhysicalNumberOfCells();
                    String value = "";
                    //遍历列
                    for (int j = 0; j < cells; j++) {
                        //获取到列的值
                        XSSFCell cell = row.getCell(j);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    DecimalFormat df = new DecimalFormat("0");
                                    value += df.format(cell.getNumericCellValue())+ ",";
//                                    value += cell.getNumericCellValue() + ",";
                                    break;
                                case XSSFCell.CELL_TYPE_STRING:
                                    value += cell.getStringCellValue().toString() + ",";
                                    break;
                                default:
                                    value += "0";
                                    break;
                            }
                        }
                    }
                    // 将数据插入到mysql数据库中
                    String[] val = value.split(",");
                    for (String s : val) {
                        System.out.println(s);
                    }
                    setToEntity(entity, val);

                    resumedao.addEntity(entity);
                }
            }

            XSSFSheet sheet2 = wookbook.getSheet("Sheet2");
            int rows2 = sheet2.getPhysicalNumberOfRows();
            for (int i = 1; i <=rows; i++) {
                XSSFRow row2 = sheet2.getRow(i);
                if (row2 != null) {
                    int cells = row2.getPhysicalNumberOfCells();
                    String value = "";
                    for (int j = 0; j < cells; j++) {
                        XSSFCell cell = row2.getCell(j);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    DecimalFormat df = new DecimalFormat("0");
                                    value += df.format(cell.getNumericCellValue())+ ",";
                                    break;
                                case XSSFCell.CELL_TYPE_STRING:
                                    value += cell.getStringCellValue().toString() + ",";
                                    break;
                                default:
                                    value += "0";
                                    break;
                            }
                        }
                    }
                    // 将数据插入到mysql数据库中
                    String[] valedu = value.split(",");
                    for (String s : valedu) {
                        System.out.println(s);
                    }
                    ResumeEduEntity edu = new ResumeEduEntity();

                    setToResumeEduEntity(entity, valedu, edu);

                    eduentity.add(edu);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        entity.setResumeEduById(eduentity);
        resumedao.modifyEntity(entity);
    }

    private static void setToResumeEduEntity(ResumeEntity entity, String[] valedu, ResumeEduEntity edu) {
        Date begindata = null;
        try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            begindata = new Date(f.parse(valedu[0].toString()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        edu.setStartTime(begindata);
        Date enddata = null;
        try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            enddata = new Date(f.parse(valedu[1].toString()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        edu.setEndTime(enddata);
        edu.setSchool(valedu[2]);
        edu.setDiscipline(valedu[3]);
        edu.setResumeId(entity.getId());
    }

    private static void setToEntity(ResumeEntity entity, String[] val) {
        entity.setName(val[0]);
        entity.setNation(val[1]);
        entity.setGender(val[2]);
        entity.setIdNum(val[3]);
        entity.setTel(Long.parseLong(val[4]));
        entity.setEmail(val[5]);
        entity.setZzmm(val[6]);
        entity.setHyzk(val[7]);
        entity.setEducation(val[8]);
        Date birthday = null;
        try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            birthday = new Date(f.parse(val[9].toString()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        entity.setBirthday(birthday);
        entity.setJjsp(val[10]);
        entity.setProfession(val[11]);
        entity.setZipCode(Integer.parseInt(val[12]));
        entity.setHomeTown(val[13]);
        entity.setForeignLang(val[14]);
        entity.setSpecialty(val[15]);
        entity.setYysp(val[16]);
        entity.setJndj(Integer.parseInt(val[17]));
        entity.setHeight(Double.valueOf(val[18]));
        entity.setHukou(val[19]);
        entity.setHukouAddress(val[20]);
        entity.setHomePhone(Integer.parseInt(val[21]));
        entity.setAddress(val[22]);
        entity.setReportCard(val[23]);
    }


}
