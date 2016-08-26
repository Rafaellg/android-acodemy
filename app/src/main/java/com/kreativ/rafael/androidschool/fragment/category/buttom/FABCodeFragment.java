package com.kreativ.rafael.androidschool.fragment.category.buttom;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class FABCodeFragment extends Fragment {

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
        fabCode += getString(R.string.tab) + getString(R.string.tab)+ getString(R.string.toast_open) + textOnClick + getString(R.string.toast_close);
        fabCode += getString(R.string.fab_set_click_lis_close);

        codeView = (CodeView) view.findViewById(R.id.codeview);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        codeView.showCode(fabCode);

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(getContext(), "Editar (interior)!", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
