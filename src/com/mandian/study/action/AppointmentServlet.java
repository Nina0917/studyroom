package com.mandian.study.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.*;
import com.mandian.study.bean.*;
import com.mandian.study.biz.AppointmentBiz;

@WebServlet("/appointment.let")
// appointment.let?type=getAll 获取当前用户所有未使用的预约
//appointment.let?type=cancel&id=? 取消预约
public class AppointmentServlet extends HttpServlet {
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
            //获取当前用户所有未使用的预约
            case "getAll":
                getAllAppointments(req, resp,user.getId());
                break;
            //取消预约
            case "cancel":
                long appointmentId = Long.parseLong(req.getParameter("id"));
                cancelAppointment(out, appointmentId);
                break;
        }
    }

    private void cancelAppointment(PrintWriter out, long appointmentId) {
        //根据id直接删除appointment表里的记录
        AppointmentBiz appointmentBiz = new AppointmentBiz();
        int count = appointmentBiz.deleteAppointment(appointmentId);
        //删除成功后 提示 删除成功 跳转到已预约界面
        if (count>0) {
            out.println("<script>alert('预约删除成功'); location.href='appointment.let?type=getAll';</script>");
        } else {
            out.println("<script>alert('删除失败！'); location.href='appointment.let?type=getAll';</script>");
        }
    }

    private void getAllAppointments(HttpServletRequest req, HttpServletResponse resp, long userId) throws ServletException, IOException {
        AppointmentBiz appointmentBiz = new AppointmentBiz();
        List<Appointment> appointments = appointmentBiz.getAllAppointments(userId);
        req.setAttribute("appointments",appointments);
        req.getRequestDispatcher("appointment_list.jsp").forward(req,resp);
    }
}
