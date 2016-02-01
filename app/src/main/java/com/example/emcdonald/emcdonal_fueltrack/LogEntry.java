package com.example.emcdonald.emcdonal_fueltrack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by emcdonal on 1/14/16.
 * Inspired by LonelyTwitter code from CMPUT 301 labs.
 * https://github.com/handshakinglemma/lonelyTwitter/tree/w16Thursday as of Feb-1-16.
 */
public abstract class LogEntry {
    protected Date date;
    protected String station;
    protected int odometer;
    protected String grade;
    protected int amount;
    protected int unitCost;
    protected int cost;

    public LogEntry(String log_input) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String delims = "[ ]+";
        String[] log_info = log_input.split(delims);
        try {
            this.date = formatter.parse(log_info[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.station = log_info[1];
        this.odometer = Integer.parseInt(log_info[2]);
        this.grade = log_info[3];
        this.amount = Integer.parseInt(log_info[4]);
        this.unitCost = Integer.parseInt(log_info[5]);
        this.cost = (unitCost * amount) / 100;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return date.toString() + " | " + station + " | " + odometer +
                " | " + grade + " | " + amount  + " | " + unitCost  +
                " | " + cost;
    }
}