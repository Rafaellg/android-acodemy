package com.rafaelguimas.acodemy.fragment.category.textfields;

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

public class ETCodeFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public ETCodeFragment() {
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
        codeList.add("EditText editTextDemo = (EditText) findViewById(R.id.editTextDemo);");

        codeList.add("");

        codeList.add("Button buttonDemo = (Button) findViewById(R.id.buttonDemo);");
        codeList.add("buttonDemo.setOnClickListener(new View.OnClickListener() {");
        codeList.add("\t\t@Override");
        codeList.add("\t\tpublic void onClick(View view) {");
        codeList.add("\t\t\t\tif (!editTextDemo.getText().toString().equals(\"\"))  {");
        codeList.add("\t\t\t\t\t\tToast.makeText(getApplicationContext(), editTextDemo.getText(), Toast.LENGTH_SHORT).show();");
        codeList.add("\t\t\t\t} else {");
        codeList.add("\t\t\t\t\t\tToast.makeText(getApplicationContext(), \"" + getString(R.string.text_empty) + "\", Toast.LENGTH_SHORT).show();");
        codeList.add("\t\t\t\t}");
        codeList.add("\t\t}");
        codeList.add("});");

        /*
                if (!editTextDemo.getText().toString().equals(""))  {
                    Toast.makeText(getContext(), editTextDemo.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), getString(R.string.text_empty), Toast.LENGTH_SHORT).show();
                }*/

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }
}
