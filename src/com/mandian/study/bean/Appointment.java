package com.mandian.study.bean;

import java.io.Serializable;

public class Appointment implements Serializable {
    private Long id;
    private Long seatId;
    private Long userId;
    private Long dateId;

    private String date;

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", seatId=" + seatId +
                ", userId=" + userId +
                ", dateId=" + dateId +
                ", date='" + date + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }
}
