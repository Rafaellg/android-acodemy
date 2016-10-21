package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;
import com.kreativ.rafael.androidschool.util.Util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.OnCodeLineClickListener;

public class SimpleButtonCodeFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public SimpleButtonCodeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_button_code, container, false);

        // Declara o codeview
        codeView = (CodeView) view.findViewById(R.id.codeview);
        codeView.setCodeListener(new OnCodeLineClickListener() {
            @Override
            public void onCodeLineClicked(int n, @NotNull String line) {
                Toast.makeText(getContext(), (n + 1) + " line clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Exibe o conteudo atualizado
        showContent();
    }

    @Override
    public void setColor(int color) {
        // Nao altera o Java
    }

    @Override
    public void setSize(int height, int width) {
        // Nao altera o Java
    }

    public void showContent() {
        // Cria a lista das linhas de codigo
        codeList = new ArrayList<>();

        // Adiciona as linhas padroes
        codeList.add("Button btnDemo = (Button) findViewById(R.id.btnDemo);\n");
        codeList.add("btnDemo.setOnClickListener(new View.OnClickListener() {\n");
        codeList.add("\t\t@Override\n");
        codeList.add("\t\tpublic void onClick(View v) {\n");
        codeList.add("\t\t\t\tToast.makeText(getContext(), \"Button clicked!\", Toast.LENGTH_SHORT).show();\n");
        codeList.add("\t\t}\n");
        codeList.add("});");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }

    @Override
    public void resetProps() {
        // Sem props
    }

}
