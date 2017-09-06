package com.chintansoni.android.randomuserdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.chintansoni.android.randomuserdagger.adapter.RandomUserAdapter;
import com.chintansoni.android.randomuserdagger.api.response.RandomUserApiResponse;
import com.chintansoni.android.randomuserdagger.api.service.RandomUserService;
import com.chintansoni.android.randomuserdagger.di.component.DaggerMainActivityComponent;
import com.chintansoni.android.randomuserdagger.di.component.MainActivityComponent;
import com.chintansoni.android.randomuserdagger.di.module.MainActivityModule;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Call<RandomUserApiResponse> randomUserApiResponseCall;
    @Inject
    RandomUserService randomUserService;
    @Inject
    RandomUserAdapter randomUserAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .randomUserApplicationComponent(RandomUserApplication.get(this).randomUserApplicationComponent())
                .build();
        mainActivityComponent.injectMainActivity(this);

        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setAdapter(randomUserAdapter);

        randomUserApiResponseCall = randomUserService.randomUser(10);
        randomUserApiResponseCall.enqueue(new Callback<RandomUserApiResponse>() {
            @Override
            public void onResponse(Call<RandomUserApiResponse> call, Response<RandomUserApiResponse> response) {
                randomUserAdapter.setItems(response.body().getResults());
            }

            @Override
            public void onFailure(Call<RandomUserApiResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        randomUserApiResponseCall.cancel();
    }
}
