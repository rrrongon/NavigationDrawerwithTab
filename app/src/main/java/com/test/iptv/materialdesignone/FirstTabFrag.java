package com.test.iptv.materialdesignone;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Developed by root on 4/2/16.
 */
public class FirstTabFrag extends Fragment {
    public static FirstTabFrag getInstance(){
        FirstTabFrag firstTabFragIns = new FirstTabFrag();
        return firstTabFragIns;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View layout = inflater.inflate(R.layout.firsttabcontent,container,false);
        return layout;
    }
}
