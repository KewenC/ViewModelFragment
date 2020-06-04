package com.kewenc.viewmodelfragment;

import android.content.Context;

public abstract class AbstractThemeFactory {

    protected Context context;

    public AbstractThemeFactory(Context context) {
        this.context = context;
    }

    public abstract ThemeVisualizer createVisualizer();

}
