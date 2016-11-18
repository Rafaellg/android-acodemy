package com.rafaelguimas.androidschool.activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rafaelguimas.androidschool.R;
import com.rafaelguimas.androidschool.fragment.StartFragment;
import com.rafaelguimas.androidschool.fragment.category.CategoryContainersFragment;
import com.rafaelguimas.androidschool.fragment.category.CategoryDateTimeFragment;
import com.rafaelguimas.androidschool.fragment.category.CategoryImagesFragment;
import com.rafaelguimas.androidschool.fragment.category.CategoryLayoutsFragment;
import com.rafaelguimas.androidschool.fragment.category.CategoryTextFieldsFragment;
import com.rafaelguimas.androidschool.fragment.category.CategoryWidgetsFragment;
import com.rafaelguimas.androidschool.util.Util;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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

        // Verifica se o usuario ja avaliou o app e exibe dialog
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.title_shared_preferences), -1);
        if (!sharedPreferences.getBoolean(getString(R.string.pref_evaluate), false)) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.title_atention)
                    .setMessage(R.string.text_class_please)
                    .setPositiveButton(R.string.text_now, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Util.showEvaluateDialog(MainActivity.this);
                        }
                    })
                    .setNegativeButton(R.string.text_after, null)
                    .show();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Recupera o item selecionado
        int id = item.getItemId();

        // Seleciona o fragment do item
        Fragment fragment = null;
        if (id == R.id.menu_cat_widgets) {
            fragment = new CategoryWidgetsFragment();
        } else if (id == R.id.menu_cat_text_fields) {
            fragment = new CategoryTextFieldsFragment();
        } else if (id == R.id.menu_cat_layouts) {
            fragment = new CategoryLayoutsFragment();
        } else if (id == R.id.menu_cat_containers) {
            fragment = new CategoryContainersFragment();
        } else if (id == R.id.menu_cat_image_media) {
            fragment = new CategoryImagesFragment();
        } else if (id == R.id.menu_cat_date_time) {
            fragment = new CategoryDateTimeFragment();
        } else if (id == R.id.menu_home) {
            fragment = new StartFragment();
        } else if (id == R.id.menu_evaluate) {
            Util.showEvaluateDialog(this);
        } else if (id == R.id.menu_about) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.title_about)
                    .setMessage(R.string.text_about)
                    .setPositiveButton(R.string.text_now, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Util.showEvaluateDialog(MainActivity.this);
                        }
                    })
                    .setNegativeButton(R.string.text_after, null)
                    .show();
        }

        // Exibe o fragment do item
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
        }

        // Fecha o drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
