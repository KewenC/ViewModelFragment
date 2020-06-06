package com.kewenc.viewmodelfragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    private MainViewModel mainViewModel;
    private MainActivity mainActivity;
    private TextView tv_first_title;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.first_fragment, container, false);
        tv_first_title = v.findViewById(R.id.tv_first_title);

        AbstractThemeFactory firstThemeFactory = new FirstThemeFactory(mainActivity, v);
        ThemeVisualizer themeVisualizer = firstThemeFactory.createVisualizer();
        themeVisualizer.openVisualizer();

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = new ViewModelProvider(mainActivity).get(MainViewModel.class);
        mainViewModel.titleText.observe(mainActivity, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_first_title.setText(s);
            }
        });

    }

}