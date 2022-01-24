package com.mandian.study.biz;

import com.mandian.study.bean.Seat;
import com.mandian.study.bean.Status;
import com.mandian.study.dao.SeatDao;
import com.mandian.study.dao.StatusDao;

import java.sql.SQLException;
import java.util.List;

public class SeatBiz {
    SeatDao seatDao = new SeatDao();
    public List<Seat> showSeatAccordingToRoomId(Long id) {
        StatusDao statusDao = new StatusDao();
        List<Seat> seats = null;
        try {
            seats = seatDao.showSeatAccordingToRoomId(id);
            for (Seat s : seats) {
                long statusId = s.getStatusId();
                Status status = statusDao.getStatusNameById(statusId);
                s.setStatus(status);
            }
            return seats;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seats;
    }


    public Seat getSeatById(Long seatId) {
        Seat seat = null;
        try {
            seat = seatDao.getSeatById(seatId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seat;
    }
}
