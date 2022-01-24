package com.mandian.study.dao;

import com.mandian.study.bean.Room;
import com.mandian.study.util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoomDao {
    //创建QueryRunner对象,在dbutils的jar包里
    QueryRunner runner = new QueryRunner();

    //获取所有房间

    public List<Room> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from room";
        List<Room> rooms = runner.query(conn, sql, new BeanListHandler<>(Room.class));
        conn.close();
        return rooms;
    }

    public static void main(String[] args) throws SQLException {
        RoomDao roomDao = new RoomDao();
        List<Room> all = roomDao.getAll();
        for (Room r : all){
            System.out.println(r);
        }
    }
}
