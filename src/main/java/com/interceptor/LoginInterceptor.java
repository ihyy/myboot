package com.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler instanceof HandlerMethod){
            HandlerMethod hmd = (HandlerMethod)handler;
            Method md = hmd.getMethod();
            Login login = md.getAnnotation(Login.class);  // 取注解 Login
            // 要有注解
            if(login != null){
                  boolean cklogin = login.check();
                  if(cklogin){
                      boolean ck2  = checkLogin(request);
                      if(ck2 == false){
                          response.sendRedirect("/myboot/login.jsp");
                          return  false ;
                      }
                  }
            }
        }

        return true ;
    }

    private boolean checkLogin(HttpServletRequest request){
        // 登录判断
        Object uobj = request.getSession().getAttribute("userinfo");
        if(uobj != null){
            return true;
        }else{
            return false;
        }
    }

}
