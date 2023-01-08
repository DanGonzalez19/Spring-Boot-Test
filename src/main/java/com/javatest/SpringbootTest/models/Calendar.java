package com.javatest.SpringbootTest.models;

import java.time.LocalTime;

public class Calendar {
    String locationID;
    String Day;
    LocalTime cutOffTime;

    public Calendar(String locationID, String day, String cutOffTime) {
        this.locationID = locationID;
        Day = day;
        this.cutOffTime = LocalTime.parse(cutOffTime);
        System.out.println(this.cutOffTime.getHour());
    }

    public Calendar() {
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public LocalTime getCutOffTime() {
        return cutOffTime;
    }

    public void setCutOffTime(LocalTime cutOffTime) {
        this.cutOffTime = cutOffTime;
    }

    public boolean IsAvailable(String day, int hour, int minutes){

        return ((this.Day.equals("ALL") || this.Day.equals(day)) &&
                (hour*60+minutes<this.cutOffTime.getHour()*60+this.cutOffTime.getMinute()) );
    }
}
