package com.action;

import com.interceptor.Login;
import com.interceptor.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.*;
import com.entity.*;
import com.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private  IDemoService ds ;

    @RequestMapping("/test")
    public ModelAndView test(ModelAndView mvo){
        System.out.println(" ------------- test ");

        List<Demo> list = ds.selectAll();

        for(Demo d :list){
            System.out.println(d);
        }

        mvo.setViewName("success");
        return mvo;
    }
    @Token(check = true)
    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mvo, UserBean u, HttpSession session){

        if("管理员".equals(u.getUser()) && "admin123".equals(u.getPwd())){
            session.setAttribute("userinfo",u);
            mvo.setViewName("success");
        }else{
            mvo.addObject("loginerror","用户名或密码错误！！");
            mvo.setViewName("login");
        }

        return mvo;
    }

    @Login(check = true)
    @RequestMapping("/main")
    public ModelAndView main(ModelAndView mvo){
        System.out.println("----------main");

        mvo.setViewName("main");
        return  mvo;
    }
}
