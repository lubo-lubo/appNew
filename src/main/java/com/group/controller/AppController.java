package com.group.controller;

import com.group.pojo.App_Category;
import com.group.pojo.App_check;
import com.group.pojo.App_Version;
import com.group.pojo.Data_Dictionary;
import com.group.service.*;
import com.group.util.PageUtil;
import com.group.vo.Vappinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/app")
public class AppController {
    @Autowired
    private AppCategoryService appCategoryService;
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @Autowired
    private VappService vappService;
    @Autowired
    private AppVersionService appVersionService;
    @Autowired
    private AppcheckService appcheckService;
    @RequestMapping("/disolvecat")
    @ResponseBody
    public Object disolve(Long pid){
        App_Category[] app_categories=  appCategoryService.findChild(pid).toArray(App_Category[]::new);
        return app_categories;
    }
    @RequestMapping("/list")
    public String applist(HttpSession session){
        List<App_Category> category1=appCategoryService.findfirst();
        List<App_Category> category2=appCategoryService.findSecond();
        List<App_Category> category3=appCategoryService.findThird();
        List<Data_Dictionary> appplatform=dataDictionaryService.findAppPlatform();
        PageUtil<Vappinfo> page=vappService.findAllBypage(1L);
        session.setAttribute("categoryLevel1List",category1);
//        session.setAttribute("categoryLevel2List",category2);
//        session.setAttribute("categoryLevel3List",category3);
        session.setAttribute("flatFormList",appplatform);
        session.setAttribute("appInfoList",page.gettList());
        session.setAttribute("page",page);
        return "backend/applist";
    }
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(HttpSession session, @RequestParam(required = false) Long pageNo,@RequestParam(required = false) String querySoftwareName,@RequestParam(required = false) Long queryFlatformId,@RequestParam(required = false) Long queryCategoryLevel1,@RequestParam(required = false) Long queryCategoryLevel2,@RequestParam(required = false) Long queryCategoryLevel3){
        if(pageNo==1){
            session.removeAttribute("querySoftwareName");
            session.removeAttribute("queryFlatformId");
            session.removeAttribute("queryCategoryLevel1");
            session.removeAttribute("queryCategoryLevel2");
            session.removeAttribute("queryCategoryLevel3");
            PageUtil<Vappinfo> page=vappService.findSomeByPage(querySoftwareName,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,pageNo);
            session.setAttribute("appInfoList",page.gettList());
            session.setAttribute("page",page);
            System.out.println(page);
            session.setAttribute("querySoftwareName",querySoftwareName);
            session.setAttribute("queryFlatformId",queryFlatformId);
            session.setAttribute("queryCategoryLevel1",queryCategoryLevel1);
            session.setAttribute("queryCategoryLevel2",queryCategoryLevel2);
            session.setAttribute("queryCategoryLevel3",queryCategoryLevel3);
        }else{
            querySoftwareName= Objects.requireNonNullElse(session.getAttribute("querySoftwareName"),"").toString();
            queryFlatformId= Long.valueOf( Objects.requireNonNullElse(session.getAttribute("queryFlatformId"),0).toString());
            queryCategoryLevel1= Long.valueOf(Objects.requireNonNullElse(session.getAttribute("queryCategoryLevel1"),0).toString()) ;
            queryCategoryLevel2=  Long.valueOf(Objects.requireNonNullElse(session.getAttribute("queryCategoryLevel2"),0).toString());
            queryCategoryLevel3=  Long.valueOf(Objects.requireNonNullElse(session.getAttribute("queryCategoryLevel3"),0).toString());
            PageUtil<Vappinfo> page=vappService.findSomeByPage(querySoftwareName,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,pageNo);
            session.setAttribute("page",page);
            session.setAttribute("appInfoList",page.gettList());
        }
        return "backend/applist";
    }

    @RequestMapping("/check")
    public String check(HttpSession session,Long aid,Long vid){
        App_check appInfo=appcheckService.findOne(aid);
        App_Version appVersion=appVersionService.findOne(vid);
        session.setAttribute("appInfo",appInfo);
        session.setAttribute("appVersion",appVersion);
        return "backend/appcheck";
    }
}
