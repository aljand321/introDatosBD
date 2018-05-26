package com.example.alejandro.introdatosbd;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {

    EditText nombre, apellido, email, numeroTelefono, ciudad, direccionActual, password;
    Button guardar;
    HttpClient cliente;
    HttpPost post;
    List<NameValuePair> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        nombre = (EditText) findViewById(R.id.txt_nombre);
        apellido = (EditText)findViewById(R.id.txt_apellido);
        email = (EditText)findViewById(R.id.txt_email);
        numeroTelefono = (EditText)findViewById(R.id.txt_telf);
        ciudad = (EditText)findViewById(R.id.txt_ciudad);
        direccionActual = (EditText)findViewById(R.id.txt_direccion);
        password = (EditText)findViewById(R.id.txt_password);
        guardar = (Button)findViewById(R.id.btn_guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Nombre no puede ser vacio", Toast.LENGTH_LONG).show();
                }else {
                    new EnviarDatos(MainActivity.this).execute();
                }
            }
        });
    }

    class EnviarDatos extends AsyncTask<String, String, String >{


        private Activity contexto;
        EnviarDatos(Activity context){
            this.contexto = context;
        }
        @Override
        protected String doInBackground(String... strings) {

            if(datos ()){
            contexto.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(contexto, "Datos enviados Existosamente", Toast.LENGTH_SHORT).show();
                    nombre.setText("");
                    apellido.setText("");
                    email.setText("");
                    numeroTelefono.setText("");
                    ciudad.setText("");
                    direccionActual.setText("");
                    password.setText("");
                }
                });


            }
            else{
                contexto.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(contexto, "Datos no enviados", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            return null;
        }
    }

    private boolean datos (){
        cliente = new DefaultHttpClient();
        post = new HttpPost("http://10.10.1.150:7777/api/v1.0/user");
        lista = new ArrayList<NameValuePair>(7);
        lista.add(new BasicNameValuePair("nombre", nombre.getText().toString().trim()));
        lista.add(new BasicNameValuePair("apellido",apellido.getText().toString().trim()));
        lista.add(new BasicNameValuePair("email",email.getText().toString().trim()));
        lista.add(new BasicNameValuePair("numeroTelefono",numeroTelefono.getText().toString().trim()));
        lista.add(new BasicNameValuePair("ciudad",ciudad.getText().toString().trim()));
        lista.add(new BasicNameValuePair("direccionActual",direccionActual.getText().toString().trim()));
        lista.add(new BasicNameValuePair("password",password.getText().toString().trim()));
        try{
            post.setEntity(new UrlEncodedFormEntity(lista));
            cliente.execute(post);
            return true;

        }catch (UnsupportedEncodingException e){

            e.printStackTrace();

        }catch (ClientProtocolException e){

            e.printStackTrace();

        }catch (IOException e){

            e.printStackTrace();
        }

        return false;
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
