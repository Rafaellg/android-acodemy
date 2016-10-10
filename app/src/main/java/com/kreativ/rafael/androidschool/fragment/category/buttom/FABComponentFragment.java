package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bq.markerseekbar.MarkerSeekBar;
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
            setColor();
        } else if (which == 1) {
            setSize();
        } else if (which == 2) {
            Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
        }
    }

    public void setColor() {
        int color = R.color.black;
        fabDemo.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(color)));
    }

    public void setSize() {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_size, null);

        final MarkerSeekBar sekWidth = (MarkerSeekBar) view.findViewById(R.id.sekWidth);
        final MarkerSeekBar sekHeight = (MarkerSeekBar) view.findViewById(R.id.sekHeight);
        final TextView txtWidth = (TextView) view.findViewById(R.id.txtWidth);
        final TextView txtHeight = (TextView) view.findViewById(R.id.txtHeight);

        sekWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtWidth.setText(seekBar.getProgress() + "dp");
            }
        });

        sekHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtHeight.setText(seekBar.getProgress() + "dp");
            }
        });

        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setView(view);
        dialog.setNeutralButton(R.string.text_apply, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int width = sekWidth.getProgress();
                int height = sekHeight.getProgress();

                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = Gravity.CENTER;

                fabDemo.setLayoutParams(layoutParams);
            }
        });
        dialog.show();
    }

}
