package com.rafaelguimas.acodemy.fragment.category.textfields;

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

public class ETXMLFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public ETXMLFragment() {
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
        codeList.add("<EditText");
        codeList.add("android:id=\"@+id/editTextDemo\"");
        codeList.add("android:layout_width=\"wrap_content\"");
        codeList.add("android:layout_height=\"wrap_content\"");
        codeList.add("android:inputType=\"textPersonName\"");
        codeList.add("android:ems=\"10\"");
        codeList.add("android:hint=\""+ getString(R.string.text_full_name) +"\"");
        codeList.add("android:textColor=\"@android:color/white\"");
        codeList.add("android:backgroundTint=\"@android:color/white\"");
        codeList.add("android:textColorHint=\"@color/hint_foreground_material_dark\"");
        codeList.add("android:layout_gravity=\"center\"/>");

        codeList.add("");

        codeList.add("<Button");
        codeList.add("android:id=\"@+id/buttonDemo\"");
        codeList.add("android:text=\"" + getString(R.string.text_show) + "\"");
        codeList.add("android:layout_width=\"wrap_content\"");
        codeList.add("android:layout_height=\"wrap_content\"");
        codeList.add("android:layout_marginTop=\"32dp\" />");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }
}
