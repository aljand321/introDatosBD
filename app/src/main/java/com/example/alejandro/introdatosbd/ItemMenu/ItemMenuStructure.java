package com.example.alejandro.introdatosbd.ItemMenu;

import android.graphics.Bitmap;

public class ItemMenuStructure {

    private String tipo;
    private String estado;
    private String precio;
    private String ciudad;
    private String cantidadCuartos;
    private String cantidadBaños;
    private String correo;

    public  ItemMenuStructure (String tipo, String estado, String precio, String ciudad,
                                String cantidadCuartos, String  cantidadBaños, String correo){

        this.tipo = tipo;
        this.estado = estado;
        this.precio = precio;
        this.ciudad = ciudad;
        this.cantidadCuartos = cantidadCuartos;
        this.cantidadBaños = cantidadBaños;
        this.correo = correo;

    }

    public String getTipo(){
        return this.tipo;
    }

    public String getEstado(){
        return this.estado;
    }

    public String getPrecio(){
        return this.precio;
    }

    public String getCiudad(){
        return this.ciudad;
    }

    public String getCantidadCuartos(){
        return this.cantidadCuartos;
    }

    public String getCantidadBaos(){
        return this.cantidadBaños;
    }

    public String getCorreo(){
        return this.correo;
    }



}
