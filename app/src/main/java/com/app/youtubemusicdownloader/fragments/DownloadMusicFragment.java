package com.app.youtubemusicdownloader.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.youtubemusicdownloader.R;

import java.util.ArrayList;


public class DownloadMusicFragment extends Fragment{

    public DownloadMusicFragment() {
        // Required empty public constructor
    }

    Button fetch_button;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_downloadmusic, container, false);

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        View root_view = getView();


        if(root_view != null)
        {
            fetch_button = (Button)root_view.findViewById(R.id.fetch_songs);
            final View createDLList_view = getFragmentManager().getFragments().get(0).getView();

            fetch_button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    //EditText test = (EditText)createDLList_view.findViewWithTag("edit_text_input_url0");
                    //Log.d("printEdit", "" + getFragmentManager().getFragments());
                    // TODO     transfer der url Strings in dieses Fragment
                }
            });
        }
    }
}
