package com.example.alejandro.introdatosbd.ItemMenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alejandro.introdatosbd.R;

import java.util.ArrayList;

public class MenuBaseAdapter extends BaseAdapter implements  OnLoadCompleImg{
    private ArrayList<ItemMenuStructure> list;
    private ArrayList<TextView> counter;
    private Context context;
    public MenuBaseAdapter (Context context, ArrayList<ItemMenuStructure> list) {
        this.list = list;
        this.context = context;
        counter = new ArrayList<TextView>();
    }

    public TextView getCounter(int position) {
        return this.counter.get(position);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.casaitem, null);
        }
        ///<<<
        TextView tipo = convertView.findViewById(R.id.getTxtTipo);
        TextView estado = convertView.findViewById( R.id.getTxtEstado);
        TextView precio = convertView.findViewById( R.id.getTxtPrecio);
        ImageView img = convertView.findViewById( R.id.Img_casa );
        tipo.setText( this.list.get(position).getTipo());
        estado.setText( this.list.get(position).getEstado());
        precio.setText( this.list.get(position).getPrecio()+"");
        counter.add(precio);
        ///<<<<
        if (this.list.get(position).getImg() == null) {
            //Load IMG
            LoaderImg loader = new LoaderImg();
            loader.setOnloadCompleteImg(img , position,this);
            loader.execute(this.list.get(position).getUrl());
        } else {
            img.setImageBitmap(this.list.get(position).getImg());
        }

        return convertView;
    }

    @Override
    public void OnloadCompleteImgResult(ImageView img, int position, Bitmap imgsourceimg) {
        this.list.get(position).setImg(imgsourceimg);
        img.setImageBitmap(imgsourceimg);
    }
}
