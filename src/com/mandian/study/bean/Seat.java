package com.mandian.study.bean;

import java.io.Serializable;

public class Seat implements Serializable {
    private long id;
    private long roomId;
    private long statusId;

    private Status status;

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", statusId=" + statusId +
                ", status=" + status +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
