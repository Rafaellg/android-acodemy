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

public class CategoryTextFieldsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_text_fields, container, false);

        // Get buttons from screen
        Button btnEditText = (Button) view.findViewById(R.id.btnEditText);

        // Set buttons click
        btnEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EnumComponent.EditText);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Define o título da activity
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_cat_text_fields));
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
