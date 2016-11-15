package com.kreativ.rafael.androidschool.fragment.category.layouts;

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

public class RLXMLFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public RLXMLFragment() {
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
        codeList.add("<RelativeLayout");
        codeList.add("android:layout_width=\"match_parent\"");
        codeList.add("android:layout_height=\"match_parent\"");
        codeList.add("android:id=\"@+id/relativeLayoutdemo\" />");
        codeList.add("");
        codeList.add("\t\t<ImageView");
        codeList.add("\t\tandroid:layout_width=\"100dp\"");
        codeList.add("\t\tandroid:layout_height=\"100dp\"");
        codeList.add("\t\tapp:srcCompat=\"@drawable/ic_launcher\"");
        codeList.add("\t\tandroid:layout_alignParentStart=\"true\"");
        codeList.add("\t\tandroid:id=\"@+id/imageViewDemo1\" />");
        codeList.add("");
        codeList.add("\t\t<ImageView");
        codeList.add("\t\tandroid:layout_width=\"100dp\"");
        codeList.add("\t\tandroid:layout_height=\"100dp\"");
        codeList.add("\t\tapp:srcCompat=\"@drawable/ic_launcher\"");
        codeList.add("\t\tandroid:layout_alignParentRight=\"true\"");
        codeList.add("\t\tandroid:id=\"@+id/imageViewDemo2\" />");
        codeList.add("");
        codeList.add("\t\t<ImageView");
        codeList.add("\t\tandroid:layout_width=\"100dp\"");
        codeList.add("\t\tandroid:layout_height=\"100dp\"");
        codeList.add("\t\tapp:srcCompat=\"@drawable/ic_launcher\"");
        codeList.add("\t\tandroid:layout_alignParentLeft=\"true\"");
        codeList.add("\t\tandroid:layout_alignParentBottom=\"true\"");
        codeList.add("\t\tandroid:id=\"@+id/imageViewDemo3\" />");
        codeList.add("");
        codeList.add("\t\t<ImageView");
        codeList.add("\t\tandroid:layout_width=\"100dp\"");
        codeList.add("\t\tandroid:layout_height=\"100dp\"");
        codeList.add("\t\tapp:srcCompat=\"@drawable/ic_launcher\"");
        codeList.add("\t\tandroid:layout_alignParentRight=\"true\"");
        codeList.add("\t\tandroid:layout_alignParentBottom=\"true\"");
        codeList.add("\t\tandroid:id=\"@+id/imageViewDemo4\" />");
        codeList.add("");
        codeList.add("</RelativeLayout>");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }
}
