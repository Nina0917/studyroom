package com.mandian.study.action;

import com.mandian.study.bean.Seat;
import com.mandian.study.bean.User;
import com.mandian.study.biz.AppointmentBiz;
import com.mandian.study.biz.DateBiz;
import com.mandian.study.biz.SeatBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/seat.let")
//seat.let?roomId=...
//seat.let?seatId=...
//seat.let?type=book(seatId和roomId在表单里)
public class SeatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        if (req.getParameter("type") !=null) {
            User user = (User)session.getAttribute("user");
            Long seatId = Long.parseLong(req.getParameter("seatId"));
            bookSeat(out,user.getId(), seatId, req.getParameter("date"));
        } else if (req.getParameter("roomId")!=null) {
            showSeatAccordingToRoomId(req,resp);
        }else if (req.getParameter("seatId")!=null) {
            showSeatAccordingToSeatId(req,resp);
        }



    }

    private void bookSeat(PrintWriter out, long userId, long seatId, String date) {
        //id是userId，seatId，date
        //先把String date 变成dateId
        DateBiz dateBiz = new DateBiz();
        long dateId = dateBiz.getAccordingId(date);
        //添加预约
        AppointmentBiz appointmentBiz = new AppointmentBiz();
        int count = appointmentBiz.addAppointment(userId,seatId,dateId);
        if (count > 0) {
            out.println("<script>alert('Reserve Successfully！');parent.window.location.href='index.jsp';</script>");
        } else {
            out.println("<script>alert('Reserve unsuccessfully!')</script>");
        }


    }

    private void showSeatAccordingToSeatId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Long seatId = Long.parseLong(req.getParameter("seatId"));
        SeatBiz seatBiz = new SeatBiz();
        AppointmentBiz appointmentBiz = new AppointmentBiz();
        Seat seat = seatBiz.getSeatById(seatId);
        req.setAttribute("seat",seat);

        //可预约日期
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dates = new ArrayList<>();
        dates.add(simpleDateFormat.format(calendar1.getTime()));
        for (int i = 0; i < 4; i++) {
            calendar1.add(Calendar.DATE, 1);
            dates.add(simpleDateFormat.format(calendar1.getTime()));
        }
        //根据seatId，找出预约表单里对应的时间
        List<String> notAvailableDates = appointmentBiz.getDatesBySeatId(seatId);
        //删除不可预约的时间
        for (String s : notAvailableDates) {
            if (dates.contains(s)) {
                dates.remove(s);
            }
        }


        req.setAttribute("dates",dates);

        req.getRequestDispatcher("seat_book.jsp").forward(req,resp);

    }

    /**
     * 根据room id拿出对应的所有seat的information
     * @param req
     * @param resp
     */
    private void showSeatAccordingToRoomId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("roomId"));
        SeatBiz seatBiz = new SeatBiz();
        List<Seat> seats = seatBiz.showSeatAccordingToRoomId(id);
        req.setAttribute("seats",seats);
        req.getRequestDispatcher("seat_list.jsp").forward(req,resp);

    }




}
