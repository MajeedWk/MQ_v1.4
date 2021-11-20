package com.example.mq_v13;

public class TimeCheck {
    String TimeSetting, ParkingSetting;

    public TimeCheck() {
    }

    public TimeCheck(String time) {
        TimeSetting = time;

    }

    public String getParkingSetting() {
        return ParkingSetting;
    }

    public void setParkingSetting(String parkingSetting) {
        ParkingSetting = parkingSetting;
    }

    public String getTime() {
        return TimeSetting;
    }

    public void setTime(String time) {
        TimeSetting = time;
    }
}
