package com.rbdsqrl.mindsafe.pojo;

public class Event {
    private String eventTitle;
    private String eventDesc;
    private String afterEventMood;
    private String beforeEventMood;

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

    public Event(String eventTitle, String eventDesc, String afterEventMood, String beforeEventMood) {
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.afterEventMood = afterEventMood;
        this.beforeEventMood = beforeEventMood;
    }
}
