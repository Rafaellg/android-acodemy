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
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.activity.MainActivity;
import com.kreativ.rafael.androidschool.util.CustomFragment;
import com.kreativ.rafael.androidschool.util.Util;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class DemoFragment extends Fragment {

    private CustomFragment fragmentComponent;
    private Fragment fragmentCode;
    private Fragment fragmentXML;
    private boolean[] propertyVisibles;
    private String title;

    public DemoFragment() {
        // Required empty public constructor
    }

    public static DemoFragment newInstance(String title, CustomFragment fragmentComponent, Fragment fragmentCode, Fragment fragmentXML, boolean[] properties) {
        DemoFragment fragment = new DemoFragment();

        fragment.setFragmentComponent(fragmentComponent);
        fragment.setFragmentCode(fragmentCode);
        fragment.setFragmentXML(fragmentXML);
        fragment.setTitle(title);
        fragment.setPropertyVisibles(properties);

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
                Fragment fragment = null;

                if (tabId == R.id.bottomBarItemOne) {
                    fragment = fragmentComponent;
                } else if (tabId == R.id.bottomBarItemTwo) {
                    fragment = fragmentCode;
                } else if (tabId == R.id.bottomBarItemThree) {
                    fragment = fragmentXML;
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
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(title);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.fragment_demo_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String[] propertyLabels = Util.getPropertiesLabel(propertyVisibles, getContext());

        switch (item.getItemId()) {
            case R.id.action_edit:
                new AlertDialog.Builder(getContext())
                        .setTitle(R.string.title_dialog_edit)
                        .setItems(propertyLabels, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == 0) {
                                    fragmentComponent.setColor(R.color.black);
                                } else if (which == 1) {
                                    Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
                                } else if (which == 2) {
                                    Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setFragmentComponent(CustomFragment fragmentComponent) {
        this.fragmentComponent = fragmentComponent;
    }

    public void setFragmentCode(Fragment fragmentCode) {
        this.fragmentCode = fragmentCode;
    }

    public void setFragmentXML(Fragment fragmentXML) {
        this.fragmentXML = fragmentXML;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPropertyVisibles(boolean[] propertyVisibles) {
        this.propertyVisibles = propertyVisibles;
    }
}
