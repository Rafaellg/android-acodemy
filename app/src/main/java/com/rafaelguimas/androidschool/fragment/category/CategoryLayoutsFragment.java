package com.rafaelguimas.androidschool.fragment.category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rafaelguimas.androidschool.R;
import com.rafaelguimas.androidschool.activity.MainActivity;
import com.rafaelguimas.androidschool.fragment.DemoFragment;
import com.rafaelguimas.androidschool.util.EnumComponent;

public class CategoryLayoutsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_layouts, container, false);

        // Get buttons from screen
        Button btnGridLayout = (Button) view.findViewById(R.id.btnGridLayout);
        Button btnLinearLayoutVertical = (Button) view.findViewById(R.id.btnLinearLayoutVertical);
        Button btnLinearLayoutHorizontal = (Button) view.findViewById(R.id.btnLinearLayoutHorizontal);
        Button btnRelativeLayout = (Button) view.findViewById(R.id.btnRelativeLayout);

        // Set buttons click
        btnGridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.GridLayout);
            }
        });
        btnLinearLayoutVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.LinearLayoutVertical);
            }
        });
        btnLinearLayoutHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.LinearLayoutHorizontal);
            }
        });
        btnRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.RelativeLayout);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Define o título da activity
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_cat_layouts));
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
