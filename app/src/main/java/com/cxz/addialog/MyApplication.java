package com.cxz.addialog;

import android.app.Application;

import com.cxz.adlibrary.AdManager;

/**
 * Created by admin on 2018/6/14.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AdManager.init(this);

    }
}
