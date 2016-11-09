package com.kreativ.rafael.androidschool.fragment.category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.activity.MainActivity;
import com.kreativ.rafael.androidschool.fragment.DemoFragment;
import com.kreativ.rafael.androidschool.util.EnumComponent;

public class CategoryWidgetsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_widgets, container, false);

        // Get buttons from screen
        Button btnTextView = (Button) view.findViewById(R.id.btnTextView);
        Button btnSimpleButton = (Button) view.findViewById(R.id.btnSimpleButton);
        Button btnFloatingActionButton = (Button) view.findViewById(R.id.btnFloatActionButton);
        Button btnRadioButton = (Button) view.findViewById(R.id.btnRadioButton);
        Button btnToggleButton = (Button) view.findViewById(R.id.btnToggleButton);

        // Set buttons click
        btnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.TextView);
            }
        });
        btnSimpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.BtnSimple);
            }
        });
        btnFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.BtnFAB);
            }
        });
        btnRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.BtnRadio);
            }
        });
        btnToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.BtnToggle);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Define o título da activity
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_cat_widgets));
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
