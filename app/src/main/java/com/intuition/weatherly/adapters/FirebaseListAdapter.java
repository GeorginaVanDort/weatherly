package com.intuition.weatherly.adapters;

import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.intuition.weatherly.models.Location;
import com.intuition.weatherly.util.ItemTouchHelperAdapter;

/**
 * Created by Guest on 6/14/17.
 */

public class FirebaseListAdapter extends FirebaseRecyclerAdapter <Location, FirebaseLocationViewHolder> implements ItemTouchHelperAdapter {

    private DatabaseReference mRef;
    private Context mContext;

    public FirebaseListAdapter(Class<Location> modelClass, int modelLayout, Class<FirebaseLocationViewHolder> viewHolderClass, Query ref, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mContext = context;
    }

    @Override
    protected void populateViewHolder(FirebaseLocationViewHolder viewHolder, Location model, int position) {
        viewHolder.bindLocationViews(model);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

    }
}
