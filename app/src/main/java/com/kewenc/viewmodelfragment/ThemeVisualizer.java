package com.kewenc.viewmodelfragment;

import android.content.Context;
import android.view.View;

public abstract class ThemeVisualizer extends View {

    public ThemeVisualizer(Context context) {
        super(context);
    }

    abstract void initTheme();

    abstract void openVisualizer();

    abstract void closeVisualizer();

    abstract void releaseVisualizer();

}
