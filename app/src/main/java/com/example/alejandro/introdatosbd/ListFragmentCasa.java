package com.example.alejandro.introdatosbd;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.alejandro.introdatosbd.DATA.DataApp;
import com.example.alejandro.introdatosbd.ItemMenu.ItemMenuStructure;
import com.example.alejandro.introdatosbd.ItemMenu.MenuBaseAdapter;
import com.example.alejandro.introdatosbd.Utils.OnLoadDataComplete;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ListFragmentCasa extends Fragment {
    private View ROOT;
    private OnLoadDataComplete event;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        DataApp.LISTDATA = new ArrayList<ItemMenuStructure>(  );
        ROOT = inflater.inflate(R.layout.activity_list_fragment_casa, container, false);
        loadData();
        return ROOT;
    }

    public void setOnloadCompleteData (OnLoadDataComplete event) {
        this.event = event;
    }
    private void loadData() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://www.omdbapi.com/?s=/coco/&page=1&apikey=e1c80c83", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray listData = response.getJSONArray("info");
                    for (int i = 0; i < listData.length(); i++) {
                        JSONObject obj = listData.getJSONObject(i);
                        String titulo = obj.getString( "Title" );
                        String year = obj.getString( "Year" );
                        String imdbID = obj.getString( "imdbID" );
                        String type = obj.getString( "Type" );
                        String Poster = obj.getString( "Poster" );
                        DataApp.LISTDATA.add(new ItemMenuStructure(titulo, year, imdbID, type, Poster ));
                    }
                    LoadComponents();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void LoadComponents () {

        ListView list = (ListView) ROOT.findViewById(R.id.super_lista);
        MenuBaseAdapter adapter = new MenuBaseAdapter(this.getActivity(), DataApp.LISTDATA);
        list.setAdapter(adapter);
        this.event.OnLodCompleteDataResult();
    }
}
