package com.intuition.weatherly.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
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
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @BindView(R.id.favRecyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_locations);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

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

    //Set Up Menu//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Menu onClicks//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        if (id == R.id.add_city) {
            Intent intent = new Intent(FavoriteLocationsActivity.this, MainActivity.class);
            startActivity(intent);
            mEditor.putString(Constants.PREFERENCES_NEW_CITY, "true").apply();
        }
        if (id == R.id.saved_locs) {
            Intent intent = new Intent(FavoriteLocationsActivity.this, FavoriteLocationsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.home_city) {
            mEditor.putString(Constants.PREFERENCES_NEW_CITY, "").apply();
            Intent intent = new Intent(FavoriteLocationsActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(FavoriteLocationsActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
