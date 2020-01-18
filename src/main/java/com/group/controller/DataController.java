package com.group.controller;

import com.group.pojo.Data_Dictionary;
import com.group.service.DataDictionaryService;
import com.group.util.PageUtil;
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
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @RequestMapping("/list")
    public String showList(HttpSession session){
        List<Data_Dictionary> typeList=dataDictionaryService.findType();
        PageUtil<Data_Dictionary> page=dataDictionaryService.findAllByPage(1);
        typeList.forEach(System.out::println);
        session.setAttribute("typeList",typeList);
        session.setAttribute("dataList",page.gettList());
        session.setAttribute("page",page);
        return "backend/datalist";
    }
    @RequestMapping("/search")
    public String search(HttpSession session, int pageNo, @RequestParam(required = false) String queryValueName, @RequestParam(required = false)String queryTypeCode,@RequestParam(required = false) Long queryValueId){
        if(pageNo==1){
            PageUtil<Data_Dictionary> page=dataDictionaryService.findSomeByPage(queryTypeCode,queryValueName,queryValueId,pageNo);
            session.setAttribute("page",page);
            session.setAttribute("dataList",page.gettList());
            session.setAttribute("queryValueName", Objects.requireNonNullElse(queryValueName,""));
            session.setAttribute("queryValueId", Objects.requireNonNullElse(queryValueId,0));
            session.setAttribute("queryTypeCode", Objects.requireNonNullElse(queryTypeCode,""));
            System.out.println("queryValueName"+session.getAttribute(queryValueName));
            System.out.println("queryValueId"+session.getAttribute("queryValueId"));
            System.out.println("queryTypeCode"+session.getAttribute(queryTypeCode));
        }else{
            queryValueName=Objects.requireNonNullElse(session.getAttribute("queryValueName"),"").toString();
            queryValueId=Long.valueOf(Objects.requireNonNullElse(session.getAttribute("queryValueId"),0).toString());
            queryTypeCode=Objects.requireNonNullElse(session.getAttribute("queryTypeCode"),"").toString();
            PageUtil<Data_Dictionary> page=dataDictionaryService.findSomeByPage(queryTypeCode,queryValueName,queryValueId,pageNo);
            session.setAttribute("page",page);
            session.setAttribute("dataList",page.gettList());
        }
        return "backend/datalist";
    }
    @RequestMapping("/disolvetype")
    @ResponseBody
    public Object disolveType(String typeCode){
        Data_Dictionary[] dataArray=dataDictionaryService.findByType(typeCode).toArray(Data_Dictionary[]::new);
        return dataArray;
    }
    @RequestMapping("/add")
    public String add(){
        return "backend/dataadd";
    }
    @RequestMapping(value = "/saveadd",method = RequestMethod.POST)
    public String saveAdd(Data_Dictionary dataDictionary){
        dataDictionaryService.addOne(dataDictionary);
        return "redirect: /data/list";
    }
    @RequestMapping("/delete")
    public String delete(Long did){
        dataDictionaryService.deleteOne(did);
        return "redirect:/data/list";
    }
    @RequestMapping("/modify")
    public String modify(Long did,HttpSession session){
        Data_Dictionary baseData=dataDictionaryService.findOne(did);
        session.setAttribute("baseData",baseData);
        return "backend/datamodify";
    }
    @RequestMapping(value = "/savemodify",method = RequestMethod.POST)
    public String saveModify(Data_Dictionary dataDictionary){
        System.out.println(dataDictionary);
        dataDictionaryService.modifyOne(dataDictionary);
        return "redirect:/data/list";
    }
}
