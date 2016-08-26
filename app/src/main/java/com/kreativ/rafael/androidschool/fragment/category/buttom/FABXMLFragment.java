package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kreativ.rafael.androidschool.R;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class FABXMLFragment extends Fragment {

    private CodeView codeView;

    public FABXMLFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fab_xml, container, false);

        String text = "<android.support.design.widget.FloatingActionButton\n" +
                "   android:id=\"@+id/fabDemo\"\n" +
                "   android:layout_width=\"wrap_content\"\n" +
                "   android:layout_height=\"wrap_content\"\n" +
                "   android:src=\"@drawable/ic_touch_app_white_24dp\"\n" +
                "   android:layout_gravity=\"center\"/>";

        codeView = (CodeView) view.findViewById(R.id.codeview);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        codeView.showCode(text);

        return view;
    }

}
