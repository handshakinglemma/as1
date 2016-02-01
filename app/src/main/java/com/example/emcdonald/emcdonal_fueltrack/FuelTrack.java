package com.example.emcdonald.emcdonal_fueltrack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by emcdonal on 1/14/16.
 * Inspired by LonelyTwitter code from CMPUT 301 labs.
 * https://github.com/handshakinglemma/lonelyTwitter/tree/w16Thursday as of Feb-1-16.
 */

// TODO: Finish implementation.
public class FuelTrack extends Activity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldLogList;

    private ArrayList<LogEntry> log = new ArrayList<LogEntry>();
    private ArrayAdapter<LogEntry> adapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id. clear);
        //oldLogList = (ListView) findViewById(R.id.oldLogList);

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();
                LogEntry newestEntry = new LogEntry(text) {
                };

                log.add(newestEntry);
                adapter.notifyDataSetChanged();

                saveInFile();

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                log.clear();
                adapter.notifyDataSetChanged();

                saveInFile();

            }
        });
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        // adapter contains reference to tweet list
        // if put a new array in, would have to make a new one? because it's just checking a
        // reference? and it will be confused otherwise?
        adapter = new ArrayAdapter<LogEntry>(this,
                R.layout.list_item, log);
        oldLogList.setAdapter(adapter);
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Took from here: https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html Jan-21-2016
            Type listType = new TypeToken<ArrayList<LogEntry>>() {}.getType();
            log = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            log = new ArrayList<LogEntry>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);
            // MODE_PRIVATE means this file can be accessed by this application only
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(log, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

}