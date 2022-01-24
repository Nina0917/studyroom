package com.mandian.study.biz;

import com.mandian.study.bean.Appointment;
import com.mandian.study.bean.Date;
import com.mandian.study.dao.AppointmentDao;
import com.mandian.study.dao.DateDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentBiz {
    AppointmentDao appointmentDao = new AppointmentDao();


    public List<String> getDatesBySeatId(long seatId) {
        List<String> dateStrs = new ArrayList<>();
        DateDao dateDao = new DateDao();
        try {
            List<Appointment> apps = appointmentDao.getAppointmentBySeatId(seatId);
            List<Long> dateIds = new ArrayList<>();
            List<com.mandian.study.bean.Date> dates = new ArrayList<>();
            for (Appointment p : apps) {
                dateIds.add(p.getDateId());
            }
            for (Long dateId : dateIds) {
                dates.add(dateDao.getDatesById(dateId));
            }

            for (Date d : dates) {
                 dateStrs.add(d.getDay().toString());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dateStrs;
    }

    public int addAppointment(long userId, long seatId, long dateId) {
        int count = 0;
        try {
            count = appointmentDao.addAppointment(userId,seatId,dateId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Appointment> getAllAppointments(long userId) {
        List<Appointment> appointments = new ArrayList<>();
        DateDao dateDao = new DateDao();
        try {
            appointments = appointmentDao.getAllAppointments(userId);
            if (appointments.size()==0){
                return appointments;
            }
            for (Appointment app : appointments) {
                Long dateId = app.getDateId();
                //根据dateId得出对应的 String date
                Date date = dateDao.getDatesById(dateId);
                String dateStr = date.getDay().toString();
                app.setDate(dateStr);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public int deleteAppointment(long appointmentId) {
        int count=0;
        try {
            count = appointmentDao.deleteAppointment(appointmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
