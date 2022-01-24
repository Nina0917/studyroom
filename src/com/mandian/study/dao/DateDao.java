package com.mandian.study.dao;

import com.mandian.study.bean.Date;
import com.mandian.study.bean.Room;
import com.mandian.study.biz.AppointmentBiz;
import com.mandian.study.util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DateDao {
    QueryRunner runner = new QueryRunner();
    public Date getDatesById(long dateId) throws SQLException {
        /*Connection conn = DBHelper.getConnection();
        String sql = "select * from room";
        List<Room> rooms = runner.query(conn, sql, new BeanListHandler<>(Room.class));
        conn.close();
        return rooms;*/
        Connection conn = DBHelper.getConnection();
        String sql = "select * from `date` where id = ?";
        Date date = runner.query(conn, sql, new BeanHandler<>(com.mandian.study.bean.Date.class), dateId);
        conn.close();
        return date;

    }

    public long getAccordingId(String day) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from date where day = ?";
        Date date = runner.query(conn,sql,new BeanHandler<>(Date.class),day);
        conn.close();
        return date.getId();
    }

    public static void main(String[] args) throws SQLException {
        DateDao dao = new DateDao();
        System.out.println(dao.getAccordingId("2022-01-20"));



    }
}
