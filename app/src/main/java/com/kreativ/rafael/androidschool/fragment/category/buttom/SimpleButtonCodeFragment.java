package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;

public class SimpleButtonCodeFragment extends CustomFragment {

    public SimpleButtonCodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_button_code, container, false);

        String text = "Button btnDemo = (Button) findViewById(R.id.btnDemo);\n" +
                "btnDemo.setText(\"Button\");\n" +
                "btnDemo.setOnClickListener(new View.OnClickListener() {\n" +
                "       @Override\n" +
                "       public void onClick(View v) {\n" +
                "           Toast.makeText(this, \"Button clicked!\", Toast.LENGTH_SHORT).show();\n" +
                "       }\n" +
                "});";

        TextView txtDemo = (TextView) view.findViewById(R.id.txtDemo);
        txtDemo.setText(text);

        return view;
    }

}
