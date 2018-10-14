package com.hxytest.pk.testncxl;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by pk on 18/10/12.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
              return;
        }
        LeakCanary.install(this);
    }
}
