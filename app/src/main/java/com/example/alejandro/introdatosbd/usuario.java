package com.example.alejandro.introdatosbd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class usuario extends AppCompatActivity {

    private Context regUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        regUser = this;
        loadComponets();
    }

    private void loadComponets() {

        Button btnUser = (Button)this.findViewById(R.id.btn_registrar); //En el id se coloca el boton que se va a usar
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent us = new Intent(regUser, regUsuario.class); //Se señala el class al cual se va a enlazar
                regUser.startActivity(us);
            }
        });
    }
}
