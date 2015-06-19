package cn.xiaozhi.spider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qcz on 2015/6/19.
 */
@Controller
@RequestMapping(value = "/home/")
public class CenterController {
    @RequestMapping(value = "/search")
    public String getKeySearchResult(String keyWord,String search){
        return null;
    }
}
