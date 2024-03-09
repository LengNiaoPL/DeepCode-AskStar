package com.gdut.controller;

import com.gdut.pojo.Ans;
import com.gdut.pojo.Question;
import com.gdut.service.AnsService;
import com.gdut.service.QuestionService;
import com.gdut.service.impl.AnsServiceImpl;
import com.gdut.service.impl.QuestionServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ans/*")
public class AnsController extends BaseController {
    AnsService ansService = new AnsServiceImpl();

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //Integer whatans = Integer.getInteger(req.getParameter("whatans"));//留下错误代码给人嘲笑

        String anses = req.getParameter("anses");
        int whatans = Integer.parseInt(req.getParameter("whatans"));
        System.out.println(whatans);

        Ans ans = new Ans(null, anses, whatans);

        int row = ansService.addAns(ans);

        resp.setContentType("text/html"); // 设置响应内容类型为text/html
        PrintWriter out = resp.getWriter();

        if (row > 0) {
            out.println("<html>");
            out.println("<head><title>回答成功</title></head>");
            out.println("<body>");
            out.println("<h1>" + "回答成功" + "</h1>");
            out.println("<a href=\"/loginSuccess.html\">点击返回</a>");
            out.println("</body></html>");
        } else {
            out.println("<html>");
            out.println("<head><title>回答失败</title></head>");
            out.println("<body>");
            out.println("<h1>" + "回答失败" + "</h1>");
            out.println("<a href=\"/ansQuestion.html\">点击返回</a>");
            out.println("</body></html>");
        }

    }

    private void findAns(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        QuestionService questionService=new QuestionServiceImpl();
        String username = req.getParameter("username");
        List<Question> questionList=questionService.findQuestion(username);
        resp.setContentType("text/html"); // 设置响应内容类型为text/html
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>查看答案</title></head>");
        out.println("<body>");
        out.println("<h1>以下是调查结果</h1>");

        for (int i=0;i<questionList.size();i++){
            out.print("<h1>");
            out.print("T"+(i+1));
            out.println("</h1>");
            out.println("<h1>"+questionList.get(i).getQuestionchar()+"</h1>");
            List<Ans> ansList=ansService.findAns(questionList.get(i).getQid());
            for (int j=0;j<ansList.size();j++){
                out.print("<h3>");
                out.print("("+(j+1)+")");
                out.println("</h3>");
                out.println("<br>");
                out.println("<h3>"+ansList.get(j).getAnses()+"</h3>");
                out.println("<br>");
            }
            out.println("<br>");
            out.println("<br>");
        }


        out.println("</body></html>");

    }


}



