package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.LongDef;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.project.databinding.Fragment2Binding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment implements View.OnClickListener {

    private Fragment2Binding fragment2Binding;

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

        fragment2Binding = Fragment2Binding.inflate(inflater, container, false);
        buttons = new ArrayList<>();

        btn1AllMenu = fragment2Binding.btn1AllMenu;
        btn2Rice = fragment2Binding.btn2Rice;
        btn3Noddle = fragment2Binding.btn3Noddle;
        btn4Soup = fragment2Binding.btn4Soup;
        btn5Bunsig = fragment2Binding.btn5Bunsig;
        btn6Dietary = fragment2Binding.btn6Dietary;
        btn7Instant = fragment2Binding.btn7Instant;
        btn8Overseas = fragment2Binding.btn8Overseas;
        btn9Seasoned = fragment2Binding.btn9Seasoned;

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

        return fragment2Binding.getRoot();
    }


    @Override
    public void onClick(View v) {
        Fragment childFragment;

        switch (v.getId()) {
            case R.id.btn1AllMenu:
                fragment2Binding.btn1AllMenu.setEnabled(false);
                buttonEventListener(fragment2Binding.btn1AllMenu);
                childFragment = new ChildFragment1().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn2Rice:
                fragment2Binding.btn2Rice.setEnabled(false);
                buttonEventListener(fragment2Binding.btn2Rice);
                childFragment = new ChildFragment2().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn3Noddle:
                fragment2Binding.btn3Noddle.setEnabled(false);
                buttonEventListener(fragment2Binding.btn3Noddle);
                childFragment = new ChildFragment3().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn4Soup:
                fragment2Binding.btn4Soup.setEnabled(false);
                buttonEventListener(fragment2Binding.btn4Soup);
                childFragment = new ChildFragment4().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn5Bunsig:
                fragment2Binding.btn5Bunsig.setEnabled(false);
                buttonEventListener(fragment2Binding.btn5Bunsig);
                childFragment = new ChildFragment5().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn6Dietary:
                fragment2Binding.btn6Dietary.setEnabled(false);
                buttonEventListener(fragment2Binding.btn6Dietary);
                childFragment = new ChildFragment6().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn7Instant:
                fragment2Binding.btn7Instant.setEnabled(false);
                buttonEventListener(fragment2Binding.btn7Instant);
                childFragment = new ChildFragment7().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn8Overseas:
                fragment2Binding.btn8Overseas.setEnabled(false);
                buttonEventListener(fragment2Binding.btn8Overseas);;
                childFragment = new ChildFragment8().newInstance();
                setChildFragment(childFragment);
                break;

            case R.id.btn9Seasoned:
                fragment2Binding.btn9Seasoned.setEnabled(false);
                buttonEventListener(fragment2Binding.btn9Seasoned);
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
