package com.app.youtubemusicdownloader.fragments;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
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
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import okio.BufferedSink;
import okio.Okio;


public class DownloadMusicFragment extends Fragment{

    public DownloadMusicFragment() {
        // Required empty public constructor
    }

    Button download_button;
    final String yt_download_server_url = "http://10.0.2.2:1337/download/json";
    final String download_songs = "http://10.0.2.2:1337/download/json_requested_songs?file=json_requested_songs";
    final String android_filename = "songs.zip";
    final String android_path = "/storage/emulated/0/Music";
    String url;
    ArrayList<String> url_list = new ArrayList<>();


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
                        if(!url_list.contains("https://www." + url))
                        {
                            url_list.add("https://www." + url);
                        }
                    }
                    // https://www.youtube.com/watch?v=ERlBHyOjeLI
                    // https://www.youtube.com/watch?v=7zDkniNTeZg

                    //String url_list = "{\"encoder\" : \"mp3\", \"url_list\" : [\"https://www.youtube.com/watch?v=ES9vRfs2rbA\", \"https://www.youtube.com/watch?v=85CoKLuxTzY\"]}";

                    String json_input = "{\"encoder\" : \"mp3\", \"url_list\" : \"" + url_list + "\"}";
                    Log.d("jsonInput", json_input);
                    Log.d("jsonInput", url_list.toString());

                    ConnectionBuilder conBuild = new ConnectionBuilder();
                    conBuild.post(yt_download_server_url, json_input, new Callback()
                    {
                        @Override
                        public void onFailure(Request request, IOException e) {
                            Log.d("onFailure", "failed: " + e.getMessage());
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Response response) throws IOException {
                            if (response.isSuccessful()) {
                                try {
                                    HttpDownloadUtility.downloadFile(download_songs, android_path);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }
            });
        }
    }

}
