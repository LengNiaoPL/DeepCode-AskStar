package com.gdut.controller;

import com.gdut.pojo.Question;
import com.gdut.service.QuestionService;
import com.gdut.service.impl.QuestionServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/question/*")
public class QuestionController extends BaseController {

    QuestionService questionService=new QuestionServiceImpl();


    //查看问题
    private void findQuestion(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        List<Question> questionList=questionService.findQuestion(username);
        resp.setContentType("text/html"); // 设置响应内容类型为text/html
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>回答问题</title></head>");
        out.println("<body>");
        out.println("<form method=\"post\" action=\"/ans/add\">");
        out.println("<h1>请回答</h1>");

        for (int i=0;i<questionList.size();i++){

            out.print("题目的专属号码(千万别改动它,求求你了,不然会出bug)");
            out.println("<input type=\"text\" name=\"whatans\" value=\""+questionList.get(i).getQid()+"\" />");
            out.println("<br>");
            out.println("<h1>"+questionList.get(i).getQuestionchar()+"</h1>");
            out.println("<br>");
            out.println(" <textarea cols=\"40\" rows=\"20\" name=\"anses\">在这里写答案</textarea><br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
        }

        out.println("<input class=\"btn1\" type=\"submit\" value=\"提交\">");
        out.println("<input class=\"btn1\" type=\"reset\" value=\"重置\">");
        out.println("</form>");
        out.println("</body></html>");
    }



    //增加问题
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String questionchar = req.getParameter("questionchar");
        Question question=new Question(null,questionchar,username);
        int row=questionService.addQuestion(question);
        if (row>0){
            resp.sendRedirect("/QuestionAddOk.html");
        }else {
            resp.sendRedirect("/QuestionAddNo.html");
        }
    }



    //管理员删除问题
    private void remove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username=req.getParameter("username");
        int row=questionService.removeQuestion(username);
        resp.setContentType("text/html"); // 设置响应内容类型为text/html
        PrintWriter out = resp.getWriter();
        if (row>0){
            out.println("删除成功,请自行返回");
        }else{
            out.println("删除失败,请自行返回");
        }
    }

}
