package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;
import com.kreativ.rafael.androidschool.util.Util;

import org.jetbrains.annotations.NotNull;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.OnCodeLineClickListener;
import io.github.kbiakov.codeview.highlight.ColorTheme;

public class FABXMLFragment extends CustomFragment {

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
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(text);
        codeView.setCodeListener(new OnCodeLineClickListener() {
            @Override
            public void onCodeLineClicked(int n, @NotNull String line) {
                Toast.makeText(getContext(), (n + 1) + " line clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
