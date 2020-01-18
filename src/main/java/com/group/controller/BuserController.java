package com.group.controller;

import com.group.pojo.Backend_User;
import com.group.pojo.Data_Dictionary;
import com.group.service.BuserService;
import com.group.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BuserController {
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @Autowired
    private BuserService buserService;
    @RequestMapping("/admin/login")
    public String devlogin(){
        return "backendlogin";
    }
    @RequestMapping(value = "/admin/dologin",method = RequestMethod.GET)
    public String dologin(HttpSession session,String userCode,String userPassword){
        Backend_User buser=buserService.login(userCode);
        System.out.println("查询得出："+buser);
        if(buser!=null){
            if(buser.getUserPassword().equals(userPassword)){
                session.setAttribute("userSession",buser);
                return "backend/main";
            }else{
                session.setAttribute("error","密码输入错误");
            }
        }else{
            session.setAttribute("error","用户不存在");
        }
        return "redirect:/admin/login";
    }
    @RequestMapping("/buser/list")
    public String list(HttpSession session){
        List<Data_Dictionary> userTypeList= dataDictionaryService.findByType("USER_TYPE");
        List<Backend_User> buserList=buserService.findAll();
        session.setAttribute("buserList",buserList);
        session.setAttribute("userTypeList",userTypeList);
        return "backend/buserlist";
    }
}
