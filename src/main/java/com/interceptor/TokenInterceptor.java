package com.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class TokenInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler instanceof HandlerMethod){
            HandlerMethod hmd = (HandlerMethod)handler;
            Method md = hmd.getMethod();
            Token token = md.getAnnotation(Token.class);
            if(token != null){
                boolean cktoken = token.check();
                if(cktoken){ // 可以判断重复提交
                    boolean ck2  = checkToken(request) ;
                    if(ck2 == false){
                        response.sendRedirect("/myboot/repeat.jsp");
                        return  false;
                    }else{
                        // 清空 token
                        request.getSession().removeAttribute("token");
                    }
                }
            }
        }

        return true;
    }

    // false 要拦截 ， true 不拦截
    private boolean checkToken(HttpServletRequest request){
        boolean ck = false;
        String rnum = request.getParameter("token");
        Object snum = request.getSession().getAttribute("token");

        if(rnum != null && snum !=null && rnum.equals(snum)){
            ck = true;
        }

        return ck;
    }

}
