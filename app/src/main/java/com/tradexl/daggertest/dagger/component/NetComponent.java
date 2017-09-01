package com.tradexl.daggertest.dagger.component;

import com.tradexl.daggertest.MainActivity;
import com.tradexl.daggertest.dagger.module.AppModule;
import com.tradexl.daggertest.dagger.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Raghav on 01-Sep-17.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}
