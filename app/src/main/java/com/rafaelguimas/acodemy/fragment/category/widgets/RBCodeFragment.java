package com.rafaelguimas.acodemy.fragment.category.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rafaelguimas.acodemy.R;
import com.rafaelguimas.acodemy.util.CustomFragment;
import com.rafaelguimas.acodemy.util.Util;

import java.util.ArrayList;
import java.util.List;

import io.github.kbiakov.codeview.CodeView;

public class RBCodeFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public RBCodeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        codeList.add("RadioButton radioDemo1 = (RadioButton) findViewById(R.id.radioDemo1);");
        codeList.add("radioDemo1.setOnClickListener(new View.OnClickListener() {");
        codeList.add("\t\t@Override");
        codeList.add("\t\tpublic void onClick(View view) {");
        codeList.add("\t\t\t\tif (radioDemo1.isChecked()) {");
        codeList.add("\t\t\t\t\t\tradioDemo2.setChecked(false);");
        codeList.add("\t\t\t\t}");
        codeList.add("\t\t}");
        codeList.add("});");

        codeList.add("");

        codeList.add("RadioButton radioDemo2 = (RadioButton) findViewById(R.id.radioDemo2);");
        codeList.add("radioDemo2.setOnClickListener(new View.OnClickListener() {");
        codeList.add("\t\t@Override");
        codeList.add("\t\tpublic void onClick(View view) {");
        codeList.add("\t\t\t\tif (radioDemo2.isChecked()) {");
        codeList.add("\t\t\t\t\t\tradioDemo1.setChecked(false);");
        codeList.add("\t\t\t\t}");
        codeList.add("\t\t}");
        codeList.add("});");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }
}
