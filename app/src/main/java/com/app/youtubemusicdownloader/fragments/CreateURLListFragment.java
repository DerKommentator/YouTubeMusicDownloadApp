package com.app.youtubemusicdownloader.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.app.youtubemusicdownloader.R;
import com.app.youtubemusicdownloader.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class CreateURLListFragment extends Fragment {

    public CreateURLListFragment()
    {
        // Required empty public constructor
    }

    Button button_add_url;
    EditText songs_url_input;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View root_view = inflater.inflate(R.layout.fragment_createurllist, container, false);

        button_add_url = (Button)root_view.findViewById(R.id.button_add_url);

        songs_url_input = (EditText)root_view.findViewById(R.id.edittext_url_input);


        button_add_url.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("EditText", songs_url_input.getText().toString());

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                URLAddFragment urlAddFragment = new URLAddFragment();
                fragmentTransaction.add(R.id.fragment_container_url_add, urlAddFragment, "urlAddFragment");
                fragmentTransaction.commit();
            }
        });

        return root_view;
    }

}
