package com.college.campus_events.model;

import java.time.LocalDate;

public class Event {

    private int id;
    private String name;
    private String venue;
    private LocalDate eventDate;
    private int capacity;

    public Event(int id, String name, String venue, LocalDate eventDate, int capacity){
        this.id = id;
        this.name = name;
        this.venue = venue;
        this.eventDate = eventDate;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getVenue(){
        return venue;
    }

    public void setVenue(String venue){
        this.venue = venue;
    }

    public LocalDate getEventDate(){
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate){
        this.eventDate = eventDate;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}
