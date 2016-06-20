package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kreativ.rafael.androidschool.R;

public class FloatingActionButtonCodeFragment extends Fragment {

    public FloatingActionButtonCodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_floating_action_button_code, container, false);

        String text = "FloatingActionButton fabDemo = (FloatingActionButton) view.findViewById(R.id.fabDemo);\n" +
                "fabDemo.setBackgroundResource(R.drawable.ic_touch_app_white_24dp);\n" +
                "fabDemo.setOnClickListener(new View.OnClickListener() {\n" +
                "       @Override\n" +
                "       public void onClick(View v) {\n" +
                "               Toast.makeText(getContext(), \"Button clicked!\", Toast.LENGTH_SHORT).show();\n" +
                "       }\n" +
                "});";

        TextView txtDemo = (TextView) view.findViewById(R.id.txtDemo);
        txtDemo.setText(text);

        return view;
    }

}
