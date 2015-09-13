package cn.xiaozhi.spider.util.excelRW;

import java.util.List;

/**
 * Created by quchengzhi on 2015/7/16.
 */
public class RowReader implements IRowReader{

    /* 业务逻辑实现方法
     * @see com.eprosun.util.excel.IRowReader#getRows(int, int, java.util.List)
     */
    public void getRows(int sheetIndex, int curRow, List<String> rowlist) {
        // TODO Auto-generated method stub
        System.out.print(curRow+" ");
        for (int i = 0; i < rowlist.size(); i++) {
            System.out.print(rowlist.get(i) + " ");
        }
        System.out.println();
    }

//    public static void main(String[] args) throws Exception {
//        IRowReader reader = new RowReader();
//        //ExcelReaderUtil.readExcel(reader, "F://te03.xls");
//        ExcelReaderUtil.readExcel(reader, "F://test07.xlsx");
//    }

}

