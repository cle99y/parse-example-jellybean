package com.clackityclack.parseproject;

import android.app.Application;
import android.util.Log;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

/**
 * Created by cle99 on 09/02/2017.
 */

public class StartParse extends Application {

    String appID = "____appID____";
    String masterKey = "____masterKey____";
        String serverURL = "____serverID____";

    @Override
    public void onCreate() {
        super.onCreate(); //


        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId(appID)
                .clientKey(masterKey)
                .server(serverURL)
                .build()
        );

        ParseObject example = new ParseObject("NewObject");
        example.put("myNumber", "009");
        example.put("myString", "Bond, James Pond");

        example.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.i("Parse result", "Cracking");
                } else {
                    Log.i("Parse result", "Not so good");
                }
            }
        });

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
