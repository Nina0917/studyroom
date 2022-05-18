package com.mandian.study.action;

import com.mandian.study.bean.User;
import com.mandian.study.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user.let")
// user.let?type=login 登录
// user.let?type=exit 安全退出
//user.let?type=modifyPwd
public class UserServlet extends HttpServlet {
    UserBiz userBiz = new UserBiz();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //设置请求和相应的编码集，防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        //判断用户请求的类型
        String method = req.getParameter("type");
        switch (method) {
            case "login":
                //从login.html中获取用户名和密码
                String name = req.getParameter("name");
                String pwd = req.getParameter("pwd");

                //调用UserBiz的getUser方法，获取对应的用户对象
                User user = userBiz.getUser(name, pwd);

                //判断用户对象是否为null
                if (user == null) {
                    //为null的话表示用户名或密码不正确，提示错误，回到登录页面
                    out.println("<script>alert('User or Password does not exist');location.href = 'login.html';</script>");
                } else {
                    //非空，表示用户存在，登录成功，将用户对象保存在session中，提示登录成功后，将页面跳转到index.jsp
                    session.setAttribute("user", user);
                    out.println("<script>alert('Login successfully!');location.href='index.jsp';</script>");
                }

                break;

            case "exit":
                //1.清除session
                session.invalidate();
                //2.跳转到login.html（当前是top,需要top的parent，就是index.jsp去跳转）
                out.println("<script>parent.window.location.href='login.html';</script>");
                break;
            case "modifyPwd":
                //获取用户的id和新的密码
                String newPwd = req.getParameter("newpwd");
                long id = ((User) session.getAttribute("user")).getId();

                //调用biz层方法
                int count = userBiz.modifyPwd(id, newPwd);
                //成功修改后，跳回首页
                if (count > 0) {
                    out.println("<script>alert('modify password successfully');parent.window.location.href='login.html';</script>");
                } else {
                    out.println("<script>alert('do not successed!')</script>");
                }
                break;
        }


    }
}
