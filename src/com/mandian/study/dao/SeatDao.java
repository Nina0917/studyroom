package com.mandian.study.dao;

import com.mandian.study.bean.Room;
import com.mandian.study.bean.Seat;
import com.mandian.study.util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SeatDao {
    //创建QueryRunner对象,在dbutils的jar包里
    QueryRunner runner = new QueryRunner();


    public List<Seat> showSeatAccordingToRoomId(Long id) throws SQLException {
        /*Connection conn = DBHelper.getConnection();
        String sql = "select * from room";
        List<Room> rooms = runner.query(conn, sql, new BeanListHandler<>(Room.class));
        conn.close();
        return rooms;*/
        Connection connection = DBHelper.getConnection();
        String sql = "SELECT * FROM seat where roomId=?";
        List<Seat> seats = runner.query(connection, sql, new BeanListHandler<>(Seat.class), id);
        connection.close();
        return seats;

    }

    public Seat getSeatById(Long seatId) throws SQLException {
        Connection connection = DBHelper.getConnection();
        String sql = "select * from seat where id = ?";
        Seat seat = runner.query(connection, sql, new BeanHandler<>(Seat.class),seatId);
        connection.close();
        return seat;
    }

    public static void main(String[] args) {
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dates = new ArrayList<>();
        dates.add(simpleDateFormat.format(calendar1.getTime()));


        for (int i = 0; i < 4; i++) {
            calendar1.add(Calendar.DATE, 1);
            dates.add(simpleDateFormat.format(calendar1.getTime()));
        }




        //System.out.println(localDate.toString());
    }
}
