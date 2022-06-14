package com.example.project.adapter;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.project.MainFragment;
import com.example.project.CategoryFragment;
import com.example.project.NearestStoreFragment;
import com.example.project.MainActivity;
import com.example.project.SearchFragment;
import com.example.project.interfaces.OnMapItemClickListener;
import com.example.project.models.Store;

public class FragmentAdapter extends FragmentPagerAdapter implements OnMapItemClickListener  {

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MainFragment();
                break;
            case 1:
                fragment = new CategoryFragment();
                break;
            case 2:
                fragment = new NearestStoreFragment();
                break;
            case 3:
                fragment = SearchFragment.getInstance();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return MainActivity.TAB_COUNT;
    }



    @Override
    public void selectedItem(String address) {

    }
}
