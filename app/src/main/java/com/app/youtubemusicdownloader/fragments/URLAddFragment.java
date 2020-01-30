package com.app.youtubemusicdownloader.fragments;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.app.youtubemusicdownloader.R;

public class URLAddFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* Inflating the layout for this fragment */
        return inflater.inflate(R.layout.field_url_add2, null);
    }
}
