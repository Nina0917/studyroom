package com.mandian.study.listener;

import com.mandian.study.bean.Room;
import com.mandian.study.biz.RoomBiz;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class RoomServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取当前数据库中的所有room
        RoomBiz roomBiz = new RoomBiz();
        List<Room> rooms = roomBiz.getAll();

        //2.获取application对象
        ServletContext application = servletContextEvent.getServletContext();

        //3.将信息存在application中
        application.setAttribute("rooms",rooms);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
