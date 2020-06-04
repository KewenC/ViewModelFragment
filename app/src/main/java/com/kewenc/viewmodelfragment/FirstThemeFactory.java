package com.kewenc.viewmodelfragment;

import android.content.Context;

public class FirstThemeFactory extends AbstractThemeFactory {

    public FirstThemeFactory(Context context) {
        super(context);
    }

    @Override
    public ThemeVisualizer createVisualizer() {
        return new VisualizerFirst(context);
    }

}
