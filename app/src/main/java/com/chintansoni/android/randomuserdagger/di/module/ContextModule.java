package com.chintansoni.android.randomuserdagger.di.module;

import android.content.Context;

import com.chintansoni.android.randomuserdagger.di.namedQualifier.ApplicationContext;
import com.chintansoni.android.randomuserdagger.di.scope.RandomUserApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/6/2017.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @RandomUserApplicationScope
    @ApplicationContext
    public Context context() {
        return context;
    }
}
