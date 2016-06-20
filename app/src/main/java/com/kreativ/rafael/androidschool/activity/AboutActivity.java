package com.kreativ.rafael.androidschool.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kreativ.rafael.androidschool.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        FloatingActionButton btnGooglePlus = (FloatingActionButton) findViewById(R.id.btnGooglePlus);
        FloatingActionButton btnLinkedin = (FloatingActionButton) findViewById(R.id.btnLinkedin);
        FloatingActionButton btnFacebook = (FloatingActionButton) findViewById(R.id.btnFacebook);

        btnGooglePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to github project
                String url = "https://plus.google.com/u/0/+RafaelGuimaraes";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        btnLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to github project
                String url = "https://www.linkedin.com/in/rafaellguimaraes";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to github project
                String url = "https://www.facebook.com/rafaellguimas";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
