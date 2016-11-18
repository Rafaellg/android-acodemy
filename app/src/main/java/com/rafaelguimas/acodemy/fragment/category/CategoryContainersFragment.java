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

public class CategoryContainersFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_containers, container, false);

        // Get buttons from screen
        Button btnListView = (Button) view.findViewById(R.id.btnListView);
        Button btnRecyclerView = (Button) view.findViewById(R.id.btnRecyclerView);

        // Set buttons click
        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.ListView);
            }
        });
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.WebView);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Define o título da activity
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_cat_containers));
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
