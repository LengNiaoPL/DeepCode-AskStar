package com.gdut.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 因为会有增删改查,所以service里要判断是增?删?改?查?(几个控制类一样,继承提高复用性)
 *  增的请求     /xxxx/add
 *  删的请求     /xxxx/remove
 *  改的请求     /xxxx/update
 *  查的请求     /xxxx/find
 */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String methodName = split[split.length-1];
        // 使用 反射 通过方法名获取下面的方法
        Class aClass = this.getClass();
        // 获取方法
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //declared可以暴力破解方法
            declaredMethod.setAccessible(true);
            //invoke执行方法
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
