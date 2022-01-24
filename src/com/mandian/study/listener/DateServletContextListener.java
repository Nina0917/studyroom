package com.mandian.study.listener;

import com.mandian.study.bean.Appointment;
import com.mandian.study.dao.AppointmentDao;
import com.mandian.study.dao.DateDao;
import com.mandian.study.dao.RecordDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
@WebListener
public class DateServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //当项目启动的时候，需要把小于当前日期的appointment移入record
        //获得当前日期
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatDay = simpleDateFormat.format(calendar1.getTime());

        //从date表里查出这个day对应的id
        //DateDao，给Date day,返回Integer id
        DateDao dateDao = new DateDao();
        AppointmentDao appointmentDao = new AppointmentDao();
        RecordDao recordDao = new RecordDao();
        try {
            long id = dateDao.getAccordingId(formatDay);

            //这个id就是dateId，再从appointment表里查小于这个id的预约，先全部查找出来，变成List
            //给long dateId，返回List<Appointment>
            List<Appointment> expiredAppointments = appointmentDao.getExpiredAppointments(id);
            //再全部删除
            appointmentDao.deleteExpiredAppointments(id);
            //再把list里的数据添加到record里面
            for (Appointment appointment : expiredAppointments) {
                recordDao.insertRecords(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
