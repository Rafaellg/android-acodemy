package com.rafaelguimas.acodemy.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rafaelguimas.acodemy.R;

/**
 * Created by Rafael on 17/11/2016.
 */

public class FirebaseUtil {

    public static String saveClassification(int stars, String obs, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.title_shared_preferences), -1);
        String key = sharedPreferences.getString(context.getString(R.string.pref_firebase_key), "---");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference classRef = database.getReference("classification");

        if (key.equals("---")) {
            key = classRef.push().getKey();
        }

        classRef.child(key).child(context.getString(R.string.fire_stars)).setValue(stars);
        classRef.child(key).child(context.getString(R.string.fire_obs)).setValue(obs);

        return key;
    }
}
