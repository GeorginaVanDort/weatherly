package com.intuition.weatherly.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.intuition.weatherly.Constants;
import com.intuition.weatherly.R;
import com.intuition.weatherly.adapters.FirebaseLocationViewHolder;
import com.intuition.weatherly.models.Location;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteLocationsActivity extends AppCompatActivity {

    private DatabaseReference mLocationRef;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @BindView(R.id.favRecyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_locations);
        ButterKnife.bind(this);

        mLocationRef = FirebaseDatabase.getInstance().getReference(Constants.FB_LOCATION);
        bindAdapter();
    }

    private void bindAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter <Location, FirebaseLocationViewHolder>
                (Location.class, R.layout.fav_location_item, FirebaseLocationViewHolder.class, mLocationRef) {
            @Override
            protected void populateViewHolder(FirebaseLocationViewHolder viewHolder, Location location, int position) {
                viewHolder.bindLocationViews(location);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
