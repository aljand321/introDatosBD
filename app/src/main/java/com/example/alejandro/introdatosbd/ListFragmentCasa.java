package com.example.alejandro.introdatosbd;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DataApp.LISTDATA = new ArrayList<ItemMenuStructure>();
        ROOT = inflater.inflate(R.layout.activity_list_fragment_casa, container, false);
        loadData();
        return ROOT;
    }
    public void setOnloadCompleteData (OnLoadDataComplete event) {
        this.event = event;
    }
    private void loadData() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.10.1.150:7777/api/v1.0/inmuebles_ecp", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray listData = response.getJSONArray("docs");
                    for (int i = 0; i < listData.length(); i++) {
                        JSONObject obj = listData.getJSONObject(i);
                        String tipo = obj.getString("tipo");
                        String estado = obj.getString("estado");
                        String precio = obj.getString("precio");
                        String ciudad = obj.getString("ciudad");
                        String cantidadCuartos = obj.getString("cantidadCuartos");
                        String cantidadBaños = obj.getString("cantidadBaños");
                        String correo = obj.getString("correo");
                        String id = obj.getString("_id");
                        String url = (String)obj.getJSONArray("gallery").get(0);
                        DataApp.LISTDATA.add(new ItemMenuStructure(tipo,estado, precio, ciudad , "","","",cantidadCuartos,
                                cantidadBaños,"","",correo,"",id,url));

                        /* JSONObject obj = listData.getJSONObject(i);
                        String street = obj.getString("street");
                        Integer price = obj.getInt("price");
                        double lat = obj.getDouble("lat");
                        double lon = obj.getDouble("lon");
                        String contact = obj.getString("contact");
                        String id = obj.getString("_id");
                        String url = (String)obj.getJSONArray("gallery").get(0);
                        DataApp.LISTDATA.add(new ItemMenuStructure(street, url, price, lat, lon, contact,
                                "", "", id,""));*/
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
