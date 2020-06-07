package com.kewenc.viewmodelfragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private MainViewModel mainViewModel;
    private MainActivity mainActivity;
    private TextView tv_second_title;
    private View v;
    private LayoutInflater inflater;
    private ViewGroup container;
    private Button btn_second_change;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    public void changeView() {
        container.removeAllViews();
        v = inflater.inflate(R.layout.second_2_fragment, container, false);
        container.addView(v);
        tv_second_title = v.findViewById(R.id.tv_second_title);
        onActivityCreated(null);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("TAGF", this.getClass().getSimpleName() +"_onAttach");
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAGF", this.getClass().getSimpleName() +"_onCreate");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i("TAGF", this.getClass().getSimpleName() +"_onCreateView");
        this.inflater = inflater;
        this.container = container;
        v =  inflater.inflate(R.layout.second_fragment, container, false);
        tv_second_title = v.findViewById(R.id.tv_second_title);
        btn_second_change = v.findViewById(R.id.btn_second_change);
        btn_second_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView();
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("TAGF", this.getClass().getSimpleName() +"_onActivityCreated");
        mainViewModel = new ViewModelProvider(mainActivity).get(MainViewModel.class);
        mainViewModel.titleText.observe(mainActivity, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_second_title.setText(s);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        container.removeAllViews();
        Log.i("TAGF", this.getClass().getSimpleName() +"_onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("TAGF", this.getClass().getSimpleName() +"_onDetach");
        mainActivity = null;
    }

}