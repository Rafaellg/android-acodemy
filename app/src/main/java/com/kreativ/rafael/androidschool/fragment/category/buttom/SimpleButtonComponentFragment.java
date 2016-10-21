package com.kreativ.rafael.androidschool.fragment.category.buttom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.fragment.DemoFragment;
import com.kreativ.rafael.androidschool.util.CustomFragment;

public class SimpleButtonComponentFragment extends CustomFragment {

    private Button btnDemo;
    private int color = -1, width = -1, height = -1;

    public SimpleButtonComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_button_component, container, false);

        btnDemo = (Button) view.findViewById(R.id.btnDemo);
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
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
    public void onEditOptionSelected(int which) {
        if (which == 0) {
            DemoFragment.getInstance().selectColor();
        } else if (which == 1) {
            DemoFragment.getInstance().selectSize();
        }
    }

    @Override
    public void setColor(int color) {
        // Guarda o valor global
        this.color = color;

        // Altera o botao se estiver na tela
        if (isVisible()) {
            showContent();
        }
    }

    @Override
    public void setSize(int height, int width) {
        // Guarda os valores globais
        this.width = width;
        this.height = height;

        // Altera o botao se estiver na tela
        if (isVisible()) {
            showContent();
        }
    }

    public void showContent() {
        // Adiciona as linhas alternativas
        if (height != -1 && width != -1) {
            // Altera o tamanho do botao
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
            layoutParams.gravity = Gravity.CENTER;
            btnDemo.setLayoutParams(layoutParams);
        }
        if (color != -1) {
            // Altera a cor do componente
            btnDemo.setBackgroundColor(color);
        }
    }

    @Override
    public void resetProps() {
        color = width = height = -1;
    }

}
