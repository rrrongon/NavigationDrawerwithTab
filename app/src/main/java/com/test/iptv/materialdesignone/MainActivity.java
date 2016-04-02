package com.test.iptv.materialdesignone;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.test.iptv.tabs.SlidingTabLayout;

public class MainActivity extends ActionBarActivity {

    Toolbar toolbar;
    private ViewPager mPager;
    private SlidingTabLayout mTab;

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

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTab = (SlidingTabLayout) findViewById(R.id.tabs);
        mTab.setViewPager(mPager);
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

    class MyPagerAdapter extends FragmentPagerAdapter{

        String[] tabs;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return  tabs[position];
        }

        @Override
        public Fragment getItem(int position) {
            if(position==1){
                FirstTabFrag firstTabFrag = FirstTabFrag.getInstance();
                return firstTabFrag;
            }
            else {
                SecondTabFrag secondTabFrag = SecondTabFrag.getInstance();
                return secondTabFrag;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
