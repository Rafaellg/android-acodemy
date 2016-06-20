package com.kreativ.rafael.androidschool.fragment.category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.activity.MainActivity;
import com.kreativ.rafael.androidschool.fragment.DemoFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.FloatingActionButtonCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.FloatingActionButtonComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.FloatingtActionButtonXMLFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.SimpleButtonCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.SimpleButtonComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.SimpleButtonXMLFragment;

public class CategoryButtonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_button, container, false);

        // Get buttons from screen
        Button btnSimpleButton = (Button) view.findViewById(R.id.btnSimpleButton);
        Button btnFloatActionButton = (Button) view.findViewById(R.id.btnFloatActionButton);
        Button btnRadioButton = (Button) view.findViewById(R.id.btnRadioButton);
        Button btnToggleButton = (Button) view.findViewById(R.id.btnToggleButton);
        Button btnImageButton = (Button) view.findViewById(R.id.btnImageButton);

        // Set buttons click
        btnSimpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DemoFragment demoFragment = DemoFragment.newInstance(getString(R.string.item_simple_btn),
                        new SimpleButtonComponentFragment(),
                        new SimpleButtonCodeFragment(),
                        new SimpleButtonXMLFragment());
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, demoFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        btnFloatActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DemoFragment demoFragment = DemoFragment.newInstance(getString(R.string.item_floating_btn),
                        new FloatingActionButtonComponentFragment(),
                        new FloatingActionButtonCodeFragment(),
                        new FloatingtActionButtonXMLFragment());
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, demoFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        btnRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Em desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });
        btnToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Em desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });
        btnImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Em desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Define o título da activity
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.cat_buttom));
    }
}
