package com.rafaelguimas.acodemy.fragment.category.containers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.rafaelguimas.acodemy.R;
import com.rafaelguimas.acodemy.util.CustomFragment;

public class WVComponentFragment extends CustomFragment {

    public WVComponentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wv_component, container, false);

        WebView webviewDemo = (WebView) view.findViewById(R.id.webviewDemo);
        webviewDemo.setWebViewClient(new WebViewClient());
        webviewDemo.loadUrl("http://www.google.com");

        return view;
    }

}
