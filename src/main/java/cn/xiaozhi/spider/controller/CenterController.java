package cn.xiaozhi.spider.controller;

import cn.xiaozhi.spider.service.ExcelService;
import cn.xiaozhi.spider.util.ConstantHolder;
import cn.xiaozhi.spider.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by qcz on 2015/6/19.
 */
@Controller
@RequestMapping(value = "/home/")
public class CenterController {

    @Value("${fileName.keyword}")
    private String fileName;

    @Autowired
    private ExcelService excelService;

    @RequestMapping(value = "/hello")
    public @ResponseBody String sayHi(){
        return "hello,翟大师，让丁付佣金~";
    }

    @RequestMapping(value = "/wel")
    public String welcome(){
        return "welcome";
    }

    /**
     * 通过关键词和起始页进行爬取
     * @param keyWord 检索的关键词
     * @param url 起始url
     * @param num 限定最大检索数量
     * @return
     */
    @RequestMapping(value = "/search")
    public String getKeySearchResult(String keyWord,String url,
                                     Long num){
        return null;
    }

    /**
     * 通过关键词文件进行自动检索
     */
    @RequestMapping(value = "/autoSearch")
    public String autoSearch(Model model,
                             @RequestParam(required = false,defaultValue = "false")String referensh){
        //获取内置关键词
        //当缓存为空或者要求刷新时，重新读取文件，刷新缓存
        if(ConstantHolder.excelMap==null || Boolean.valueOf(referensh)){
            fileName = FileUtil.convertFileToPath(fileName);
            ConstantHolder.excelMap = excelService.readExcelBySax(fileName);
        }

        //返回一个页面，是sheet的导航
        model.addAttribute("sheetList",ConstantHolder.excelMap.keySet());
        return "autoSearcheNav";
    }

    /**
     *列出该分类下的所有关键词检索
     */
    @RequestMapping(value = "/getKeySet",method = RequestMethod.POST)
    public String getKeySet(Model model,String key){
        //当缓存为空或者要求刷新时，重新读取文件，刷新缓存
        if(ConstantHolder.excelMap==null){
            ConstantHolder.excelMap = excelService.readExcel(fileName);
        }
        List<Object> list = ConstantHolder.excelMap.get(key);
        model.addAttribute("list",list);
        return "keyDetail";
    }
}
