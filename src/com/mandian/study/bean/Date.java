package com.mandian.study.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

public class Date implements Serializable {
    private Integer id;
    private java.sql.Date day;

    @Override
    public String toString() {
        return "Date{" +
                "id=" + id +
                ", day=" + day +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.sql.Date getDay() {
        return day;
    }

    public void setDay(java.sql.Date day) {
        this.day = day;
    }
}
