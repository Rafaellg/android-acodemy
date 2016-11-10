package com.kreativ.rafael.androidschool.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.fragment.StartFragment;
import com.kreativ.rafael.androidschool.fragment.category.CategoryContainersFragment;
import com.kreativ.rafael.androidschool.fragment.category.CategoryDateTimeFragment;
import com.kreativ.rafael.androidschool.fragment.category.CategoryImagesFragment;
import com.kreativ.rafael.androidschool.fragment.category.CategoryLayoutsFragment;
import com.kreativ.rafael.androidschool.fragment.category.CategoryTextFieldsFragment;
import com.kreativ.rafael.androidschool.fragment.category.CategoryWidgetsFragment;

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
