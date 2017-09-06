package com.chintansoni.android.randomuserdagger.api.service;

import com.chintansoni.android.randomuserdagger.api.response.RandomUserApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/3/2017.
 */

public interface RandomUserService {
    @GET("api")
    Call<RandomUserApiResponse> randomUser(@Query("results") int size);
}
