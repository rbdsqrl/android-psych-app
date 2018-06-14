package com.rbdsqrl.mindsafe.util;

import com.rbdsqrl.mindsafe.pojo.Event;

public class MEvent {
    public static Event createEvent(String eventDesc, String eventName, String moodAfter, String moodBefore){
        return new Event(eventName, eventDesc, moodAfter, moodBefore, DateTimeUtil.getCurrentTimeFormatted());
    }
}
