package com.barryzeha.mdpostres;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barryzeha.mdpostres.databinding.ItemCarBinding;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    private String[] products;

    public CarAdapter(String[] products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCarBinding bind=ItemCarBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(products[position]);
    }

    @Override
    public int getItemCount() {
        return products.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemCarBinding bind;
        public ViewHolder(@NonNull ItemCarBinding itemView) {
            super(itemView.getRoot());
            bind=itemView;
        }
        protected void bind(String product){
            bind.tvName.setText(product);
        }
    }
}
