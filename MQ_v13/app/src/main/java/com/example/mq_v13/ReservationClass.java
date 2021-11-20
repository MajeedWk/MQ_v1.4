package com.example.mq_v13;

public class ReservationClass {
    String time, parking;

    public ReservationClass() {
    }

    public ReservationClass(String time, String parking) {

        this.time = time;
        this.parking = parking;


    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }


}
