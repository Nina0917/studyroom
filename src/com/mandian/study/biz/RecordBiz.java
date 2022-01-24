package com.mandian.study.biz;

import com.mandian.study.bean.Date;
import com.mandian.study.bean.Record;
import com.mandian.study.dao.DateDao;
import com.mandian.study.dao.RecordDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordBiz {
    RecordDao recordDao = new RecordDao();

    public List<Record> getAllRecords(long userId) {
        List<Record> records = new ArrayList<>();
        DateDao dateDao = new DateDao();
        try {
            records = recordDao.getAllRecords(userId);
            //把record对象里的日期给处理一下
            for (Record r : records){
                Long dateId = r.getDateId();
                Date datesById = dateDao.getDatesById(dateId);
                r.setDate(datesById.getDay().toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}
