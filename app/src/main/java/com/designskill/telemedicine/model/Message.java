package com.designskill.telemedicine.model;

public class Message {

    String name;
    String message;
    String time;

    public Message() {
        this.name = "";
        this.message = "";
        this.time = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
