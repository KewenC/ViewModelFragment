package com.kewenc.viewmodelfragment;

import android.content.Context;
import android.view.View;

public class FirstThemeFactory extends AbstractThemeFactory {

    private final View view;

    public FirstThemeFactory(Context context, View view) {
        super(context);
        this.view = view;
    }

    @Override
    public ThemeVisualizer createVisualizer() {
        return new VisualizerFirst(context);
//        return view.findViewById(R.id.tv_first_title);
    }

}
