package com.kreativ.rafael.androidschool.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.activity.MainActivity;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class DemoFragment extends Fragment {

    private Fragment fragmentComponent;
    private Fragment fragmentCode;
    private Fragment fragmentXML;
    private String title;

    private BottomBar mBottomBar;

    public DemoFragment() {
        // Required empty public constructor
    }

    public static DemoFragment newInstance(String title, Fragment fragmentComponent, Fragment fragmentCode, Fragment fragmentXML) {
        DemoFragment fragment = new DemoFragment();

        fragment.setFragmentComponent(fragmentComponent);
        fragment.setFragmentCode(fragmentCode);
        fragment.setFragmentXML(fragmentXML);
        fragment.setTitle(title);

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
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

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

    public void setFragmentComponent(Fragment fragmentComponent) {
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
}
