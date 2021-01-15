package com.webspoon.coding.challange.services;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Component
public class Util {

    public Timestamp addedSeconds(Integer secondsIn) {

        Date date = new Date();

        // Convert Date to Calendar
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        if (secondsIn != null) {
            c.add(Calendar.SECOND, secondsIn);
        } else {
            c.add(Calendar.SECOND, 30);
        }

        // get the currentdate
        Date currentDatePlusOne = c.getTime();

        return new Timestamp(currentDatePlusOne.getTime());
    }

    public  Integer checkSecondDifference(Timestamp timestamp) {

        Date timestampDateTime = new Date(timestamp.getTime());
        Date nowTime = new Date();

        Long different = nowTime.getTime() - timestampDateTime.getTime();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;


        return (int) elapsedSeconds;

    }

    public Timestamp checkTime(Integer second) {
        if (second == null) {
            return addedSeconds(null);
        }
        return addedSeconds(second);

    }
}
