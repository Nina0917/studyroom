package com.mandian.study.biz;

import com.mandian.study.bean.Room;
import com.mandian.study.dao.RoomDao;

import java.sql.SQLException;
import java.util.List;

public class RoomBiz {
    RoomDao roomDao = new RoomDao();
    public List<Room> getAll() {
        /*List<Type> types=null;
        try {
            types = typeDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;*/
        List<Room> rooms = null;
        try {
            rooms=roomDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
