package com.barryzeha.materialdesignAndComponent.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barryzeha.materialdesignAndComponent.databinding.ItemComponentBinding;
import com.barryzeha.materialdesignAndComponent.utils.Component;
import com.barryzeha.materialdesignAndComponent.utils.OnClickListener;

import java.util.ArrayList;

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
            bind.ivComponent.setBackgroundResource(component.getPhotoRes());
            bind.ivComponent.setScaleType(ImageView.ScaleType.CENTER);
            bind.tvName.setText(component.getName());

        }
    }
}
