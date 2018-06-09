package com.example.alejandro.introdatosbd.ItemMenu;

import android.graphics.Bitmap;

public class ItemMenuStructure {
    private String url;
    private Bitmap img;
    private String title;
    private String year;
    private String type;
    private String idimdb;
    public  ItemMenuStructure (String urlimg, String title, String year, String type, String idimdb){
        this.url = urlimg;
        this.title = title;
        this.year = year;
        this.type = type;
        this.idimdb = idimdb;
    }

    public String getUrlimg() {
        return this.url;
    }

    public Bitmap getImg() {
        return this.img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getTitle() {
        return this.title;
    }

    public String getYear() {
        return this.year;
    }

    public String getType() {
        return this.type;
    }

    public  String getIdimdb(){
        return this.idimdb;
    }
}
