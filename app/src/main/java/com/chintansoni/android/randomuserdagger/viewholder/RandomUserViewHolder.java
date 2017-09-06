package com.chintansoni.android.randomuserdagger.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chintansoni.android.randomuserdagger.R;

/**
 * Created by: Chintan Soni - Senior Software Engineer
 * Created Date: 9/3/2017.
 */

public class RandomUserViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public ImageView imageView;

    public RandomUserViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_random_user);
        imageView = itemView.findViewById(R.id.iv_random_user);
    }
}
