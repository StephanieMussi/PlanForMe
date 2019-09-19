package com.planforme.jamot.planforme.control;

import android.content.Context;

public class ContextHandler {
    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        ContextHandler.context = context;
    }

    private static Context context;


}
