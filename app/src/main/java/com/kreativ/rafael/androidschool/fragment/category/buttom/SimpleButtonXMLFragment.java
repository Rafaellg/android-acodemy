package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;

public class SimpleButtonXMLFragment extends CustomFragment {

    public SimpleButtonXMLFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_button_xml, container, false);

        String text = "<Button\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:text=\"Button\"\n" +
                "        android:id=\"@+id/btnDemo\"\n" +
                "        android:layout_gravity=\"center\" />";

        TextView txtDemo = (TextView) view.findViewById(R.id.txtDemo);
        txtDemo.setText(text);

        return view;
    }

}
