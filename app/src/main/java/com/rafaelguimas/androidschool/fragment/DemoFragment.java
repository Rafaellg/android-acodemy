package com.rafaelguimas.androidschool.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bq.markerseekbar.MarkerSeekBar;
import com.rafaelguimas.androidschool.R;
import com.rafaelguimas.androidschool.activity.MainActivity;
import com.rafaelguimas.androidschool.util.CustomFragment;
import com.rafaelguimas.androidschool.util.EnumComponent;
import com.rafaelguimas.androidschool.util.Util;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.thebluealliance.spectrum.SpectrumDialog;

public class DemoFragment extends Fragment {

    private static DemoFragment instance;
    private EnumComponent enumComponent;

    public DemoFragment() {
        // Required empty public constructor
    }

    public static DemoFragment newInstance(EnumComponent enumComponent) {
        // Guarda o fragmento para acesso estatico
        instance = new DemoFragment();

        // Reseta as props
        enumComponent.getFragmentComponent().resetProps();
        enumComponent.getFragmentXML().resetProps();
        if (enumComponent.getFragmentCode() != null) {
            enumComponent.getFragmentCode().resetProps();
        }

        // Define qual sera o componente da demo
        instance.setEnumComponent(enumComponent);

        return instance;
    }

    public static DemoFragment getInstance() {
        if (instance != null) {
            return instance;
        }

        return new DemoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilita o menu
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;

        if (enumComponent.getFragmentCode() != null) {
            view = inflater.inflate(R.layout.fragment_demo, container, false);
        } else {
            view = inflater.inflate(R.layout.fragment_demo_layout, container, false);
        }

        // Declara a bottom bar
        BottomBar mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

        // Set tabs click
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                CustomFragment fragment = null;

                if (tabId == R.id.bottomBarItemOne) {
                    fragment = enumComponent.getFragmentComponent();
                } else if (tabId == R.id.bottomBarItemTwo) {
                    fragment = enumComponent.getFragmentCode();
                } else if (tabId == R.id.bottomBarItemThree) {
                    fragment = enumComponent.getFragmentXML();
                }

                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.inner_container, fragment)
                        .commit();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Define o título da activity
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(enumComponent.getTitle());

        // Troca o componente quando o usuario volta para nao causar o bug da tela branca
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    // Troca o fragmento antes de voltar
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.inner_container, enumComponent.getFragmentXML())
                            .commit();
                    // Executa acao de voltar padrao
                    getActivity()
                            .onBackPressed();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        if (enumComponent.getProperties() != null) {
            inflater.inflate(R.menu.fragment_demo_menu, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                new AlertDialog.Builder(getContext())
                        .setTitle(R.string.title_dialog_edit)
                        .setItems(enumComponent.getProperties(), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                enumComponent.getFragmentComponent().onEditOptionSelected(which);
                            }
                        })
                        .show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setEnumComponent(EnumComponent enumComponent) {
        this.enumComponent = enumComponent;
    }

    public void selectSize() {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_size, null);

        final MarkerSeekBar sekWidth = (MarkerSeekBar) view.findViewById(R.id.sekWidth);
        final MarkerSeekBar sekHeight = (MarkerSeekBar) view.findViewById(R.id.sekHeight);
        final TextView txtWidth = (TextView) view.findViewById(R.id.txtWidth);
        final TextView txtHeight = (TextView) view.findViewById(R.id.txtHeight);

        sekWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtWidth.setText(seekBar.getProgress() + "dp");
            }
        });

        sekHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtHeight.setText(seekBar.getProgress() + "dp");
            }
        });

        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setView(view);
        dialog.setNeutralButton(R.string.text_apply, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int width = sekWidth.getProgress();
                int height = sekHeight.getProgress();

                enumComponent.getFragmentComponent().setSize(height, width);
                enumComponent.getFragmentCode().setSize(height, width);
                enumComponent.getFragmentXML().setSize(height, width);
            }
        });
        dialog.show();
    }

    public void selectColor() {
        new SpectrumDialog.Builder(getContext())
                .setTitle(getString(R.string.title_dialog_color))
                .setColors(Util.getColorsArray(getContext()))
                .setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(boolean positiveResult, @ColorInt int color) {
                        enumComponent.getFragmentComponent().setColor(color);
                        enumComponent.getFragmentCode().setColor(color);
                        enumComponent.getFragmentXML().setColor(color);
                    }
                })
                .setDismissOnColorSelected(true)
                .build()
                .show(getActivity().getSupportFragmentManager(), "tag");
    }
}
