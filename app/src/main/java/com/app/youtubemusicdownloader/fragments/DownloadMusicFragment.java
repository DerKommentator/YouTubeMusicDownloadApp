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
    TextView songs_list;
    EditText songs_url_input;
    ArrayList<View> editText_views = new ArrayList<>();


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
            songs_list = (TextView)root_view.findViewById(R.id.songs_list);


            fetch_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View createDLList_view = getFragmentManager().getFragments().get(0).getView();
                    //createDLList_view.findViewsWithText(editText_views, "", View.FIND_VIEWS_WITH_TEXT);

                    Log.d("fragMNG", "" + songs_url_input.getText().toString());
                    //Log.d("EditText", songs_url_input.toString());
                }
            });
        }
    }
}
