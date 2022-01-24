package com.mandian.study.dao;

import com.mandian.study.bean.Room;
import com.mandian.study.bean.Status;
import com.mandian.study.util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StatusDao {
    //创建QueryRunner对象,在dbutils的jar包里
    QueryRunner runner = new QueryRunner();


    public Status getStatusNameById(long statusId) throws SQLException {
        /*Connection conn = DBHelper.getConnection();
        String sql = "select * from room";
        List<Room> rooms = runner.query(conn, sql, new BeanListHandler<>(Room.class));
        conn.close();
        return rooms;*/
        Connection conn = DBHelper.getConnection();
        String sql = "SELECT * FROM status where id=?";
        Status status = runner.query(conn, sql, new BeanHandler<>(Status.class), statusId);
        return status;
    }
}
