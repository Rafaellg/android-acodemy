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

public class TBCodeFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public TBCodeFragment() {
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
        codeList.add("ToggleButton toggleDemo = (ToggleButton) findViewById(R.id.toggleDemo);");
        codeList.add("toggleDemo.setOnClickListener(new View.OnClickListener() {");
        codeList.add("\t\t@Override");
        codeList.add("\t\tpublic void onClick(View view) {");
        codeList.add("\t\t\t\tif (toggleDemo.isChecked()) {");
        codeList.add("\t\t\t\t\t\tToast.makeText(getApplicationContext(), \""+ getString(R.string.text_on) +"\", Toast.LENGTH_SHORT).show();");
        codeList.add("\t\t\t\t} else {");
        codeList.add("\t\t\t\t\t\tToast.makeText(getApplicationContext(), \""+ getString(R.string.text_off) +"\", Toast.LENGTH_SHORT).show();");
        codeList.add("\t\t\t\t}");
        codeList.add("\t\t}");
        codeList.add("});");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }
}
