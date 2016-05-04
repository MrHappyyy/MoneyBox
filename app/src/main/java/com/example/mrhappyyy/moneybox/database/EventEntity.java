package com.example.mrhappyyy.moneybox.database;

public class EventEntity {
    private int id;
    private String event;
    private String dateEvent;

    public EventEntity(int id, String event, String dateEvent) {
        this.id = id;
        this.event = event;
        this.dateEvent = dateEvent;
    }

    public int getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }
}
