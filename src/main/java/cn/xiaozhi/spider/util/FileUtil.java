package cn.xiaozhi.spider.util;

import cn.xiaozhi.spider.exception.KeywordsNullException;
import org.apache.commons.lang.StringUtils;

/**
 * Created by quchengzhi on 2015/7/20.
 */
public class FileUtil {
    public static String convertFileToPath(String fileName){
        if(StringUtils.isNotBlank(fileName)){
            return FileUtil.class.getResource(fileName).getFile();
        }
        throw new KeywordsNullException("fileName is Null or Empty,please check the config.properties--fileName.keyword");
    }
}
