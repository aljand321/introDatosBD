package com.example.alejandro.introdatosbd.ItemMenu;

import android.graphics.Bitmap;

public class ItemMenuStructure {

    private String tipo;
    private String estado;
    private String precio;
    private String ciudad;
    private String region;
    private String direccion;
    private String ubicacion;
    private String descripcion;
    private String cantidadCuartos;
    private String cantidadBaños;
    private String garage;
    private String superficie;
    private String correo;
    private String user;
    private String url;
    private Bitmap img;
    private String id;

    public ItemMenuStructure (String tipo, String esatado, String precio, String  ciudad, String region,
                              String direccion, String ubicacion, String descripcion, String cantidadCuartos,
                              String cantidadBaños, String garage, String superficie, String correo, String user,
                              String urlimg, String id ) {
        this.tipo = tipo;
        this.estado = esatado;
        this.precio = precio;
        this.ciudad = ciudad;
        this.region = region;
        this.direccion = direccion;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.cantidadCuartos = cantidadCuartos;
        this.cantidadBaños = cantidadBaños;
        this.garage = garage;
        this.superficie = superficie;
        this.correo = correo;
        this.user = user;
        this.url = urlimg;
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidadCuartos() {
        return cantidadCuartos;
    }

    public void setCantidadCuartos(String cantidadCuartos) {
        this.cantidadCuartos = cantidadCuartos;
    }

    public String getCantidadBaños() {
        return cantidadBaños;
    }

    public void setCantidadBaños(String cantidadBaños) {
        this.cantidadBaños = cantidadBaños;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
