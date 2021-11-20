package com.example.mq_v13;

public class ParkingSpace {
     String Parking;
     String Time;


    public ParkingSpace(String parking, String time) {
        Parking = parking;
        Time = time;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getParking() {
        return Parking;
    }

    public void setParking(String parking) {
        Parking = parking;
    }

    public ParkingSpace() {

    }
}
