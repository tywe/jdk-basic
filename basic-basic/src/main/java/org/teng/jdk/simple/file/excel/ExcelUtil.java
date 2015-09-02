package org.teng.jdk.simple.file.excel;

import jxl.Cell;
import jxl.Sheet;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jxl.Workbook.getWorkbook;

/**
 * description:EXCEL工具类.
 * excel的读取，写入
 *
 * @author:baichuan
 * @date:2015/9/2
 */
public class ExcelUtil {
    /**
     * 读取EXCEL指定sheet页的数据
     *
     * @param file
     * @param sheetNum
     * @return
     */
    public static List<List<String>> xls2List(File file, int sheetNum) throws Exception {
        if (file == null) {
            throw new Exception("文件为空");
        }
        List<List<String>> xlsWorkBookRowList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file)) {
            jxl.Workbook workbook = getWorkbook(fis);
            Sheet[] sheets = workbook.getSheets();
            if (sheetNum > sheets.length) {
                return xlsWorkBookRowList;
            }
            sheetNum = sheetNum <= 0 ? 0 : sheetNum - 1;
            Sheet sheet = sheets[sheetNum];
            int rows = sheet.getRows();
            int cols = sheet.getColumns();

            for (int row = 0; row < rows; row++) {
                Cell[] cells = sheet.getRow(row);
                List<String> rowCells = new ArrayList<>();
                for (int col = 0; col < cols; col++) {
                    rowCells.add(cells[col].getContents());
                }

                xlsWorkBookRowList.add(rowCells);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return xlsWorkBookRowList;
    }

    /**
     * 读取xls文件内容
     *
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String xls2String(File file) {
        String result = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            StringBuilder sb = new StringBuilder();
            jxl.Workbook rwb = getWorkbook(fis);
            Sheet[] sheet = rwb.getSheets();
            for (int i = 0; i < sheet.length; i++) {
                Sheet rs = rwb.getSheet(i);
                for (int j = 0; j < rs.getRows(); j++) {
                    Cell[] cells = rs.getRow(j);
                    for (int k = 0; k < cells.length; k++)
                        sb.append(cells[k].getContents());
                }
            }
            fis.close();
            result += sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:/Users/dell/Desktop/dd.xlsx");
//        System.out.println(xls2String(file));
        System.out.println(xls2List(file, 1));
    }
}


class testxls {
    public static <T> List<T> getList(Class clz) throws IllegalAccessException, InstantiationException {
        T obj1 = (T) clz.newInstance();
        T obj2 = (T) clz.newInstance();
        return Arrays.asList(obj1, obj2);
    }
}