package com.group.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.group.pojo.App_Category;
import com.group.service.AppCategoryService;
import com.group.service.VappcategoryService;
import com.group.util.PageUtil;
import com.group.vo.Vappcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/appcategory")
public class AppCategoryController {
    @Autowired
    private AppCategoryService appCategoryService;
    @Autowired
    private VappcategoryService vappcategoryService;
    @RequestMapping("/categorylist")
    public String categoryList(HttpSession session){
        List<App_Category> categoryLevel1List=appCategoryService.findfirst();
        PageUtil<App_Category> page=appCategoryService.findAllByPage(1);
        List<Vappcategory> vappcategories=new ArrayList<>();
        for(App_Category category:page.gettList()){
            Vappcategory vappcategory=new Vappcategory();
            vappcategory.setCategoryCode(category.getCategoryCode());
            vappcategory.setCategoryName(category.getCategoryName());
            vappcategory.setId(category.getId());
            vappcategory.setParentId(category.getParentId());
            if(category.getParentId()==null){
                vappcategory.setParentName("根类");
            }else{
                vappcategory.setParentName(appCategoryService.findById(category.getParentId()).getCategoryName());
            }
            System.out.println("last:"+vappcategory.getParentName());
            vappcategories.add(vappcategory);
        }
//        vappcategories.forEach(System.out::println);
        session.setAttribute("page",page);
        session.setAttribute("categoryLevel1List",categoryLevel1List);
        session.setAttribute("appcategoryList",vappcategories);
        return "backend/appcategorylist";
    }
    @RequestMapping("/disolvelevel1")
    @ResponseBody
    public Object findSons(Long cid){
        App_Category[] app_categories=appCategoryService.findChild(cid).toArray(App_Category[]::new);
        return app_categories;
    }
    @RequestMapping("/search")
    public String search(HttpSession session,int pageNo,@RequestParam(required = false) String queryCategoryName,@RequestParam(required = false) Long queryCategoryLevel1,@RequestParam(required = false) Long queryCategoryLevel2,@RequestParam(required = false)Long queryCategoryLevel3 ){
        List<App_Category> categoryLevel1List=appCategoryService.findfirst();
        if(pageNo==1){
            session.removeAttribute("queryCategoryName");
            session.removeAttribute("queryCategoryLevel1");
            session.removeAttribute("queryCategoryLevel2");
            session.removeAttribute("queryCategoryLevel3");
            PageUtil<App_Category> page=appCategoryService.findSomeByPage(pageNo,queryCategoryName,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3);
            List<Vappcategory> vappcategories=new ArrayList<>();
            for(App_Category category:page.gettList()){
                Vappcategory vappcategory=new Vappcategory();
                vappcategory.setCategoryCode(category.getCategoryCode());
                vappcategory.setCategoryName(category.getCategoryName());
                vappcategory.setId(category.getId());
                vappcategory.setParentId(category.getParentId());
                if(category.getParentId()==null){
                    vappcategory.setParentName("根类");
                }else{
                    vappcategory.setParentName(appCategoryService.findById(category.getParentId()).getCategoryName());
                }
                System.out.println("last:"+vappcategory.getParentName());
                vappcategories.add(vappcategory);
            }
            session.setAttribute("page",page);
            session.setAttribute("categoryLevel1List",categoryLevel1List);
            session.setAttribute("appcategoryList",vappcategories);
            session.setAttribute("queryCategoryName",queryCategoryName);
            session.setAttribute("queryCategoryLevel1",queryCategoryLevel1);
            session.setAttribute("queryCategoryLevel2",queryCategoryLevel2);
            session.setAttribute("queryCategoryLevel3",queryCategoryLevel3);
        }else{
            queryCategoryName=Objects.requireNonNullElse(session.getAttribute("queryCategoryName"),"").toString();
            queryCategoryLevel1=Long.valueOf(Objects.requireNonNullElse(session.getAttribute("queryCategoryLevel1"),0).toString());
            queryCategoryLevel2=Long.valueOf(Objects.requireNonNullElse(session.getAttribute("queryCategoryLevel2"),0).toString());
            queryCategoryLevel3=Long.valueOf(Objects.requireNonNullElse(session.getAttribute("queryCategoryLevel3"),0).toString());
            PageUtil<App_Category> page=appCategoryService.findSomeByPage(pageNo,queryCategoryName,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3);
            List<Vappcategory> vappcategories=new ArrayList<>();
            for(App_Category category:page.gettList()){
                Vappcategory vappcategory=new Vappcategory();
                vappcategory.setCategoryCode(category.getCategoryCode());
                vappcategory.setCategoryName(category.getCategoryName());
                vappcategory.setId(category.getId());
                vappcategory.setParentId(category.getParentId());
                if(category.getParentId()==null){
                    vappcategory.setParentName("根类");
                }else{
                    vappcategory.setParentName(appCategoryService.findById(category.getParentId()).getCategoryName());
                }
//                System.out.println("last:"+vappcategory.getParentName());
                vappcategories.add(vappcategory);
            }
            session.setAttribute("page",page);
            session.setAttribute("categoryLevel1List",categoryLevel1List);
            session.setAttribute("appcategoryList",vappcategories);
        }
        return "backend/appcategorylist";
    }

    @RequestMapping("/addcategory")
    public String addCategory(){
        return "backend/categoryadd";
    }
    @RequestMapping("/disolvelevel")
    @ResponseBody
    public Object disolvelevel(String level){
        App_Category[] appcategories={};
        switch (level){
            case "1":
                break;
            case "2":
                appcategories=appCategoryService.findfirst().toArray(App_Category[]::new);
                break;
            case "3":
                appcategories=appCategoryService.findSecond().toArray(App_Category[]::new);
                break;
        }
        System.out.println("返回的json："+appcategories);
        return appcategories;
    }

    @RequestMapping(value = "/saveadd",method= RequestMethod.POST)
    public String saveAdd(App_Category category){
        appCategoryService.addOne(category);
        return "redirect: /appcategory/categorylist";
    }

    @RequestMapping(value="/modify")
    public String modify(HttpSession session,Long appCategoryid){
        App_Category category=appCategoryService.findById(appCategoryid);
//        System.out.println("要修改的分类："+category);
        List<App_Category> categorylist=appCategoryService.findAll();
        session.setAttribute("categorylist",categorylist);
        session.setAttribute("category",category);
        return "backend/categorymodify";
    }
    @RequestMapping(value="/savemodify",method = RequestMethod.POST)
    public String saveModify(App_Category category){
//        System.out.println("修改对象的上级分类："+category.getParentId());
        appCategoryService.updateOne(category);
        return "redirect:/appcategory/categorylist";
    }

    @RequestMapping("/delete")
    public String delete(Long appCategoryid){
        //删除逻辑有待补充
        appCategoryService.deleteOne(appCategoryid);
        return "redirect: /appcategory/categorylist";
    }
}
