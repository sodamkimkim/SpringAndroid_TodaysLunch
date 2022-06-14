package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.project.Define.CategoryType;
import com.example.project.databinding.FragmentSelectedbyCategoryBinding;
import com.example.project.models.Category;

import java.util.ArrayList;


public class SelectedByCategoryFragment extends Fragment implements View.OnClickListener {

    private FragmentSelectedbyCategoryBinding fragmentBinding;

    private Button btn1AllMenu;
    private Button btn2Rice;
    private Button btn3Noddle;
    private Button btn4Soup;
    private Button btn5Bunsig;
    private Button btn6Dietary;
    private Button btn7Instant;
    private Button btn8Overseas;
    private Button btn9Seasoned;

    private ArrayList<Button> buttons;
    ChildFragment1 childFragment;

    public SelectedByCategoryFragment() {
        childFragment = ChildFragment1.getInstance();
    }


    public static SelectedByCategoryFragment newInstance(String param1, String param2) {
        SelectedByCategoryFragment fragment = new SelectedByCategoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentBinding = FragmentSelectedbyCategoryBinding.inflate(inflater, container, false);
        buttons = new ArrayList<>();

        btn1AllMenu = fragmentBinding.btn1AllMenu;
        btn2Rice = fragmentBinding.btn2Rice;
        btn3Noddle = fragmentBinding.btn3Noddle;
        btn4Soup = fragmentBinding.btn4Soup;
        btn5Bunsig = fragmentBinding.btn5Bunsig;
        btn6Dietary = fragmentBinding.btn6Dietary;
        btn7Instant = fragmentBinding.btn7Instant;
        btn8Overseas = fragmentBinding.btn8Overseas;
        btn9Seasoned = fragmentBinding.btn9Seasoned;

        buttons.add(btn1AllMenu);
        buttons.add(btn2Rice);
        buttons.add(btn3Noddle);
        buttons.add(btn4Soup);
        buttons.add(btn5Bunsig);
        buttons.add(btn6Dietary);
        buttons.add(btn7Instant);
        buttons.add(btn8Overseas);
        buttons.add(btn9Seasoned);

        setOnClickListener();
        btn1AllMenu.performClick();
        setChildFragment(childFragment);

        return fragmentBinding.getRoot();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn1AllMenu:
                fragmentBinding.btn1AllMenu.setEnabled(false);
                buttonEventListener(fragmentBinding.btn1AllMenu);
                childFragment.requestFoodsData("");
                break;

            case R.id.btn2Rice:
                fragmentBinding.btn2Rice.setEnabled(false);
                buttonEventListener(fragmentBinding.btn2Rice);
                childFragment.requestFoodsData(CategoryType.RICE.toString());
                break;

            case R.id.btn3Noddle:
                fragmentBinding.btn3Noddle.setEnabled(false);
                buttonEventListener(fragmentBinding.btn3Noddle);
                childFragment.requestFoodsData(CategoryType.NOODLE.toString());
                break;

            case R.id.btn4Soup:
                fragmentBinding.btn4Soup.setEnabled(false);
                buttonEventListener(fragmentBinding.btn4Soup);
                childFragment.requestFoodsData(CategoryType.SOUP.toString());
                break;

            case R.id.btn5Bunsig:
                fragmentBinding.btn5Bunsig.setEnabled(false);
                buttonEventListener(fragmentBinding.btn5Bunsig);
                childFragment.requestFoodsData(CategoryType.BUNSIG.toString());
                break;

            case R.id.btn6Dietary:
                fragmentBinding.btn6Dietary.setEnabled(false);
                buttonEventListener(fragmentBinding.btn6Dietary);
                childFragment.requestFoodsData(CategoryType.DIET.toString());
                break;

            case R.id.btn7Instant:
                fragmentBinding.btn7Instant.setEnabled(false);
                buttonEventListener(fragmentBinding.btn7Instant);
                childFragment.requestFoodsData(CategoryType.INSTANT.toString());
                break;

            case R.id.btn8Overseas:
                fragmentBinding.btn8Overseas.setEnabled(false);
                buttonEventListener(fragmentBinding.btn8Overseas);;
                childFragment.requestFoodsData(CategoryType.OVERSEA.toString());
                break;

            case R.id.btn9Seasoned:
                fragmentBinding.btn9Seasoned.setEnabled(false);
                buttonEventListener(fragmentBinding.btn9Seasoned);
                childFragment.requestFoodsData(CategoryType.SEASON.toString());
                break;

        }
    }

    private void setChildFragment(Fragment childFragment) {
        FragmentTransaction childFragmentTransaction = getChildFragmentManager().beginTransaction();
        childFragmentTransaction.replace(R.id.childFragmentContainer, childFragment);
        childFragmentTransaction.addToBackStack(null);
        childFragmentTransaction.commit();

    }


    private void setOnClickListener() {
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
    }


    private void buttonEventListener(Button curruntButton) {
        for (Button button : buttons) {
            if (button == curruntButton) {
                continue;
            }
            button.setEnabled(true);


        }
    }

}
