package com.example.hp.interfacegrafic.ItemMenu;

public class CasaIdDeatalle {

    private String tipo;
    private String esatado;
    private String precio;
    private String region ;
    private String descripcion ;
    private String cantidadCuartos ;
    private String superficie;
    private String user;

    public CasaIdDeatalle (String tipo,
                           String estado,
                           String precio,
                           String region,
                           String descripcion,
                           String cantidadCuartos,
                           String superficie,
                           String user){

        this.tipo = tipo;
        this.esatado = estado;
        this.precio = precio;
        this.region = region;
        this.descripcion = descripcion;
        this.cantidadCuartos = cantidadCuartos;
        this.superficie = superficie;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEsatado() {
        return esatado;
    }

    public void setEsatado(String esatado) {
        this.esatado = esatado;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }
}
