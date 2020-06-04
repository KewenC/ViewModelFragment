package com.kewenc.viewmodelfragment;

import android.content.Context;

public class SecondThemeFactory extends AbstractThemeFactory {

    public SecondThemeFactory(Context context) {
        super(context);
    }

    @Override
    public ThemeVisualizer createVisualizer() {
        return new VisualizerSecond(context);
    }

}
