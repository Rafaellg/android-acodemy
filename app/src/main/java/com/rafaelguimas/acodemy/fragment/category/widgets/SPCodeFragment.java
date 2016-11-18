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

public class SPCodeFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public SPCodeFragment() {
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
        codeList.add("Spinner spinnerDemo = (Spinner) findViewById(R.id.spinnerDemo);");
        codeList.add("");
        codeList.add("final String[] array = new String[] {\"A\", \"B\", \"C\"};");
        codeList.add("ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, array);");
        codeList.add("spinnerDemo.setAdapter(adapter);");
        codeList.add("");
        codeList.add("spinnerDemo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {");
        codeList.add("\t\t@Override");
        codeList.add("\t\tpublic void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {");
        codeList.add("\t\t\t\tToast.makeText(getApplicationContext(), array[i], Toast.LENGTH_SHORT).show();");
        codeList.add("\t\t}");
        codeList.add("\t\t@Override");
        codeList.add("\t\tpublic void onNothingSelected(AdapterView<?> adapterView) { }");
        codeList.add("});");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }

}
