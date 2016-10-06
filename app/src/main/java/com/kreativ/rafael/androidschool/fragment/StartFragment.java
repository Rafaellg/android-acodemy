package com.kreativ.rafael.androidschool.fragment;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.activity.MainActivity;
import com.roger.gifloadinglibrary.GifLoadingView;

public class StartFragment extends Fragment {

    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://github.com/Rafaellg/android-school-app";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        fab.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;
            private MediaPlayer mpintro;
            private GifLoadingView mGifLoadingView;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mHandler != null) return true;

                        Log.d("EASTER EGG", "PREPARANDO EASTER EGG...");
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 5000);
                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mpintro.stop();
                        mGifLoadingView.dismiss();
                        mHandler = null;
                        break;
                }
                return false;
            }

            Runnable mAction = new Runnable() {
                @Override public void run() {
                    mGifLoadingView = new GifLoadingView();
                    mGifLoadingView.setImageResource(R.drawable.gif_terry);
                    mGifLoadingView.show(getActivity().getFragmentManager(), "");

                    mpintro = MediaPlayer.create(getContext(), R.raw.hora_do_show);
                    mpintro.setLooping(true);
                    mpintro.start();
                }
            };
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Define o título da activity
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.app_name));
    }

}
