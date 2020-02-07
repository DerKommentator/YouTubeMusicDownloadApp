package com.app.youtubemusicdownloader.fragments;

import android.app.Activity;
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
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
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
    ArrayList<View> editText_views = new ArrayList<>();


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
        return inflater.inflate(R.layout.fragment_createurllist, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        final View root_view = getView();
        if(root_view != null)
        {
            button_add_url = (Button)root_view.findViewById(R.id.button_add_url);
            //root_view.findViewsWithText(editText_views, "edittext_url_input", View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);

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
                    //Log.d("ArrayEdit", "" + editText_views);
                }
            });
        }
    }

}
