package com.example.alejandro.introdatosbd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alejandro.introdatosbd.ItemMenu.UserDetalle;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class User extends AppCompatActivity {

    private String userUrl; // este es el url

    protected TextView NameUser, AddressUser, NumberUser, emailnombre, ciudadNombre;
    protected ImageView imageView2;

    protected UserDetalle Data;

    protected  User ROOT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ROOT = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userUrl= this.getIntent().getExtras().getString("user");
        loadViewComponents();
        loadAsinkData();
    }

    private void loadAsinkData() {
        AsyncHttpClient userDeatalle= new AsyncHttpClient();
        userDeatalle.get("http://192.168.43.150:7777/api/v1.0/user/"+userUrl,
                new JsonHttpResponseHandler(){
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {
                            String nombre = response.getString("nombre");
                            String email = response.getString("email");
                            String numeroTelefono = response.getString("numeroTelefono");
                            String ciudad = response.getString("ciudad");
                            String direccionActual = response.getString("direccionActual");
                            Data = new UserDetalle(nombre,email,numeroTelefono,ciudad,direccionActual);
                            ROOT.informacion();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void informacion() {

        this.NameUser.setText(Data.getNombre());
        this.AddressUser.setText(Data.getDireccionActual());
        this.NumberUser.setText(Data.getNumeroTelefono());
        this.emailnombre.setText(Data.getEmail());
        this.ciudadNombre.setText(Data.getCiudad());
    }

    private void loadViewComponents() {

        this.NameUser = (TextView) this.findViewById(R.id.NameUser);
        this.AddressUser = (TextView) this.findViewById(R.id.AddressUser);
        this.NumberUser = (TextView) this.findViewById(R.id.NumberUser);
        this.emailnombre = (TextView) this.findViewById(R.id.emailnombre);
        this.ciudadNombre = (TextView) this.findViewById(R.id.ciudadNombre);

        this.imageView2 = (ImageView) this.findViewById(R.id.imageView2);
    }
}
