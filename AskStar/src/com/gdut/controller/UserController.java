package com.gdut.controller;

import com.gdut.pojo.AskUser;
import com.gdut.service.UserService;
import com.gdut.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/user/*")
public class UserController extends BaseController {
    protected UserService userService = new UserServiceImpl();

    /**
     * 接收用户的登录请求的(接口)
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        //这里做一个特殊判断,如果是管理员则跳转到管理界面
        if (username.equals("root") && userPwd.equals("123456")){
            req.getRequestDispatcher("/WEB-INF/rootlogin.html").forward( req , resp );

            //resp.sendRedirect("/rootlogin.html");
            //inf受保护所以不能直接访问,这里用了个转发请求

        }else {
             boolean tof = userService.findAll(username, userPwd);
             if (tof) {
                resp.sendRedirect("/loginSuccess.html");
             } else {
                 resp.sendRedirect("/loginError.html");
             }

        }


    }


    /**
     * 接收用户注册请求的(接口)
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取信息
        //2.调用服务层
        //3.根据结果跳转路径
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        if ( username.equals("root") ){//这里做一个特殊判断,如果是管理员的账号则不允许注册
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("这是管理员账号,无法注册,请自行退回");
        } else {
            AskUser user = new AskUser(null, username, userPwd);
            int row = userService.regist(user);
            if (row > 0) {
                resp.sendRedirect("/registSuccess.html");
            } else {
                resp.sendRedirect("/registFail.html");
            }
        }

    }

}

