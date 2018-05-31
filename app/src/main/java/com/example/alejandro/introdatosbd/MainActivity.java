package com.example.alejandro.introdatosbd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Context PestMas;

    //>>> esto es del video getInmuebles

    private  final String baseUrl = "http://10.10.1.150:7777/";
    RecyclerView rvInmuebles;
    FloatingActionButton fabAdd;
    List<GetInmueble> getInmuebles = new ArrayList<>();

    InmuebleAdapter adapter;
    //>>>>>>>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarControles();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

       //>>> esto es partede getImuebles
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

        LinearLayoutManager inm = new LinearLayoutManager(getApplicationContext());
        rvInmuebles.setLayoutManager(inm);

        adapter = new InmuebleAdapter(getInmuebles);
        rvInmuebles.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(rvInmuebles.getContext(),inm.getOrientation());
        rvInmuebles.addItemDecoration(itemDecoration);



        InmueblesGet inmueblesGet = retrofit.create(InmueblesGet.class);

        Call<List<GetInmueble>> lista = inmueblesGet.getCasas();
        lista.enqueue(new Callback<List<GetInmueble>>() {
            @Override
            public void onResponse(Call<List<GetInmueble>> call, Response<List<GetInmueble>> response) {
                if(response.isSuccessful()){
                    getInmuebles = response.body();
                    adapter = new InmuebleAdapter(getInmuebles);
                    rvInmuebles.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<List<GetInmueble>> call, Throwable t) {

            }
        });

        //>>>


        PestMas = this;
        LoadComponets();

        //esto es de get Inmuebles

    }

    private void iniciarControles() {
        
    }

    private void LoadComponets() {
        Button btnMAs = (Button)this.findViewById(R.id.btn_mas);
        btnMAs.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent ubic = new Intent(PestMas, pestaniaMas.class);
                PestMas.startActivity(ubic);
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
