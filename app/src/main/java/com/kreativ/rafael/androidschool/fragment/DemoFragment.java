package com.kreativ.rafael.androidschool.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.activity.MainActivity;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

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

        // Get the bottom bar
        mBottomBar = ((MainActivity) getActivity()).getBottomBar();
        mBottomBar.show();

        // Set tabs click
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                Fragment fragment = null;

                if (menuItemId == R.id.bottomBarItemOne) {
                    fragment = fragmentComponent;
                } else if (menuItemId == R.id.bottomBarItemTwo) {
                    fragment = fragmentCode;
                } else if (menuItemId == R.id.bottomBarItemThree) {
                    fragment = fragmentXML;
                }

                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.inner_container, fragment)
                        .commit();
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                // Nothing
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Define o título da activity
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(title);
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
