package com.example.mascotas;

import android.content.Context;
import android.media.tv.TvContentRating;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;

    }


    //Inflar el layout y lo pasara al viewholder para el obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }
    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvPuntosCV.setText(Integer.toString(mascota.getPuntos()));

        mascotaViewHolder.btHuesoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mascota.setPuntos(mascota.getPuntos()+1);
                mascotaViewHolder.tvPuntosCV.setText(Integer.toString(mascota.getPuntos()));
                Log.i("My activity",   mascota.getPuntos() + " HOLA");
            }
        });


    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends  RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvPuntosCV;
        private ImageView btHuesoCV;

        public MascotaViewHolder( View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombre);
            tvPuntosCV = (TextView) itemView.findViewById(R.id.tvPuntos);
            btHuesoCV = (ImageView) itemView.findViewById(R.id.btHueso);
        }
    }
}
