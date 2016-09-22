package com.kreativ.rafael.androidschool.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreativ.rafael.androidschool.R;

/**
 * Created by Rafael on 21/09/2016.
 */

public class CustomFragment extends Fragment {

    public CustomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fab_component, container, false);

        return view;
    }

    public void setColor(int color) {

    }

    public void setSize(int h, int w) {

    }

    public void setIcon(int drawable) {

    }
}
