package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;

public class FloatingActionButtonComponentFragment extends Fragment {

    public FloatingActionButtonComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_floating_action_button_component, container, false);

        FloatingActionButton fabDemo = (FloatingActionButton) view.findViewById(R.id.fabDemo);
        fabDemo.setBackgroundResource(R.drawable.ic_touch_app_white_24dp);
        fabDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
