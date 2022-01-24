package com.mandian.study.action;


import com.mandian.study.bean.Room;
import com.mandian.study.biz.RoomBiz;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/room.let")
public class RoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2.获取各种对象
        PrintWriter out = resp.getWriter();
        ServletContext application = req.getServletContext();

        //3.根据用户需求完成业务
        String type = req.getParameter("type");

        switch (type) {
            case "getAll":
                getAll(req, resp, out, application);
                break;
        }

    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp, PrintWriter out, ServletContext application) {
        RoomBiz roomBiz = new RoomBiz();
        List<Room> rooms = roomBiz.getAll();
        if (rooms==null){
            out.println("<script>alert('房间查询错误');location.href='index.jsp';</script>");
        } else {
            application.setAttribute("rooms",rooms);
        }
    }
}
