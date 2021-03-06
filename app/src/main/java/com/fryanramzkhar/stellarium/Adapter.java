package com.fryanramzkhar.stellarium;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    int[] gambarPlanet;
    String[] namaPlanet, detailPlanet;

    public Adapter(Context context, int[] gambarPlanet, String[] namaPlanet, String[] detailPlanet) {
        this.context = context;
        this.gambarPlanet = gambarPlanet;
        this.namaPlanet = namaPlanet;
        this.detailPlanet = detailPlanet;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_planet,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtPlanet.setText(namaPlanet[i]);
        Glide.with(context).load(gambarPlanet[i]).into(viewHolder.imgPlanet);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context,DetailPlanet.class);
                pindah.putExtra("np",namaPlanet[i]);
                pindah.putExtra("dp",detailPlanet[i]);
                pindah.putExtra("gp",gambarPlanet[i]);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarPlanet.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlanet;
        TextView txtPlanet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlanet = itemView.findViewById(R.id.imgList);
            txtPlanet = itemView.findViewById(R.id.txtListTitle);
        }
    }
}
