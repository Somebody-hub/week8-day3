package com.example.week8_day3.model;

public enum TaskStatus {
    NEW("New"),
    IN_PROGRESS("In progress"),
    DONE("Done"),
    CANCELED("");

    private final String statusTitle;

    TaskStatus(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    public String getStatusTitle() {
        return statusTitle;
    }
}