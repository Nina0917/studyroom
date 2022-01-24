package com.mandian.study.biz;

import com.mandian.study.dao.DateDao;

import java.sql.SQLException;

public class DateBiz {
    DateDao dateDao = new DateDao();

    public long getAccordingId(String day) {
        long id = 0;
        try {
            id = dateDao.getAccordingId(day);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
