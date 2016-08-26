package com.kreativ.rafael.androidschool.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.Util;
import com.kreativ.rafael.androidschool.fragment.StartFragment;
import com.kreativ.rafael.androidschool.fragment.category.CategoryButtonFragment;
import com.kreativ.rafael.androidschool.R;
import com.roughike.bottombar.BottomBar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Set the start fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new StartFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_github) {
            // Redirect to github project
            String url = "https://github.com/Rafaellg/android-school-app";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);

            return true;
        } else if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);

            return true;
        }

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.cat_buttom) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new CategoryButtonFragment())
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.cat_list) {
            Toast.makeText(this,"Em desenvolvimento", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cat_layout) {
            Toast.makeText(this,"Em desenvolvimento", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cat_progress_bar) {
            Toast.makeText(this,"Em desenvolvimento", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cat_dialog) {
            Toast.makeText(this,"Em desenvolvimento", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cat_edittext) {
            Toast.makeText(this,"Em desenvolvimento", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cat_textview) {
            Toast.makeText(this,"Em desenvolvimento", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cat_container) {
            Toast.makeText(this,"Em desenvolvimento", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public BottomBar getBottomBar() {
        return mBottomBar;
    }
}
