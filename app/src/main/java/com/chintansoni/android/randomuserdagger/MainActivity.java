package com.chintansoni.android.randomuserdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.chintansoni.android.randomuserdagger.adapter.RandomUserAdapter;
import com.chintansoni.android.randomuserdagger.api.response.RandomUserApiResponse;
import com.chintansoni.android.randomuserdagger.api.service.RandomUserService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Call<RandomUserApiResponse> randomUserApiResponseCall;
    private RandomUserService randomUserService;
    private RecyclerView recyclerView;
    private RandomUserAdapter randomUserAdapter;
    private Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomUserService = RandomUserApplication.get(this).getRandomUserService();
        picasso = RandomUserApplication.get(this).getPicasso();

        recyclerView = findViewById(R.id.rv_main);
        randomUserAdapter = new RandomUserAdapter(this, picasso);
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
