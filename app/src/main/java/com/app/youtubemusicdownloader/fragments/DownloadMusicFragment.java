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
import java.util.Arrays;


public class DownloadMusicFragment extends Fragment{

    public DownloadMusicFragment() {
        // Required empty public constructor
    }

    Button download_button;
    String url;
    ArrayList<String> urls = new ArrayList<>();


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
            download_button = (Button)root_view.findViewById(R.id.download_songs);

            download_button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    View createDLList_view = getFragmentManager().getFragments().get(0).getView();
                    TextView url_counter = (TextView)createDLList_view.findViewById(R.id.url_counter);


                    for(int i = 0; i < Integer.parseInt(url_counter.getText().toString()); i++)
                    {
                        url = ((EditText)createDLList_view.findViewWithTag("edit_text_input_url" + i)).getHint().toString();
                        if(!urls.contains(url))
                        {
                            urls.add("https://www." + url);
                        }
                    }

                    Log.d("edittext_url", urls.toString());
                }
            });
        }
    }
}
