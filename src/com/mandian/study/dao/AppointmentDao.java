package com.mandian.study.dao;

import com.mandian.study.bean.Appointment;
import com.mandian.study.bean.Room;
import com.mandian.study.util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class AppointmentDao {
    QueryRunner runner = new QueryRunner();

    public List<Appointment> getAppointmentBySeatId(Long seatId) throws SQLException {
        /*Connection conn = DBHelper.getConnection();
        String sql = "select * from room";
        List<Room> rooms = runner.query(conn, sql, new BeanListHandler<>(Room.class));
        conn.close();
        return rooms;*/
        Connection conn = DBHelper.getConnection();
        String sql = "select * from appointment where seatId=?";
        List<Appointment> appointments = runner.query(conn,sql,new BeanListHandler<>(Appointment.class),seatId);
        conn.close();
        return appointments;
    }

    public List<Appointment> getExpiredAppointments(long dateId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "SELECT * FROM appointment where dateId < ?";
        List<Appointment> appointments = runner.query(conn,sql,new BeanListHandler<>(Appointment.class),dateId);
        conn.close();
        return appointments;
    }
    public void deleteExpiredAppointments(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from appointment where dateId < ?";
        runner.update(conn,sql,id);
        conn.close();
    }

    public int addAppointment(long userId, long seatId, long dateId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "INSERT INTO appointment VALUES (null, ?, ?, ?)";
        int count = runner.update(conn,sql,userId,seatId,dateId);
        conn.close();
        return count;
    }

    public List<Appointment> getAllAppointments(long userId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "SELECT * FROM appointment WHERE userId = ?";
        List<Appointment> appointments = runner.query(conn,sql,new BeanListHandler<>(Appointment.class),userId);
        conn.close();
        return appointments;
    }

    public int deleteAppointment(long appointmentId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "DELETE FROM appointment WHERE id = ?";
        int count = runner.update(conn,sql,appointmentId);
        return count;
    }

    public static void main(String[] args) throws SQLException {
        AppointmentDao dao = new AppointmentDao();
        /*List<Appointment> expired = dao.getExpiredAppointments(5);
        for (Appointment app : expired) {
            System.out.println(app.toString());
        }*/
        dao.deleteExpiredAppointments(2);
    }



}
