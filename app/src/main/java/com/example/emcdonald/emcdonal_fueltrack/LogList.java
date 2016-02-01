package com.example.emcdonald.emcdonal_fueltrack;

import java.util.ArrayList;

/**
 * Created by emcdonald on 01/02/16.
 */
public class LogList {
    private ArrayList<LogEntry> log = new ArrayList<LogEntry>();

    public void addEntry(LogEntry entry) {
        log.add(entry);
    }

    public LogEntry getEntry(int index) {
        return log.get(index);
    }

    public void removeEntry(LogEntry entry) {
        log.remove(entry);
    }

    public int getCount() {
        return log.size();
    }

}