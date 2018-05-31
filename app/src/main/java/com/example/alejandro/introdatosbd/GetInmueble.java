
//esto es para recuperar datos del servicio
// video del esta explicaion >>>  https://www.youtube.com/watch?v=TPAZ_9E85cs

package com.example.alejandro.introdatosbd;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetInmueble {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("precio")
    @Expose
    private String precio;
    @SerializedName("ciudad")
    @Expose
    private String ciudad;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("cantidadCuartos")
    @Expose
    private String cantidadCuartos;
    @SerializedName("cantidadBa\u00f1os")
    @Expose
    private String cantidadBaOs;
    @SerializedName("garage")
    @Expose
    private String garage;
    @SerializedName("superficie")
    @Expose
    private String superficie;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getCantidadBaOs() {
        return cantidadBaOs;
    }

    public void setCantidadBaOs(String cantidadBaOs) {
        this.cantidadBaOs = cantidadBaOs;
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

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}