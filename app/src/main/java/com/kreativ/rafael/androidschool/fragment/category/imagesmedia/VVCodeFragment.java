package com.kreativ.rafael.androidschool.fragment.category.imagesmedia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.util.CustomFragment;
import com.kreativ.rafael.androidschool.util.Util;

import java.util.ArrayList;
import java.util.List;

import io.github.kbiakov.codeview.CodeView;

public class VVCodeFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public VVCodeFragment() {
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
        codeList.add("VideoView videoViewDemo = (VideoView) findViewById(R.id.videoViewDemo);");
        codeList.add("videoViewDemo.setVideoURI(Uri.parse(\"android.resource://\" + getPackageName() + \"/\" + R.raw.google_comercial));");
        codeList.add("videoViewDemo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {");
        codeList.add("\t\t@Override");
        codeList.add("\t\tpublic void onPrepared(MediaPlayer mp) {");
        codeList.add("\t\t\t\tmp.setLooping(true);");
        codeList.add("\t\t}");
        codeList.add("});");
        codeList.add("videoViewDemo.start();");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }
}
