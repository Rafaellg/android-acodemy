package com.rafaelguimas.acodemy.fragment.category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rafaelguimas.acodemy.R;
import com.rafaelguimas.acodemy.activity.MainActivity;
import com.rafaelguimas.acodemy.fragment.DemoFragment;
import com.rafaelguimas.acodemy.util.EnumComponent;

public class CategoryImagesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_image_media, container, false);

        // Get buttons from screen
        Button btnImageButton = (Button) view.findViewById(R.id.btnImageButton);
        Button btnImageView = (Button) view.findViewById(R.id.btnImageView);
        Button btnVideoView = (Button) view.findViewById(R.id.btnVideoView);

        // Set buttons click
        btnImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.BtnImage);
            }
        });
        btnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.ImageView);
            }
        });
        btnVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.VideoView);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Define o título da activity
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_cat_image_media));
    }

    public void openFragment(EnumComponent enumComponent) {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, DemoFragment.newInstance(enumComponent))
                .addToBackStack(null)
                .commit();
    }
}
