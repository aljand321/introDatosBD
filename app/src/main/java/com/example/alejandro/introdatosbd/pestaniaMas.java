package com.example.alejandro.introdatosbd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.xml.transform.sax.TemplatesHandler;

public class pestaniaMas extends AppCompatActivity {

    private Context inSesion;

    //private Button USER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pestania_mas);

        inSesion = this;
        loadComponents();

        /*USER = (Button) this.findViewById(R.id.btn_InicioSecion);
        USER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(pestaniaMas.this,usuario.class);
                pestaniaMas.this.startActivity(log);

            }
        });*/


    }

   private void loadComponents() {
        Button btnUser = (Button)this.findViewById(R.id.btn_InicioSecion); //En el id se coloca el boton que se va a usar
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent us = new Intent(inSesion, usuario.class); //Se señala el class al cual se va a enlazar
                inSesion.startActivity(us);
            }
        });
    }
}
