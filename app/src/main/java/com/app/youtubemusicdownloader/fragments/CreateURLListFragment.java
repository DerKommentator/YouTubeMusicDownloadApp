package com.app.youtubemusicdownloader.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.youtubemusicdownloader.R;


public class CreateURLListFragment extends Fragment {

    public CreateURLListFragment()
    {
        // Required empty public constructor
    }

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
        final View root_view = inflater.inflate(R.layout.fragment_createurllist, container, false);

        final Button button_add_url = (Button)root_view.findViewById(R.id.button_add_url);
        final Button button_del_url = (Button)root_view.findViewById(R.id.button_delete_url);


        button_add_url.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
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
