package com.chintansoni.android.randomuserdagger.di.module;

import android.app.Activity;
import android.content.Context;

import com.chintansoni.android.randomuserdagger.di.scope.RandomUserApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/6/2017.
 */

@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @Provides
    @RandomUserApplicationScope
    @Named("activity_context")
    public Context context() {
        return context;
    }
}
