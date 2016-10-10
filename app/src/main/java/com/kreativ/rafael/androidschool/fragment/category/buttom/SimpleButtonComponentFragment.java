package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;

public class SimpleButtonComponentFragment extends CustomFragment {

    public SimpleButtonComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_button_component, container, false);

        Button btnDemo = (Button) view.findViewById(R.id.btnDemo);
        btnDemo.setText("Button");
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
