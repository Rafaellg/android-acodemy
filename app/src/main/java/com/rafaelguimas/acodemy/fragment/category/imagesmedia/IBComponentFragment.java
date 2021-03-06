package com.rafaelguimas.acodemy.fragment.category.imagesmedia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.rafaelguimas.acodemy.R;
import com.rafaelguimas.acodemy.fragment.DemoFragment;
import com.rafaelguimas.acodemy.util.CustomFragment;

public class IBComponentFragment extends CustomFragment {

    private ImageButton imageButtonDemo;
    private int color = -1, width = -1, height = -1;

    public IBComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ib_component, container, false);

        imageButtonDemo = (ImageButton) view.findViewById(R.id.imageButtonDemo);
        imageButtonDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), getString(R.string.text_pressed), Toast.LENGTH_SHORT).show();
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
            imageButtonDemo.setLayoutParams(layoutParams);
        }
        if (color != -1) {
            // Altera a cor do componente
            imageButtonDemo.setBackgroundColor(color);
        }
    }

    @Override
    public void resetProps() {
        color = width = height = -1;
    }

}
