package com.kreativ.rafael.androidschool.fragment.category.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;

public class RBComponentFragment extends CustomFragment {

    private RadioButton radioDemo1, radioDemo2;

    public RBComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rb_component, container, false);

        radioDemo1 = (RadioButton) view.findViewById(R.id.radioDemo1);
        radioDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioDemo1.isChecked()) {
                    radioDemo2.setChecked(false);
                }
            }
        });

        radioDemo2 = (RadioButton) view.findViewById(R.id.radioDemo2);
        radioDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioDemo2.isChecked()) {
                    radioDemo1.setChecked(false);
                }
            }
        });

        return view;
    }

}
