package com.rbdsqrl.mindsafe.pojo;

public class Event {
    private String eventTitle;
    private String eventDesc;
    private String afterEventMood;
    private String beforeEventMood;
    private String eventTime;

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getAfterEventMood() {
        return afterEventMood;
    }

    public void setAfterEventMood(String afterEventMood) {
        this.afterEventMood = afterEventMood;
    }

    public String getBeforeEventMood() {
        return beforeEventMood;
    }

    public void setBeforeEventMood(String beforeEventMood) {
        this.beforeEventMood = beforeEventMood;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Event(String eventTitle, String eventDesc, String afterEventMood, String beforeEventMood, String eventTime) {
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.afterEventMood = afterEventMood;
        this.beforeEventMood = beforeEventMood;
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventTitle='" + eventTitle + '\'' +
                ", eventDesc='" + eventDesc + '\'' +
                ", afterEventMood='" + afterEventMood + '\'' +
                ", beforeEventMood='" + beforeEventMood + '\'' +
                ", eventTime='" + eventTime + '\'' +
                '}';
    }
}
