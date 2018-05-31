package com.example.alejandro.introdatosbd;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class InmuebleAdapter extends RecyclerView.Adapter<InmuebleAdapter.InmuebleViewHolder> {

    List<GetInmueble> lista;

    public InmuebleAdapter(List<GetInmueble> getInmuebles) {

        this.lista = lista;
    }


    @Override
    public InmuebleViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inmebles_get, parent, false);
        return new InmuebleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InmuebleViewHolder holder, int position) {
        holder.bindInmueble(lista.get(position));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class InmuebleViewHolder extends  RecyclerView.ViewHolder{

        TextView tipotxt;
        TextView preciotxt;


        public InmuebleViewHolder(View itemView) {
            super(itemView);
            tipotxt = (TextView)itemView.findViewById(R.id.tipo_txt);
            preciotxt = (TextView)itemView.findViewById(R.id.precio_txt);
        }

        public void bindInmueble(GetInmueble getInmueble){
            String nombre = getInmueble.getTipo() + " " + getInmueble.getCiudad() + "" + getInmueble.getCorreo();
            tipotxt.setText(nombre);
            preciotxt.setText(String.valueOf(getInmueble.getPrecio()));

        }
    }
}
