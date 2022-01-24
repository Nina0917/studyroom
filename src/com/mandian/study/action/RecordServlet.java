package com.mandian.study.action;

import com.mandian.study.bean.Record;
import com.mandian.study.bean.User;
import com.mandian.study.biz.RecordBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/record.let")
//./record.let?type=getAll
public class RecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        //获取session中的user
        User user = (User)session.getAttribute("user");
        //判断type
        String method = req.getParameter("type");
        switch (method) {
            case "getAll":
                getAllRecords(req, resp,user.getId());
                break;
        }
    }

    private void getAllRecords(HttpServletRequest req, HttpServletResponse resp, long userId) throws ServletException, IOException {
        //根据用户的id获取之前所有的预约记录
        RecordBiz recordBiz = new RecordBiz();
        List<Record> records = recordBiz.getAllRecords(userId);
        req.setAttribute("records",records);
        req.getRequestDispatcher("record_list.jsp").forward(req,resp);
    }

}
