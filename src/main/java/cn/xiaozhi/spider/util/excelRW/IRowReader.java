package cn.xiaozhi.spider.util.excelRW;

import java.util.List;

/**
 * Created by quchengzhi on 2015/7/16.
 * 取得该行所有值
 */
public interface IRowReader {

    /**业务逻辑实现方法
     * @param sheetIndex
     * @param curRow
     * @param rowlist
     */
    public  void getRows(int sheetIndex,int curRow, List<String> rowlist);
}

