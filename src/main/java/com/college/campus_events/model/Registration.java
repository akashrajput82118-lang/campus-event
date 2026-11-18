package com.college.campus_events.model;

public class Registration {

    private Long id;
    private String participantName;
    private String email;
    private String eventName;

    public Registration() {
    }

    public Registration(Long id, String participantName,
                        String email, String eventName) {
        this.id = id;
        this.participantName = participantName;
        this.email = email;
        this.eventName = eventName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}