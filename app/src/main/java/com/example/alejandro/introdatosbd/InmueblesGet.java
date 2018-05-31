package com.example.alejandro.introdatosbd;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//esto es el servicio del inmueble

public interface InmueblesGet {

    @GET("api/v1.0/inmuebles")
    Call<List<GetInmueble>> getCasas();
}
