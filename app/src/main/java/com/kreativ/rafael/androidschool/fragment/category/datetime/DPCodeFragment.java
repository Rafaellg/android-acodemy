package com.kreativ.rafael.androidschool.fragment.category.datetime;

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

public class DPCodeFragment extends CustomFragment {

    private CodeView codeView;

    private List<String> codeList = new ArrayList<>();

    public DPCodeFragment() {
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
        codeList.add("DatePicker datePickerDemo = (DatePicker) findViewById(R.id.datePickerDemo);");
        codeList.add("Calendar calendar = Calendar.getInstance();");
        codeList.add("datePickerDemo.init(");
        codeList.add("\t\tcalendar.get(Calendar.YEAR),");
        codeList.add("\t\tcalendar.get(Calendar.MONTH),");
        codeList.add("\t\tcalendar.get(Calendar.DAY_OF_MONTH),");
        codeList.add("\t\tnew DatePicker.OnDateChangedListener(){");
        codeList.add("\t\t\t\t@Override");
        codeList.add("\t\t\t\tpublic void onDateChanged(DatePicker view, int year, int monthOfYear,int dayOfMonth) {");
        codeList.add("\t\t\t\t\t\tString message = dayOfMonth + \"/\" + monthOfYear + \"/\" + year;");
        codeList.add("\t\t\t\t\t\tToast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();");
        codeList.add("\t\t\t\t}");
        codeList.add("\t\t}");
        codeList.add(");");

        // Atualiza o codigo
        codeView.setColorTheme(Util.getDefaultCodeTheme().withBgContent(Util.getDefaultCodeBg(getContext())));
        codeView.highlightCode(Util.getDefaultCodeLanguage());
        codeView.setCodeContent(Util.getStringFromCodeList(codeList));
    }
}
