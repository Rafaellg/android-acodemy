package com.kreativ.rafael.androidschool.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.activity.MainActivity;
import com.kreativ.rafael.androidschool.util.CustomFragment;
import com.kreativ.rafael.androidschool.util.EnumComponent;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class DemoFragment extends Fragment {

    private EnumComponent enumComponent;

    public DemoFragment() {
        // Required empty public constructor
    }

    public static DemoFragment newInstance(EnumComponent enumComponent) {
        DemoFragment fragment = new DemoFragment();

        fragment.setEnumComponent(enumComponent);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilita o menu
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);

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
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.fragment_demo_menu, menu);
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
                                enumComponent.getFragmentCode().onEditOptionSelected(which);
                                enumComponent.getFragmentXML().onEditOptionSelected(which);
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
}
