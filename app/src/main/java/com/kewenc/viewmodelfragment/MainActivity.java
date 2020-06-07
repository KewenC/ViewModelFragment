package com.kewenc.viewmodelfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel mainViewModel;
    private Button btn_main_first;
    private Button btn_main_second;
    private Fragment contentFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Button btn_main_modify;
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        btn_main_first = findViewById(R.id.btn_main_first);
        btn_main_modify = findViewById(R.id.btn_main_modify);
        btn_main_second = findViewById(R.id.btn_main_second);

        btn_main_first.setOnClickListener(this);
        btn_main_modify.setOnClickListener(this);
        btn_main_second.setOnClickListener(this);

        mainViewModel.setTitleText("Hello ViewModel !");

        contentFragment = FirstFragment.newInstance();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main_content, contentFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_first:
                List fragmentList = getSupportFragmentManager().getFragments();
                int size = fragmentList.size();
                Log.i("TAGF", "size="+size);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(contentFragment);
                fragmentTransaction.commitAllowingStateLoss();

                List fragmentList2 = getSupportFragmentManager().getFragments();
                int size2 = fragmentList2.size();
                Log.i("TAGF", "size2="+size2);

                fragmentTransaction = fragmentManager.beginTransaction();
                contentFragment = FirstFragment.newInstance();
                fragmentTransaction.replace(R.id.fl_main_content, contentFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
            case R.id.btn_main_modify:
                number++;
                mainViewModel.setTitleText("自增数字：" + number);
                break;
            case R.id.btn_main_second:
                contentFragment = SecondFragment.newInstance();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_main_content, contentFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
        }
    }
}