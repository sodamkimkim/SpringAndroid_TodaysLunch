package com.example.project.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.project.Fragment1;
import com.example.project.Fragment2;
import com.example.project.Fragment3;
import com.example.project.MainActivity;
import com.example.project.SearchFragment;
import com.example.project.interfaces.OnMapItemClickListener;
import com.example.project.models.Store;

public class FragmentAdapter extends FragmentPagerAdapter implements OnMapItemClickListener {

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3(this);
                break;
            case 3:
                fragment = new SearchFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return MainActivity.TAB_COUNT;
    }

    @Override
    public void selectedItem(Store store) {

    }
}
