package com.mandian.study.dao;

import com.mandian.study.bean.Appointment;
import com.mandian.study.bean.Record;
import com.mandian.study.util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RecordDao {
    QueryRunner runner = new QueryRunner();

    public int insertRecords(Appointment appointment) throws SQLException {
        /*Connection conn = DBHelper.getConnection();
        String sql = "select * from room";
        List<Room> rooms = runner.query(conn, sql, new BeanListHandler<>(Room.class));
        conn.close();
        return rooms;*/
        Connection conn = DBHelper.getConnection();
        String sql = "INSERT INTO record VALUES (null, ?, ?, ?)";
        int count = runner.update(conn, sql, appointment.getUserId(),appointment.getSeatId(),appointment.getDateId());
        conn.close();
        return count;
    }

    public List<Record> getAllRecords(long userId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from record where userId=?";
        List<Record> records = runner.query(conn, sql, new BeanListHandler<>(Record.class), userId);
        conn.close();
        return records;
    }
}
