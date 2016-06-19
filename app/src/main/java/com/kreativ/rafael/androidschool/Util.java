package com.kreativ.rafael.androidschool;

import android.app.Activity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;

/**
 * Created by Rafael on 19/06/2016.
 */
public class Util {

    public static BottomBar setupBottomBar(final Activity activity, Bundle savedInstanceState) {
        // Attach the action bar
        BottomBar mBottomBar = BottomBar.attach(activity, savedInstanceState);
        mBottomBar.setItems(R.menu.bottombar_menu);
        mBottomBar.useDarkTheme();
        mBottomBar.setActiveTabColor("#FFFFFF");

        return mBottomBar;
    }
}
