package com.chintansoni.android.randomuserdagger.di.component;

import com.chintansoni.android.randomuserdagger.api.service.RandomUserService;
import com.chintansoni.android.randomuserdagger.di.module.ActivityModule;
import com.chintansoni.android.randomuserdagger.di.module.PicassoModule;
import com.chintansoni.android.randomuserdagger.di.module.RandomUserServiceModule;
import com.chintansoni.android.randomuserdagger.di.scope.RandomUserApplicationScope;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/6/2017.
 */

@RandomUserApplicationScope
@Component(modules = {RandomUserServiceModule.class, PicassoModule.class, ActivityModule.class})
public interface RandomUserApplicationComponent {

    Picasso getPicasso();

    RandomUserService getRandomUserService();
}
