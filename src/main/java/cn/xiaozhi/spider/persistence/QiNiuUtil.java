package cn.xiaozhi.spider.persistence;

import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by qcz on 2015/6/19.
 * 七牛云工具类 单例
 */
@Component
public class QiNiuUtil{

    private static QiNiuUtil qiNiuUtil = new QiNiuUtil();

    @Value("${qiniu.ak}")
    private static String qiNiuAk;

    @Value("${qiniu.sk}")
    private static String qiNiuSk;

    @Value("${qiniu.bucket}")
    private static String bucket;

    private static Auth auth;

    private QiNiuUtil(){
        this.auth = Auth.create(qiNiuAk,qiNiuSk);
    }

    public static QiNiuUtil getInstance(){
        return qiNiuUtil;
    }

    /**
     * 获取简单上传token
     * @param bucket 目标桶的名称
     * @param key key值
     * @return
     */
    public String getTokenSimple(String bucket,String key){
        return auth.uploadToken(bucket,key);
    }


}
