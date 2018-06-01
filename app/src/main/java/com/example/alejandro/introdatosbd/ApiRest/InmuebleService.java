package com.example.alejandro.introdatosbd.ApiRest;

import com.example.alejandro.introdatosbd.models.InmuebleRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InmuebleService {

    @GET("pokemon")

    Call<InmuebleRespuesta> obtenerListaInmueble();
}
