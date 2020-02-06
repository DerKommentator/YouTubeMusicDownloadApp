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
import com.app.youtubemusicdownloader.activity.MainActivity;


public class DownloadMusicFragment extends Fragment{

    public DownloadMusicFragment() {
        // Required empty public constructor
    }

    Button fetch_button;
    TextView songs_list;
    EditText songs_url_input;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root_view = inflater.inflate(R.layout.fragment_downloadmusic, container, false);

        fetch_button = (Button)root_view.findViewById(R.id.fetch_songs);
        songs_list = (TextView)root_view.findViewById(R.id.songs_list);
        songs_url_input = (EditText)root_view.findViewById(R.id.edittext_url_input);


        fetch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("EditText", songs_url_input.toString());
            }
        });



        return root_view;
    }

}
