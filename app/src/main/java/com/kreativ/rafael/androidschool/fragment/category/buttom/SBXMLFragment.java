package com.kreativ.rafael.androidschool.fragment.category.buttom;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;
import com.kreativ.rafael.androidschool.util.Util;

import java.util.ArrayList;
import java.util.List;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.CodeWithDiffsAdapter;
import io.github.kbiakov.codeview.views.DiffModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class SBXMLFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();
    private int width = -1, height = -1, color = -1;

    public SBXMLFragment() {
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

    @Override
    public void setColor(int color) {
        // Guarda o valor global
        this.color = color;

        // Atualiza o codigo caso esteja na tela
        if (isVisible()) {
            showContent();
        }
    }

    @Override
    public void setSize(int height, int width) {
        // Guarda os valores globais
        this.width = width;
        this.height = height;

        // Atualiza o codigo caso esteja na tela
        if (isVisible()) {
            showContent();
        }
    }

    public void showContent() {
        // Cria a lista das linhas de codigo
        codeList = new ArrayList<>();

        // Adiciona as linhas padroes
        codeList.add("<Button");
        codeList.add("android:id=\"@+id/btnDemo\"");
        if (width == -1) {
            codeList.add("android:layout_width=\"wrap_content\"");
        }
        if (width == -1) {
            codeList.add("android:layout_height=\"wrap_content\"");
        }
        codeList.add("android:text=\""+ getResources().getString(R.string.text_press) +"\"");
        codeList.add("android:layout_gravity=\"center\"/>");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));

        // Exibe as linhas alteradas
        CodeWithDiffsAdapter diffsAdapter = new CodeWithDiffsAdapter(getContext(), Util.getStringFromCodeList(codeList));
        diffsAdapter.setColorTheme$codeview_compileReleaseKotlin(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        diffsAdapter.highlightCode(Util.getDefaultCodeLanguage(), new Function0<Unit>() {
            @Override
            public Unit invoke() {
                return null;
            }
        });
        codeView.setAdapter(diffsAdapter);

        // Adiciona as linhas alternativas
        if (width != -1) {
            diffsAdapter.addFooterEntity(codeList.size()-2, new DiffModel("android:layout_width=\"" + width + "dp\"", true));
        }
        if (height != -1) {
            diffsAdapter.addFooterEntity(codeList.size()-2, new DiffModel("android:layout_height=\"" + height + "dp\"", true));
        }
        if (color != -1) {
            diffsAdapter.addFooterEntity(codeList.size()-2, new DiffModel("android:backgroundTint=\"" + Util.getHexFromIntColor(color) + "\"", true));
        }
    }

    @Override
    public void resetProps() {
        color = width = height = -1;
    }
}
