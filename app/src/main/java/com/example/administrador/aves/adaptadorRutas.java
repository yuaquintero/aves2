package com.example.administrador.aves;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sennova on 14/06/2017.
 */

public class adaptadorRutas  extends RecyclerView.Adapter<adaptadorRutas.MyViewHolder >implements View.OnClickListener{

    List<Rutas_constructor> Ruta;
    private View.OnClickListener listener;

    public adaptadorRutas(List<Rutas_constructor> ruta) {
        this. Ruta = ruta;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView NombreRuta;
        TextView NumeroRuta;
        ImageView FotoLugar;
        TextView LongitudRuta;


        public MyViewHolder(View view) {
            super(view);
            NombreRuta = (TextView)itemView.findViewById(R.id.nombreruta);
            NumeroRuta = (TextView)itemView.findViewById(R.id.nruta);
            LongitudRuta = (TextView)itemView.findViewById(R.id.longitud);
            //FotoLugar = (ImageView)itemView.findViewById(R.id.iv_tur);

        }
    }


    public adaptadorRutas.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ruta_card, parent, false);
        itemView.setOnClickListener(this);
        adaptadorRutas.MyViewHolder holder =new adaptadorRutas.MyViewHolder(itemView);
        return holder;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {

        if(listener != null)
            listener.onClick(v);

    }

    @Override
    public void onBindViewHolder(adaptadorRutas.MyViewHolder holder, int position) {
        Rutas_constructor r =Ruta.get(position);
        holder.NombreRuta.setText(r.getNombre());
        holder.NumeroRuta.setText(r.getRuta());
        holder.LongitudRuta.setText(r.getLongitud());
    }

    @Override
    public int getItemCount() {
        return Ruta.size();
    }

}
