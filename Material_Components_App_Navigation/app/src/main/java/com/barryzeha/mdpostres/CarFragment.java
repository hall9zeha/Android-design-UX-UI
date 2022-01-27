package com.barryzeha.mdpostres;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.barryzeha.mdpostres.databinding.FragmentCarBinding;
import com.google.android.material.transition.MaterialSharedAxis;


public class CarFragment extends Fragment {


    private FragmentCarBinding bind;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
        setEnterTransition(new MaterialSharedAxis(MaterialSharedAxis.X, true));
        setReturnTransition(new MaterialSharedAxis(MaterialSharedAxis.X, false));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bind=FragmentCarBinding.inflate(inflater, container, false);

        //Cargamos el adapter car con los argumentos enviados a través del navigation
        CarAdapter adapter=new CarAdapter(CarFragmentArgs.fromBundle(getArguments()).getProductsArgs());
        bind.recyclerViewCar.setLayoutManager(new LinearLayoutManager(getContext()));
        bind.recyclerViewCar.setAdapter(adapter);
        bind.tvSum.setText(getString(R.string.car_sum, (float)adapter.getItemCount()));

        /*
        * Para navegar con el navHostNavigation controler puede usarse como id de navigate el id del fragmento de destino asi como
        * el id de la acción creada
        * */
        bind.btnBack.setOnClickListener(v->{
            NavHostFragment.findNavController(this)
                    //.navigate(R.id.productFragment); 1ra opción solo el fragmento de destino
            .navigate(R.id.action_car_to_product); // segunda opción id de acción
        });

        bind.btnPay.setOnClickListener(v->{
            NavHostFragment.findNavController(this)
                    //.navigate(R.id.productFragment); 1ra opción solo el fragmento de destino
                    .navigate(R.id.action_car_to_confirmation); // segunda opción id de acción
        });


        return bind.getRoot();
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        menu.clear();
        super.onPrepareOptionsMenu(menu);
    }
}