package com.test.iptv.materialdesignone;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFrag extends Fragment {

    private ActionBarDrawerToggle  mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    boolean mDrawer = false;

    public NavigationDrawerFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar) {
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                /*if (!mDrawer){
                    mDrawer=true;
                    saveToSharedPref(getActivity(),"drawerState",mDrawer+"");
                }*/

                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };


        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    public static void saveToSharedPref(Context context, String prefKey, String prefValue){
        SharedPreferences sharedPref = context.getSharedPreferences("file_name",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(prefKey, prefValue);
        editor.apply();
    }

    public static String readFromPreference(Context context, String prefKey, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("file_name",Context.MODE_PRIVATE);
        return sharedPreferences.getString(prefKey,defaultValue);
    }
}
