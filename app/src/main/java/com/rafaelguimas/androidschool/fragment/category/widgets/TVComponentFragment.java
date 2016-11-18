package com.rafaelguimas.androidschool.fragment.category.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rafaelguimas.androidschool.R;
import com.rafaelguimas.androidschool.util.CustomFragment;

public class TVComponentFragment extends CustomFragment {

    private TextView textViewDemo;

    public TVComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_component, container, false);

        textViewDemo = (TextView) view.findViewById(R.id.textViewDemo);
        textViewDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    textViewDemo.setText(R.string.text_goodbye_world);
            }
        });

        return view;
    }

}
