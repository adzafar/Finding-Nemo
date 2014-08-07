package com.flipkart.adeelzafar.finding_nemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class AbstractAlertFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private int param1;

    public void setArgs(int param1) {
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        setArguments(args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getInt(ARG_PARAM1);
        }
    }
}
