package com.example.alejandro.introdatosbd;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alejandro.introdatosbd.models.Inmuebles;

import java.util.ArrayList;

public class ListaInmueblesAdapter  extends RecyclerView.Adapter<ListaInmueblesAdapter.ViewHolder>{

    private ArrayList<Inmuebles> dataset;

    public ListaInmueblesAdapter(){
        dataset = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inmueble, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Inmuebles p = dataset.get(position);
        holder.nombretxt.setText(p.getName());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaInmueble(ArrayList<Inmuebles> listaInmueble) {
        dataset.addAll(listaInmueble);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoImageView;
        private TextView nombretxt;

        public ViewHolder(View itemView){
            super (itemView);

            fotoImageView = (ImageView)itemView.findViewById(R.id.fotoimageview);
            nombretxt = (TextView) itemView.findViewById(R.id.nombre_txt);
        }
    }
}
