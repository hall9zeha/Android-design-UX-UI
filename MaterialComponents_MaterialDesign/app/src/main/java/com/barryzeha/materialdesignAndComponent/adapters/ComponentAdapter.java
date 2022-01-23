package com.barryzeha.materialdesignAndComponent.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barryzeha.materialdesignAndComponent.R;
import com.barryzeha.materialdesignAndComponent.databinding.ItemComponentBinding;
import com.barryzeha.materialdesignAndComponent.utils.Component;
import com.barryzeha.materialdesignAndComponent.utils.OnClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Collections;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ViewHolder>{
    private ArrayList<Component> components= new ArrayList();
    private OnClickListener mListener;

    private ItemComponentBinding bind;

    public ComponentAdapter(ArrayList<Component> components, OnClickListener mListener) {
        this.components = components;
        this.mListener = mListener;
    }

    public void add(Component component){
        if(!components.contains(component)){
            components.add(component);
            notifyItemInserted(components.size() - 1 );
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        bind=ItemComponentBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);

        return new ViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(mListener, components.get(position));
    }

    @Override
    public int getItemCount() {
        return  (int) components.size()>0 ? components.size() : 0;
    }

    public void reverse() {
        Collections.reverse(components);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ItemComponentBinding bind;
        public ViewHolder(@NonNull ItemComponentBinding itemView) {
            super(itemView.getRoot());
            this.bind=itemView;

        }
        void onBind(OnClickListener listener, Component component){
            bind.getRoot().setOnClickListener(v->{
                listener.onClick(component);
            });
            RequestOptions options= RequestOptions
                    .diskCacheStrategyOf(DiskCacheStrategy.ALL)
                    .centerCrop();
            Glide.with(bind.getRoot().getContext())
                    .load(component.getPhotoRes())
                    .apply(options)
                    .into(bind.ivComponent);
           // bind.ivComponent.setImageResource(component.getPhotoRes());

            bind.tvName.setText(component.getName());

        }
    }
}
