package com.kreativ.rafael.androidschool.fragment.category.buttom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;
import com.kreativ.rafael.androidschool.util.Util;

import org.jetbrains.annotations.NotNull;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.OnCodeLineClickListener;

public class FABCodeFragment extends CustomFragment {

    private CodeView codeView;

    private String textOnClick, textIcon;

    public FABCodeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fab_code, container, false);

        textOnClick = "Button clicked!";
        textIcon = "R.drawable.ic_touch_app_white_24dp";

        String text = "FloatingActionButton fabDemo = (FloatingActionButton) view.findViewById(R.id.fabDemo);\n" +
                "fabDemo.setBackgroundResource(" + textIcon + ");\n" +
                "fabDemo.setOnClickListener(new View.OnClickListener() {\n" +
                "       @Override\n" +
                "       public void onClick(View v) {\n" +
                "               Toast.makeText(getContext(), " + textOnClick + ", Toast.LENGTH_SHORT).show();\n" +
                "       }\n" +
                "});";

        String fabCode = getString(R.string.fab_declaration);
        fabCode += getString(R.string.fab_set_bg_res_open) + textIcon + getString(R.string.fab_set_bg_res_close);
        fabCode += getString(R.string.fab_set_click_lis_open);
        fabCode += getString(R.string.tab) + getString(R.string.tab) + getString(R.string.toast_open) + textOnClick + getString(R.string.toast_close);
        fabCode += getString(R.string.fab_set_click_lis_close);

        codeView = (CodeView) view.findViewById(R.id.codeview);
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(fabCode);
        codeView.setCodeListener(new OnCodeLineClickListener() {
            @Override
            public void onCodeLineClicked(int n, @NotNull String line) {
                Toast.makeText(getContext(), (n + 1) + " line clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
