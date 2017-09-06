package com.chintansoni.android.randomuserdagger.di.module;

import com.chintansoni.android.randomuserdagger.MainActivity;
import com.chintansoni.android.randomuserdagger.di.scope.MainActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/6/2017.
 */

@Module
public class MainActivityModule {

    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    MainActivity mainActivity() {
        return mainActivity;
    }
}
