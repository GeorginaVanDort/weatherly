package com.intuition.weatherly.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.intuition.weatherly.R;
import com.intuition.weatherly.models.Location;
import com.intuition.weatherly.ui.WeatherDisplayActivity;
import com.squareup.picasso.Picasso;

public class FirebaseLocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseLocationViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindLocationViews (Location location) {
        ImageView locImage = (ImageView) mView.findViewById(R.id.locImage);
        TextView locCity = (TextView) mView.findViewById(R.id.locListCity);
        TextView locAddress = (TextView) mView.findViewById(R.id.locListAddress);
        TextView locLat = (TextView) mView.findViewById(R.id.locListLat);
        TextView locLong = (TextView) mView.findViewById(R.id.locListLong);

        Typeface leck = Typeface.createFromAsset(mContext.getAssets(),"fonts/breeze.ttf");
        locCity.setTypeface(leck);

        Picasso.with(mContext)
                .load(location.getIconUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(locImage);

        locCity.setText(location.getCity());
        locAddress.setText(location.getAddress());
        locLat.setText(location.getLatitude().toString());
        locLong.setText(location.getLongitude().toString());
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, WeatherDisplayActivity.class);
        mContext.startActivity(intent);
    }
}
