package com.barryzeha.mdpostres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barryzeha.mdpostres.databinding.ItemProductBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ProductAdapter  extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private List<Product> products;
    private onClickProduct listener;
    private Context context;

    public ProductAdapter(List<Product> products, onClickProduct listener) {
        this.products = products;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
       ItemProductBinding bind= ItemProductBinding.inflate(LayoutInflater.from(context),parent, false);
       return new ViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product= products.get(position);
        holder.setListener(product,listener);
        holder.bind.tvNameProduct.setText(product.getName());
        Glide.with(context)
                .load(product.getUrl())
                .apply(new RequestOptions().centerCrop())
                .into(holder.bind.ivProduct);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        protected ItemProductBinding bind;

        public ViewHolder(@NonNull ItemProductBinding itemView) {
            super(itemView.getRoot());
            bind=itemView;


        }
        protected void setListener(Product product, onClickProduct listener){
            itemView.setOnClickListener(view->{
                product.setSelected(!product.isSelected());

                bind.getRoot().setChecked(product.isSelected());

                listener.onclick(product);
            });
        }
    }
}
