package com.example.emcdonald.emcdonal_fueltrack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by emcdonal on 1/14/16.
 */
public abstract class LogEntry {
    protected String message;
    private Date date;

    public LogEntry(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public LogEntry(String message) {
        this.message = message;
        this.date = new Date(System.currentTimeMillis());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }

    public String getMessage() {
        return this.message;
    }
}