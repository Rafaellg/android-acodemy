package com.rafaelguimas.acodemy.fragment.category.datetime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rafaelguimas.acodemy.R;
import com.rafaelguimas.acodemy.util.CustomFragment;
import com.rafaelguimas.acodemy.util.Util;

import java.util.ArrayList;
import java.util.List;

import io.github.kbiakov.codeview.CodeView;

public class TPXMLFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public TPXMLFragment() {
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
        codeList.add("<TimePicker");
        codeList.add("android:id=\"@+id/timePickerDemo\"");
        codeList.add("android:layout_width=\"match_parent\"");
        codeList.add("android:layout_height=\"wrap_content\" />");
        codeList.add("");
        codeList.add("<Button");
        codeList.add("android:id=\"@+id/buttonDemo\"");
        codeList.add("android:layout_width=\"wrap_content\"");
        codeList.add("android:layout_height=\"wrap_content\"");
        codeList.add("android:text=\""+getString(R.string.text_show)+"\"");
        codeList.add("android:layout_marginTop=\"16dp\"");
        codeList.add("android:layout_gravity=\"center\" />");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }
}
