package com.chintansoni.android.randomuserdagger.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chintansoni.android.randomuserdagger.R;
import com.chintansoni.android.randomuserdagger.api.response.Result;
import com.chintansoni.android.randomuserdagger.viewholder.RandomUserViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/3/2017.
 */

public class RandomUserAdapter extends RecyclerView.Adapter<RandomUserViewHolder> {

    private final Picasso picasso;
    private final Context context;
    private List<Result> resultList = new ArrayList<>();

    public RandomUserAdapter(Context context, Picasso picasso) {
        this.context = context;
        this.picasso = picasso;
    }

    @Override
    public RandomUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_random_user, parent, false);
        return new RandomUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RandomUserViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.textView.setText(String.format("%s %s", result.getName().getFirst(), result.getName().getLast()));
        picasso.with(context)
                .load(result.getPicture().getLarge())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setItems(List<Result> results) {
        resultList = results;
        notifyDataSetChanged();
    }
}
