package com.tradexl.daggertest;

import android.app.Application;
import android.content.Context;


import com.tradexl.daggertest.dagger.component.DaggerNetComponent;
import com.tradexl.daggertest.dagger.component.NetComponent;
import com.tradexl.daggertest.dagger.module.AppModule;
import com.tradexl.daggertest.dagger.module.NetModule;

/**
 * Created by Raghav on 01-Sep-17.
 */

public class App extends Application {
    private static Context context;
    NetComponent mNetComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        App.context = getApplicationContext();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.stackexchange.com/2.2/"))
                .build();
    }
    public static Context getStaticContext()
    {
        return App.context;
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}

