package com.chintansoni.android.randomuserdagger;

import android.app.Activity;
import android.app.Application;

import com.chintansoni.android.randomuserdagger.di.component.DaggerRandomUserApplicationComponent;
import com.chintansoni.android.randomuserdagger.di.component.RandomUserApplicationComponent;
import com.chintansoni.android.randomuserdagger.di.module.ContextModule;

import timber.log.Timber;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/3/2017.
 */

public class RandomUserApplication extends Application {

    private RandomUserApplicationComponent randomUserApplicationComponent;

    public static RandomUserApplication get(Activity activity) {
        return (RandomUserApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        randomUserApplicationComponent = DaggerRandomUserApplicationComponent.builder()
                .contextModule(new ContextModule(this))
//                .okHttpClientModule(new OkHttpClientModule())
//                .randomUserServiceModule(new RandomUserServiceModule())
//                .picassoModule(new PicassoModule())
                .build();
    }

    public RandomUserApplicationComponent randomUserApplicationComponent() {
        return randomUserApplicationComponent;
    }
}
