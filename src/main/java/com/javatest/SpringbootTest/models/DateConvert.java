package com.javatest.SpringbootTest.models;

import java.util.Date;
import java.util.Calendar;


public class DateConvert {
    public static int getDayOfWeek(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
    public static int getHourOfDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    public static int getMinutesOfDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    public static int getMinutes(int hours, int minutes){
        return hours*60+minutes;
    }

    public static Date addDaysToDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        return calendar.getTime();
    }

}
