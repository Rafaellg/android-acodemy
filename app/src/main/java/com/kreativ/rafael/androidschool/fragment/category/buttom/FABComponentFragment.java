package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;

public class FABComponentFragment extends CustomFragment {

    private FloatingActionButton fabDemo;

    public FABComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fab_component, container, false);

        fabDemo = (FloatingActionButton) view.findViewById(R.id.fabDemo);
        fabDemo.setBackgroundResource(R.drawable.ic_touch_app_white_24dp);
        fabDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void setColor(int color) {
//        fabDemo.setBackgroundColor(color);
        fabDemo.setBackgroundTintList(ColorStateList.valueOf(color));
    }

}
