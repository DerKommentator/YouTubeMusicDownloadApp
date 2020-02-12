package com.app.youtubemusicdownloader.fragments;

import android.app.DownloadManager;
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
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

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
    final String yt_download_server_url = "http://192.168.178.64:1337/download/json";
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



                    ConnectionBuilder conBuild = new ConnectionBuilder();
                    conBuild.post(yt_download_server_url, url_list, new Callback() {
                        @Override
                        public void onFailure(Request request, IOException e) {
                            Log.d("onFailure", "failed: " + e.getMessage());
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Response response) throws IOException {
                            if (response.isSuccessful()) {
                                String responseStr = response.body().string();
                                Log.d("POSTresp", responseStr);
                                // Do what you want to do with the response.
                            } else {
                                Log.d("POSTresp", "ERROR");
                            }
                        }
                    });
                }
            });
        }
    }

}
