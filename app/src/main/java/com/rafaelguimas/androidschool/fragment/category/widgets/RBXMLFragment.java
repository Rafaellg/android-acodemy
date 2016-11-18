package com.rafaelguimas.androidschool.fragment.category.widgets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rafaelguimas.androidschool.R;
import com.rafaelguimas.androidschool.util.CustomFragment;
import com.rafaelguimas.androidschool.util.Util;

import java.util.ArrayList;
import java.util.List;

import io.github.kbiakov.codeview.CodeView;

public class RBXMLFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public RBXMLFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_codeview, container, false);

        // Declara o codeview
        codeView = (CodeView) view.findViewById(R.id.codeview);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Exibe o conteudo atualizado
        showContent();
    }

    public void showContent() {
        // Cria a lista das linhas de codigo
        codeList = new ArrayList<>();

        // Adiciona as linhas padroes
        codeList.add("<RadioButton");
        codeList.add("android:id=\"@+id/radioDemo1\"");
        codeList.add("android:layout_width=\"wrap_content\"");
        codeList.add("android:layout_height=\"wrap_content\"");
        codeList.add("android:text=\""+ getString(R.string.text_option_1) +"\"");
        codeList.add("android:textColor=\"#ffffff\"");
        codeList.add("android:buttonTint=\"#ffffff\"");
        codeList.add("android:layout_gravity=\"center\"/>");

        codeList.add("");

        codeList.add("<RadioButton");
        codeList.add("android:id=\"@+id/radioDemo2\"");
        codeList.add("android:layout_width=\"wrap_content\"");
        codeList.add("android:layout_height=\"wrap_content\"");
        codeList.add("android:text=\""+ getString(R.string.text_option_2) +"\"");
        codeList.add("android:textColor=\"#ffffff\"");
        codeList.add("android:buttonTint=\"#ffffff\"");
        codeList.add("android:layout_gravity=\"center\"/>");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }
}
