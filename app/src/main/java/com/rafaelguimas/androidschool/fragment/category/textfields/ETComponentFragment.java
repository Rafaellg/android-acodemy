package com.rafaelguimas.androidschool.fragment.category.textfields;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rafaelguimas.androidschool.R;
import com.rafaelguimas.androidschool.util.CustomFragment;

public class ETComponentFragment extends CustomFragment {

    private EditText editTextDemo;

    public ETComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_et_component, container, false);

        editTextDemo = (EditText) view.findViewById(R.id.editTextDemo);

        Button buttonDemo = (Button) view.findViewById(R.id.buttonDemo);
        buttonDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextDemo.getText().toString().equals(""))  {
                    Toast.makeText(getContext(), editTextDemo.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), getString(R.string.text_empty), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
