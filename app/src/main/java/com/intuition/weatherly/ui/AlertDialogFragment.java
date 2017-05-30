package com.intuition.weatherly.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Oops!")
                .setMessage("Please enter a City")
                .setPositiveButton("OK", null);

        AlertDialog dialog = builder.create();
        return dialog;
    }

}