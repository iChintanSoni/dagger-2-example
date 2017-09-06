package com.chintansoni.android.randomuserdagger;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.chintansoni.android.randomuserdagger.api.service.RandomUserService;
import com.chintansoni.android.randomuserdagger.di.component.DaggerRandomUserApplicationComponent;
import com.chintansoni.android.randomuserdagger.di.component.RandomUserApplicationComponent;
import com.chintansoni.android.randomuserdagger.di.module.ContextModule;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/3/2017.
 */

public class RandomUserApplication extends Application {

    private RandomUserService randomUserService;
    private Picasso picasso;

    public static RandomUserApplication get(Activity activity) {
        return (RandomUserApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Context context = this;

        Timber.plant(new Timber.DebugTree());

        RandomUserApplicationComponent randomUserApplicationComponent = DaggerRandomUserApplicationComponent.builder()
                .contextModule(new ContextModule(this))
//                .okHttpClientModule(new OkHttpClientModule())
//                .randomUserServiceModule(new RandomUserServiceModule())
//                .picassoModule(new PicassoModule())
                .build();

        randomUserService = randomUserApplicationComponent.getRandomUserService();
        picasso = randomUserApplicationComponent.getPicasso();
    }

    public RandomUserService getRandomUserService() {
        return randomUserService;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
