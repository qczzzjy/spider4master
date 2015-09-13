package cn.xiaozhi.spider.service;

import java.util.List;
import java.util.Map;

/**
 * Created by quchengzhi on 2015/7/3.
 */
public interface ExcelService {

    public Map<String,List> readExcel(String fileName);

    /**
     * 读取2007较大的Excel文件时使用
     * @return
     */
    public Map<String,List> readExcelBySax(String fileName);

}
