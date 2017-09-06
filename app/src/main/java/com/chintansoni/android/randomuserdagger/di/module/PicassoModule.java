package com.chintansoni.android.randomuserdagger.di.module;

import android.content.Context;

import com.chintansoni.android.randomuserdagger.di.namedQualifier.ApplicationContext;
import com.chintansoni.android.randomuserdagger.di.scope.RandomUserApplicationScope;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/6/2017.
 */

@Module(includes = OkHttpClientModule.class)
public class PicassoModule {

    @Provides
    @RandomUserApplicationScope
    public Picasso picasso(@ApplicationContext Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @RandomUserApplicationScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
