package com.alain.cursos.top;

/* *
 * Project: MD Top from com.alain.cursos.top
 * Created by Alain Nicolás Tello on 10/11/2019 at 06:16 PM
 * All rights reserved 2019.
 * Course Material Design and Theming Professional for Android
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * Cursos Android ANT
 */

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.alain.cursos.top.databinding.ItemArtistBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.HashMap;
import java.util.List;



public class ArtistaAdapter extends RecyclerView.Adapter<ArtistaAdapter.ViewHolder> {

    private List<Artista> artistas;
    private Context context;
    private OnItemClickListener listener;

    ArtistaAdapter(List<Artista> artistas, OnItemClickListener listener) {
        this.artistas = artistas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemArtistBinding bind=ItemArtistBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        this.context = parent.getContext();
        return new ViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Artista artista = artistas.get(position);

        //holder.setListener(artista, listener);
        holder.views.put(holder.bind.imgFoto.getTransitionName(),holder.bind.imgFoto);
        holder.views.put(holder.bind.tvNote.getTransitionName(),holder.bind.tvNote);
        holder.views.put(holder.bind.tvNombre.getTransitionName(),holder.bind.tvNombre);
        holder.views.put(holder.bind.tvOrden.getTransitionName(),holder.bind.tvOrden);

        holder.setListener(artista,holder.views, listener);

        holder.bind.tvNombre.setText(artista.getNombreCompleto());
        holder.bind.tvNote.setText(artista.getNotas());
        holder.bind.tvOrden.setText(String.valueOf(position+1));

        if (artista.getFotoUrl() != null){
            RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_sentiment_satisfied);

            Glide.with(context)
                    .load(artista.getFotoUrl())
                    .apply(options)
                    .into(holder.bind.imgFoto);
        } else {
            holder.bind.imgFoto.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_account_box));
        }
    }

    @Override
    public int getItemCount() {
        return this.artistas.size();
    }

    void setList(List<Artista> list) {
        this.artistas = list;
        notifyDataSetChanged();
    }

    void remove(Artista artista) {
        if (artistas.contains(artista)){
            artistas.remove(artista);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemArtistBinding bind;
        private HashMap<String, View> views;
        ViewHolder(ItemArtistBinding itemView) {
            super(itemView.getRoot());
            this.bind=itemView;
            views= new HashMap<>();
        }

        void setListener(final Artista artista,  HashMap<String, View> views, final OnItemClickListener listener){
            bind.containerMain.setOnClickListener(view -> listener.onItemClick(artista,  views));

            bind.containerMain.setOnLongClickListener(view -> {
                listener.onLongItemClick(artista);
                return true;
            });
        }
    }
}
