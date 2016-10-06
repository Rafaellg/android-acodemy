package com.kreativ.rafael.androidschool.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreativ.rafael.androidschool.CustomFragmentInterface;
import com.kreativ.rafael.androidschool.R;

/**
 * Modelo de fragmento para os demos
 */
public class CustomFragment extends Fragment implements CustomFragmentInterface {

    public CustomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fab_component, container, false);

        return view;
    }

    @Override
    public void onEditOptionSelected(int which) {

    }

    @Override
    public void setColor(int color) {

    }

    @Override
    public void setSize(int h, int w) {

    }

    @Override
    public void setIcon(int drawable) {

    }
}
