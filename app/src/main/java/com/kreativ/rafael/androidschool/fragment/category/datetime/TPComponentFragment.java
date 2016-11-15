package com.kreativ.rafael.androidschool.fragment.category.datetime;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;

public class TPComponentFragment extends CustomFragment {

    public TPComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tp_component, container, false);

        final TimePicker timePickerDemo = (TimePicker) view.findViewById(R.id.timePickerDemo);
        timePickerDemo.setIs24HourView(true);

        Button buttonDemo = (Button) view.findViewById(R.id.buttonDemo);
        buttonDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    message = timePickerDemo.getHour() + ":" + timePickerDemo.getMinute();
                } else {
                    message = timePickerDemo.getCurrentHour() + ":" + timePickerDemo.getCurrentMinute();
                }
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
