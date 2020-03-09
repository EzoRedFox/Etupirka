package com.poronitay.etupirka.common.util;

public class TimeWatch {

    private final long startTime;

    public TimeWatch() {

        startTime = System.currentTimeMillis();

    }

    public String getTimeString() {
        long time = System.currentTimeMillis() - startTime;
        String timeString = (time / 1000) + "." + (time % 1000);
        return timeString + "秒";

    }

}
