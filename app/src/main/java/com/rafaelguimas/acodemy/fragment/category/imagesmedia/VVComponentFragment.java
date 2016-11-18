package com.rafaelguimas.acodemy.fragment.category.imagesmedia;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.VideoView;

import com.rafaelguimas.acodemy.R;
import com.rafaelguimas.acodemy.util.CustomFragment;

public class VVComponentFragment extends CustomFragment {

    public VVComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vv_component, container, false);

        // Altera o BG
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        frameLayout.setBackgroundColor(getResources().getColor(R.color.white));

        VideoView videoViewDemo = (VideoView) view.findViewById(R.id.videoViewDemo);
        videoViewDemo.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.google_comercial));
        videoViewDemo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoViewDemo.start();

        return view;
    }

}
