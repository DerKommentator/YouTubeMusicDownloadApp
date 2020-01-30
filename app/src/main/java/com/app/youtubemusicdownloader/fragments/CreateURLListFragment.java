package com.app.youtubemusicdownloader.fragments;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Context;

import com.app.youtubemusicdownloader.R;
import com.app.youtubemusicdownloader.activity.MainActivity;


public class CreateURLListFragment extends Fragment{

    public CreateURLListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View root_view = inflater.inflate(R.layout.fragment_createurllist, container, false);

        final Button button_add_url = (Button)root_view.findViewById(R.id.button_add_url);





        button_add_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                URLAddFragment urlAddFragment = new URLAddFragment();
                fragmentTransaction.add(R.id.fragment_container_url_add, urlAddFragment, "urlAddFragment");
                fragmentTransaction.commit();

                //ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //container.addView(button_add_url, lp);

                /*LayoutInflater field_inflater = (LayoutInflater)view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View row_view = field_inflater.inflate(R.layout.field_url_add, container);
                container.addView(row_view, container.getChildCount() - 1);*/
            }
        });


        return root_view;
    }
}
