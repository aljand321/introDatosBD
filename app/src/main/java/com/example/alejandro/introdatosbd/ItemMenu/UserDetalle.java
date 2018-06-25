package com.example.alejandro.introdatosbd.ItemMenu;

public class UserDetalle {

    private String nombre;
    private String email;
    private String numeroTelefono;
    private String ciudad;
    private String direccionActual;

    public UserDetalle(
            String nombre,
            String email,
            String numeroTelefono,
            String ciudad,
            String direccionActual){

        this.nombre = nombre;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.ciudad = ciudad;
        this.direccionActual = direccionActual;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(String direccionActual) {
        this.direccionActual = direccionActual;
    }
}
