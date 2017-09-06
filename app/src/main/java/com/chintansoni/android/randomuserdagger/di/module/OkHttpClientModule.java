package com.chintansoni.android.randomuserdagger.di.module;

import android.content.Context;

import com.chintansoni.android.randomuserdagger.di.namedQualifier.ApplicationContext;
import com.chintansoni.android.randomuserdagger.di.scope.RandomUserApplicationScope;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/6/2017.
 */

@Module(includes = ContextModule.class)
public class OkHttpClientModule {

    @Provides
    @RandomUserApplicationScope
    public OkHttpClient okHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @RandomUserApplicationScope
    public Cache cache(File file) {
        return new Cache(file, 10 * 1000 * 1000); // 10 mb cache file
    }

    @Provides
    @RandomUserApplicationScope
    public File file(@ApplicationContext Context context) {
        File file = new File(context.getCacheDir(), "OkHttpCache");
        file.mkdirs();
        return file;
    }

    @Provides
    @RandomUserApplicationScope
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
