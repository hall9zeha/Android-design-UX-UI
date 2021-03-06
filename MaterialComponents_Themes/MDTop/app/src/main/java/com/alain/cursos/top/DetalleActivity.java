package com.alain.cursos.top;

/* *
 * Project: MD Top from com.alain.cursos.top
 * Created by Alain Nicolás Tello on 10/11/2019 at 06:21 PM
 * All rights reserved 2019.
 * Course Material Design and Theming Professional for Android
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * Cursos Android ANT
 */

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import com.alain.cursos.top.databinding.ActivityDetalleBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



public class DetalleActivity extends AppCompatActivity implements  View.OnClickListener {

    private static final int RC_PHOTO_PICKER = 21;

    private Artista mArtista;
    private Calendar mCalendar;
    private MenuItem mMenuItem;
    private boolean mIsEdit;
    private ActivityDetalleBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind=ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());


        configArtista(getIntent());
        configActionBar();
        configImageView(mArtista.getFotoUrl());
        configCalendar();

        bind.fab.setOnClickListener(v->saveOrEdit());
        bind.content.etFechaNacimiento.setOnClickListener(v->onSetFecha());
        bind.imgDeleteFoto.setOnClickListener(this);
        bind.imgFromGallery.setOnClickListener(this);
        bind.imgFromUrl.setOnClickListener(this);

    }

    private void configArtista(Intent intent) {
        getArtist(intent.getLongExtra(Artista.ID, 0));

        bind.content.etNombre.setText(mArtista.getNombre());
        bind.content.etApellidos.setText(mArtista.getApellidos());
        bind.content.etFechaNacimiento.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT)
                .format(mArtista.getFechaNacimiento()));
        bind.content.etEdad.setText(getEdad(mArtista.getFechaNacimiento()));
        bind.content.etEstatura.setText(String.valueOf(mArtista.getEstatura()));
        bind.content.etOrden.setText(String.valueOf(mArtista.getOrden()));
        bind.content.etLugarNacimiento.setText(mArtista.getLugarNacimiento());
        bind.content.etNotas.setText(mArtista.getNotas());
    }

    private void getArtist(long id) {
        mArtista = SQLite
                .select()
                .from(Artista.class)
                .where(Artista_Table.id.is(id))
                .querySingle();
    }

    private String getEdad(long fechaNacimiento) {
        long time = Calendar.getInstance().getTimeInMillis() / 1000 - fechaNacimiento / 1000;
        final int years = Math.round(time) / 31536000;
        return String.valueOf(years);
    }

    private void configActionBar() {
        setSupportActionBar(bind.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        bind.toolbarLayout.setExpandedTitleColor(Color.WHITE);
        bind.appBar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
        /*    if(Math.abs(verticalOffset)==appBarLayout.getTotalScrollRange()){
                bind.toolbar.getNavigationIcon().setTint(Color.BLACK);
            }
            else{
                bind.toolbar.getNavigationIcon().setTint(Color.WHITE);
            }*/
            if(AppCompatDelegate.getDefaultNightMode() !=AppCompatDelegate.MODE_NIGHT_YES) {
                //probaremos cambiar el color progresivamente del ícono del toolbar al colapsar
                //le ponemos negativo restando uno para que salga al revés ya que primero era 0 y colapsado era 1
                //O sea cuando sea colapsado totalmente sea 0 y totalmente negro y expandido 1 y blanco
                float percentage = Math.abs((float) Math.abs(verticalOffset) / appBarLayout.getTotalScrollRange() - 1);
                int colorRgbValue = (int) (percentage * 255);
                bind.toolbar.getNavigationIcon().setTint(Color.rgb(colorRgbValue, colorRgbValue, colorRgbValue));
            }


        });
        RequestOptions options= RequestOptions
                .diskCacheStrategyOf(DiskCacheStrategy.NONE)
                .centerCrop();
        Glide.with(this)
                .load(R.drawable.img_cover_material_design)
                .apply(options)
                .into(bind.imgCover);
        configTitle();
    }

    private void configTitle() {
        bind.toolbarLayout.setTitle(mArtista.getNombreCompleto());
        bind.tvTitleName.setText(mArtista.getNombreCompleto());
    }

    private void configImageView(String fotoUrl) {
        if (fotoUrl != null) {
            RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();

            Glide.with(this)
                    .load(fotoUrl)
                    .apply(options)
                    .into(bind.imgFoto);



        } else {
            bind.imgFoto.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_photo_size_select_actual));

        }

        mArtista.setFotoUrl(fotoUrl);
    }

    private void configCalendar() {
        mCalendar = Calendar.getInstance(Locale.ROOT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        mMenuItem = menu.findItem(R.id.action_save);
        mMenuItem.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                //Aqui usaremos este método para permitir que las animaciones se muestren al cerrar la actividad
                finishAfterTransition();
                //finish();
                break;
            case R.id.action_save:
                saveOrEdit();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == RC_PHOTO_PICKER) {
                savePhotoUrlArtist(data.getDataString());
            }
        }
    }

    private void savePhotoUrlArtist(String fotoUrl) {
        try {
            mArtista.setFotoUrl(fotoUrl);
            mArtista.update();
            configImageView(fotoUrl);
            showMessage(R.string.detalle_message_update_success);
        } catch (Exception e) {
            e.printStackTrace();
            showMessage(R.string.detalle_message_update_fail);
        }
    }


    public void saveOrEdit() {
        if (mIsEdit) {
            if (validateFields() && bind.content.etNombre.getText() != null && bind.content.etApellidos.getText() != null &&
                    bind.content.etEstatura.getText() != null && bind.content.etLugarNacimiento.getText() != null &&
                    bind.content.etNotas.getText() != null) {
                mArtista.setNombre(bind.content.etNombre.getText().toString().trim());
                mArtista.setApellidos(bind.content.etApellidos.getText().toString().trim());
                mArtista.setEstatura(Short.valueOf(bind.content.etEstatura.getText().toString().trim()));
                mArtista.setLugarNacimiento(bind.content.etLugarNacimiento.getText().toString().trim());
                mArtista.setNotas(bind.content.etNotas.getText().toString().trim());

                try {
                    mArtista.update();
                    configTitle();
                    showMessage(R.string.detalle_message_update_success);
                    Log.i("DBFlow", "Inserción correcta de datos.");
                    bind.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_account_edit));
                    enableUIElements(false);
                    mIsEdit = false;

                } catch (Exception e) {
                    e.printStackTrace();
                    showMessage(R.string.detalle_message_update_fail);
                    Log.i("DBFlow", "Error al insertar datos.");
                }
            }


        } else {
            mIsEdit = true;
            bind.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_account_check));
            enableUIElements(true);
        }
    }

    private boolean validateFields() {
        boolean isValid = true;

        if (bind.content.etEstatura.getText() != null && (bind.content.etEstatura.getText().toString().trim().isEmpty() ||
                Integer.valueOf(bind.content.etEstatura.getText().toString().trim()) < getResources().getInteger(R.integer.estatura_min)) ) {
            bind.content.tilHeight.setError(getString(R.string.addArtist_error_estaturaMin));
            bind.content.tilHeight.requestFocus();
            isValid = false;
        }
        else{
            bind.content.tilHeight.setError(null);

        }
        if (bind.content.etApellidos.getText() != null && bind.content.etApellidos.getText().toString().trim().isEmpty()) {
            bind.content.tilLastNames.setError(getString(R.string.addArtist_error_required));
            bind.content.tilLastNames.requestFocus();
            isValid = false;
        }
        else{
            bind.content.tilLastNames.setError(null);
        }
        if (bind.content.etNombre.getText() != null && bind.content.etNombre.getText().toString().trim().isEmpty()) {
            bind.content.tilName.setError(getString(R.string.addArtist_error_required));
            bind.content.tilName.requestFocus();
            isValid = false;
        }
        else{
            bind.content.tilName.setError(null);
        }
        return isValid;
    }

    private void enableUIElements(boolean enable) {
        bind.content.etNombre.setEnabled(enable);
        bind.content.etApellidos.setEnabled(enable);
        bind.content.etFechaNacimiento.setEnabled(enable);
        bind.content.etEstatura.setEnabled(enable);
        bind.content.etLugarNacimiento.setEnabled(enable);
        bind.content.etNotas.setEnabled(enable);
        bind.content.tilName.clearFocus();
        bind.content.tilHeight.clearFocus();
        bind.content.tilLastNames.clearFocus();
        mMenuItem.setVisible(enable);
        bind.appBar.setExpanded(!enable);
        bind.content.containerMain.setNestedScrollingEnabled(!enable);
    }
/*
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, day);

        bind.content.etFechaNacimiento.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT).format(
                mCalendar.getTimeInMillis()));
        mArtista.setFechaNacimiento(mCalendar.getTimeInMillis());
        bind.content.etEdad.setText(getEdad(mCalendar.getTimeInMillis()));
    }*/


    public void onSetFecha() {

        MaterialDatePicker.Builder<Long> builder=MaterialDatePicker.Builder.datePicker();
        builder.setTheme(R.style.pickerDialogCut);
        builder.setSelection(mArtista.getFechaNacimiento());
        MaterialDatePicker<?> picker=builder.build();
        picker.addOnPositiveButtonClickListener(selection->{
            bind.content.etFechaNacimiento.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT).format(
                    selection));
            mArtista.setFechaNacimiento((long)selection);
            bind.content.etEdad.setText(getEdad((long)selection));
        });
        picker.show(getSupportFragmentManager(), picker.toString());

/*        DialogSelectorFecha selectorFecha = new DialogSelectorFecha();
        selectorFecha.setListener(DetalleActivity.this);


        Bundle args = new Bundle();
        args.putLong(DialogSelectorFecha.FECHA, mArtista.getFechaNacimiento());
        selectorFecha.setArguments(args);
        selectorFecha.show(getSupportFragmentManager(), DialogSelectorFecha.SELECTED_DATE);*/
    }


    private void showMessage(int resource) {
        Snackbar.make(bind.content.containerMain, resource, Snackbar.LENGTH_SHORT).show();
    }


    public void photoHandler(View view) {
        switch (view.getId()) {
            case R.id.imgDeleteFoto:
                //Probaremos el materialalertDialog
                //AlertDialog.Builder builder = new AlertDialog.Builder(this)
                MaterialAlertDialogBuilder builder= new MaterialAlertDialogBuilder(this)
                        .setTitle(R.string.detalle_dialogDelete_title)
                        .setMessage(String.format(Locale.ROOT,
                                getString(R.string.detalle_dialogDelete_message),
                                mArtista.getNombreCompleto()))
                        .setPositiveButton(R.string.label_dialog_delete, (dialogInterface, i)->
                                savePhotoUrlArtist(null))
                        .setNegativeButton(R.string.label_dialog_cancel, null);
                builder.show();
                break;
            case R.id.imgFromGallery:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(intent,
                        getString(R.string.detalle_chooser_title)), RC_PHOTO_PICKER);
                break;
            case R.id.imgFromUrl:
                showAddPhotoDialog();
                break;
        }
    }

    private void showAddPhotoDialog() {
        final EditText etFotoUrl = new EditText(this);

        //Probaremos el materialalertDialog
        //AlertDialog.Builder builder = new AlertDialog.Builder(this)
        MaterialAlertDialogBuilder builder= new MaterialAlertDialogBuilder(this)
                .setTitle(R.string.addArtist_dialogUrl_title)
                .setPositiveButton(R.string.label_dialog_add, (dialogInterface, i)->
                    savePhotoUrlArtist(etFotoUrl.getText().toString().trim()))
                .setNegativeButton(R.string.label_dialog_cancel, null);
        builder.setView(etFotoUrl);
        builder.show();
    }

    @Override
    public void onClick(View view) {
        photoHandler(view);
    }
}
