package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.databinding.Fragment2Binding;

public class Fragment2 extends Fragment implements View.OnClickListener {

    Fragment2Binding fragment2Binding;

    public Fragment2() {
        // Required empty public constructor
    }


    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//        FoodAdapter foodAdapter = new FoodAdapter(Food.getFoodData(), getActivity(), new OnFoodItemClickListener() {
//            @Override
//            public void onItemClicked(View view, int position) {
//
//            }
//        });


        fragment2Binding = Fragment2Binding.inflate(inflater, container, false);

        Button btn1AllMenu = fragment2Binding.btn1AllMenu;
        btn1AllMenu.setOnClickListener(this);
        Button btn2Rice = fragment2Binding.btn2Rice;
        btn2Rice.setOnClickListener(this);
        Button btn3Noddle = fragment2Binding.btn3Noddle;
        btn3Noddle.setOnClickListener(this);
        Button btn4Soup = fragment2Binding.btn4Soup;
        btn4Soup.setOnClickListener(this);
        Button btn5Bunsig = fragment2Binding.btn5Bunsig;
        btn5Bunsig.setOnClickListener(this);
        Button btn6Dietary = fragment2Binding.btn6Dietary;
        btn6Dietary.setOnClickListener(this);
        Button btn7Instant = fragment2Binding.btn7Instant;
        btn7Instant.setOnClickListener(this);
        Button btn8Overseas = fragment2Binding.btn8Overseas;
        btn8Overseas.setOnClickListener(this);
        Button btn9Seasoned = fragment2Binding.btn9Seasoned;
        btn9Seasoned.setOnClickListener(this);

        btn1AllMenu.performClick();


        return fragment2Binding.getRoot();
    }


    @Override
    public void onClick(View v) {
        Fragment childFragment;
        switch (v.getId()) {
            case R.id.btn1AllMenu:
                childFragment = new ChildFragment1().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn2Rice:
                childFragment = new ChildFragment2().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn3Noddle:
                childFragment = new ChildFragment3().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn4Soup:
                childFragment = new ChildFragment4().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn5Bunsig:
                childFragment = new ChildFragment5().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn6Dietary:
                childFragment = new ChildFragment6().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn7Instant:
                childFragment = new ChildFragment7().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn8Overseas:
                childFragment = new ChildFragment8().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn9Seasoned:
                childFragment = new ChildFragment9().newInstance();
                setChildFragment(childFragment);
                break;

        }
    }

    private void setChildFragment(Fragment childFragment) {
        FragmentTransaction childFragmentTransaction = getChildFragmentManager().beginTransaction();

        childFragmentTransaction.replace(R.id.childFragmentContainer, childFragment);
        childFragmentTransaction.addToBackStack(null);
        childFragmentTransaction.commit();

    }
}