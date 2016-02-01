package com.example.emcdonald.emcdonal_fueltrack;

import android.app.Application;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

// TODO: Finish tests.
public class ApplicationTest extends ActivityInstrumentationTestCase2 {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testRemoveEntry() {
        LogList log = new LogList();
        LogEntry entry = new LogEntry("2016-01-18, Costco, 200123.5 km, regular, 40.234 L, 79.4 cents/L");

        log.addEntry(entry);
        log.removeEntry(entry);

        // assertFalse(log.hasEntry(entry));
        // Don't have a method that checks if an entry exists.
    }


}