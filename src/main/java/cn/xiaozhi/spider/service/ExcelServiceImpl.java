package cn.xiaozhi.spider.service;

import cn.xiaozhi.spider.util.excelRW.ExcelReaderUtil;
import cn.xiaozhi.spider.util.excelRW.IRowReader;
import cn.xiaozhi.spider.util.excelRW.RowReader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by quchengzhi on 2015/7/3.
 */
@Service("excelService")
public class ExcelServiceImpl implements ExcelService{

    public Map<String, List> readExcel(String fileName) {
        try {
            Workbook wb = convertFileToWb(fileName);
            Map<String,List> map = new HashMap<String, List>();
            int sheetNum = wb.getNumberOfSheets();
            for(int i=0;i<sheetNum;i++){
                Sheet sheet = wb.getSheetAt(i);
                String sheetName = sheet.getSheetName();

                List<Object> list = readSheetAsList(sheet);
                map.put(sheetName,list);
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Workbook convertFileToWb(String fileName) throws IOException {
        //getResource是寻找项目路径下,get
        InputStream inputStream =  this.getClass().getResourceAsStream(fileName);
        Workbook wb = null;
        if(fileName.endsWith("xls")){
            wb = new HSSFWorkbook(inputStream);//解析xls格式
        }else if(fileName.endsWith("xlsx")){
            wb = new XSSFWorkbook(inputStream);//解析xlsx格式
        }
        inputStream.close();
        return wb;
    }

    /**
     * 将一个sheet处理为List<Object[]>
     * @param sheet
     * @return
     */
    private List<Object> readSheetAsList(Sheet sheet) {
        int rowNum = sheet.getLastRowNum();
        List<Object> list = new ArrayList<Object>(rowNum);
        for(int j=0;j<rowNum;j++){
            Row row = sheet.getRow(j);
//            int cellNum = row.getLastCellNum();
//            Object[] objects =  new Object[cellNum+1];
//            for(int k=0;k<cellNum;k++){
//                objects[k] = row.getCell(k);
//            }
//            list.add(objects);
            list.add(row.getCell(0));
        }
        return list;
    }

    public Map<String, List> readExcelBySax(String fileName) {
        IRowReader reader = new RowReader();
        try {
            ExcelReaderUtil.readExcel(reader, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
