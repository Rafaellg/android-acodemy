package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fab_component, container, false);

        fabDemo = (FloatingActionButton) view.findViewById(R.id.fabDemo);
        fabDemo.setBackgroundResource(R.drawable.ic_touch_app_white_24dp);
        fabDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void onEditOptionSelected(int which) {
        if (which == 0) {
//            setColor(R.color.black);
            Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
        } else if (which == 1) {
//            setColor(R.color.black);
            Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
        } else if (which == 2) {
//            setColor(R.color.black);
            Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
        }
    }

    public void setColor(int color) {
        fabDemo.setBackgroundTintList(ColorStateList.valueOf(color));
    }

}
