package com.chintansoni.android.randomuserdagger.di.component;

import com.chintansoni.android.randomuserdagger.MainActivity;
import com.chintansoni.android.randomuserdagger.di.module.MainActivityModule;
import com.chintansoni.android.randomuserdagger.di.scope.MainActivityScope;

import dagger.Component;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/6/2017.
 */

@Component(modules = MainActivityModule.class, dependencies = RandomUserApplicationComponent.class)
@MainActivityScope
public interface MainActivityComponent {
    void injectMainActivity(MainActivity mainActivity);
}
