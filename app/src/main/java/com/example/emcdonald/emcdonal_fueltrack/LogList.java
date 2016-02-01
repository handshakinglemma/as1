package com.example.emcdonald.emcdonal_fueltrack;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by emcdonald on 01/02/16.
 * Inspired by LonelyTwitter code from CMPUT 301 labs.
 * https://github.com/handshakinglemma/lonelyTwitter/tree/w16Thursday as of Feb-1-16.
 */

// TODO: Missing method functionality.
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

    public LogEntry editEntry(LogEntry entry) {
        return entry; }

}