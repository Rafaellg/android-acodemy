package com.rafaelguimas.acodemy.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Modelo de fragmento para os demos
 */
public class CustomFragment extends Fragment {

    public CustomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {return null;}

    public void onEditOptionSelected(int which) {}

    public void setColor(int color) {}

    public void setSize(int height, int width) {}

    public void setIcon(int drawable) {}

    public void resetProps() {}
}
