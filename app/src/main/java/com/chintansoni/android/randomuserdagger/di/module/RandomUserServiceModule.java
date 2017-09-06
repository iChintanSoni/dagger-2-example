package com.chintansoni.android.randomuserdagger.di.module;

import com.chintansoni.android.randomuserdagger.api.service.RandomUserService;
import com.chintansoni.android.randomuserdagger.di.scope.RandomUserApplicationScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/6/2017.
 */

@Module(includes = OkHttpClientModule.class)
public class RandomUserServiceModule {

    @Provides
    @RandomUserApplicationScope
    public RandomUserService randomUserService(Retrofit retrofit) {
        return retrofit.create(RandomUserService.class);
    }

    @Provides
    @RandomUserApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .baseUrl("https://randomuser.me/")
                .build();
    }

    @Provides
    @RandomUserApplicationScope
    public GsonConverterFactory gsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @RandomUserApplicationScope
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
}
