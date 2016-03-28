package com.test.iptv.materialdesignone;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFrag drawerFrag = (NavigationDrawerFrag) getSupportFragmentManager().
                findFragmentById(R.id.fragmentDrawer);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        drawerFrag.setUp(drawerLayout,toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id ==R.id.action_settings){
            Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
        }

        if (id==R.id.navigate){
            Toast.makeText(getApplicationContext(),"Navigate",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
