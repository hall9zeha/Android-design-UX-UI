package com.barryzeha.mdpostres;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.barryzeha.mdpostres.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding bind;
    private NavController navController;
    private BottomSheetBehavior bottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        setSupportActionBar(bind.toolbar);
        navController= Navigation.findNavController(this, R.id.nav_host_fragment);

        AppBarConfiguration appBarConfiguration= new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(bind.toolbar, navController, appBarConfiguration);
        //para quitar el ícono de back del toolbar por medio de navigation hacemos lo siguiente

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            //mantenemos el título del toolbar
            bind.toolbar.setTitle(destination.getLabel());
            //quitamos el bobon de regresar
            bind.toolbar.setNavigationIcon(null);
        });
        bottomSheetBehavior=BottomSheetBehavior.from(bind.bottomSheet.bottomSheet);
        bottomSheetBehavior.setState(bottomSheetBehavior.STATE_HIDDEN);
        bind.bottomSheet.ivClose.setOnClickListener(v-> bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN));
        bind.bottomSheet.btnExit.setOnClickListener(v-> finish());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      /*  if(item.getItemId()==R.id.itemConfirmation){
            navController.navigate(R.id.action_global_confirmation);
        }
        return super.onOptionsItemSelected(item);*/
        //Ahora haremos navegación por id
        return NavigationUI.onNavDestinationSelected(item, navController)||
                super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }
}