package com.rafaelguimas.acodemy.fragment.category.datetime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.rafaelguimas.acodemy.R;
import com.rafaelguimas.acodemy.util.CustomFragment;

import java.util.Calendar;

public class DPComponentFragment extends CustomFragment {

    public DPComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dp_component, container, false);

        // Altera o BG
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        frameLayout.setBackgroundColor(getResources().getColor(R.color.white));

        DatePicker datePickerDemo = (DatePicker) view.findViewById(R.id.datePickerDemo);
        Calendar calendar = Calendar.getInstance();
        datePickerDemo.init(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener(){
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
                        String message = dayOfMonth + "/" + monthOfYear + "/" + year;
                        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                    }});

        return view;
    }

}
