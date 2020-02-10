package com.app.youtubemusicdownloader.fragments;

import android.os.AsyncTask;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
                    String url_list = "{\"encoder\" : \"mp3\", \"url_list\" : [\"https://www.youtube.com/watch?v=ES9vRfs2rbA\", \"https://www.youtube.com/watch?v=85CoKLuxTzY\"]}";

                    try
                    {
                        HttpURLConnection con = initConnection(url_list);
                        response(con);
                    }
                    catch (IOException ieo)
                    {
                        Log.d("IOExceptionMSG", ieo.getMessage());
                    }
                    //Log.d("edittext_url", urls.toString());
                }
            });
        }
    }

    // TODO:    Post request, Json - https://www.androidstation.info/networkonmainthreadexception/

    public HttpURLConnection initConnection(String jsonInputString) throws IOException
    {
        URL url_post = new URL("http://127.0.0.1:1337/download/json");
        HttpURLConnection con = (HttpURLConnection)url_post.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        return con;
    }

    public void response(HttpURLConnection con) throws IOException
    {
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            Log.d("responseString", response.toString());
        }
    }
}
