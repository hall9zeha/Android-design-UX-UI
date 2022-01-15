package com.alain.cursos.top;

/* *
 * Project: MD Top from com.alain.cursos.top
 * Created by Alain Nicolás Tello on 10/11/2019 at 06:13 PM
 * All rights reserved 2019.
 * Course Material Design and Theming Professional for Android
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * Cursos Android ANT
 */

import android.app.DatePickerDialog;
import android.content.Intent;
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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;

import com.alain.cursos.top.databinding.ActivityAddArtistBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class AddArtistActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, View.OnClickListener {

    private static final int RC_PHOTO_PICKER = 21;


    private Artista mArtista;
    private Calendar mCalendar;
    private ActivityAddArtistBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind= ActivityAddArtistBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());


        configActionBar();
        configArtista(getIntent());
        configCalendar();
        bind.etFechaNacimiento.setOnClickListener(v->onSetFecha());
        bind.imgDeleteFoto.setOnClickListener(this);
        bind.imgFromGallery.setOnClickListener(this);
        bind.imgFromUrl.setOnClickListener(this);
    }

    private void configActionBar() {
        setSupportActionBar(bind.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void configArtista(Intent intent) {
        mArtista = new Artista();
        mArtista.setFechaNacimiento(System.currentTimeMillis());
        mArtista.setOrden(intent.getIntExtra(Artista.ORDEN, 0));
    }

    private void configCalendar() {
        mCalendar = Calendar.getInstance(Locale.ROOT);
        bind.etFechaNacimiento.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT).format(
                System.currentTimeMillis()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_save:
                saveArtist();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveArtist() {
        if (validateFields() && bind.etNombre.getText() != null && bind.etApellidos.getText() != null &&
                bind.etEstatura.getText() != null && bind.etLugarNacimiento.getText() != null &&
                bind.etNotas.getText() != null) {
            mArtista.setNombre(bind.etNombre.getText().toString().trim());
            mArtista.setApellidos(bind.etApellidos.getText().toString().trim());
            mArtista.setEstatura(Short.valueOf(bind.etEstatura.getText().toString().trim()));
            mArtista.setLugarNacimiento(bind.etLugarNacimiento.getText().toString().trim());
            mArtista.setNotas(bind.etNotas.getText().toString().trim());
            try {
                mArtista.save();
                Log.i("DBFlow", "Inserción correcta de datos.");
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("DBFlow", "Error al insertar datos.");
            }

            finish();
        }
    }

    private boolean validateFields() {
        boolean isValid = true;

        if (bind.etEstatura.getText() != null && (bind.etEstatura.getText().toString().trim().isEmpty() ||
                Integer.valueOf(bind.etEstatura.getText().toString().trim()) < getResources().getInteger(R.integer.estatura_min)) ) {
            bind.tilHeight.setError(getString(R.string.addArtist_error_estaturaMin));
            bind.tilHeight.requestFocus();
            isValid = false;
        }
        else{
            bind.tilHeight.setError(null);
        }
        if (bind.etApellidos.getText() != null && bind.etApellidos.getText().toString().trim().isEmpty()) {
            bind.tilLastNames.setError(getString(R.string.addArtist_error_required));
            bind.tilLastNames.requestFocus();
            isValid = false;
        }
        else{
            bind.tilLastNames.setError(null);
        }
        if (bind.etNombre.getText() != null && bind.etNombre.getText().toString().trim().isEmpty()) {
           /* bind.etNombre.setError(getString(R.string.addArtist_error_required));
            bind.etNombre.requestFocus();*/
            bind.tilName.setError(getString(R.string.addArtist_error_required));
            bind.tilName.requestFocus();
            isValid = false;
        }
        else{
            bind.tilName.setError(null);
        }

        return isValid;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == RC_PHOTO_PICKER) {
                configImageView(data.getDataString());
            }
        }
    }


    public void onSetFecha() {
        DialogSelectorFecha selectorFecha = new DialogSelectorFecha();
        selectorFecha.setListener(AddArtistActivity.this);

        Bundle args = new Bundle();
        args.putLong(DialogSelectorFecha.FECHA, mArtista.getFechaNacimiento());
        selectorFecha.setArguments(args);
        selectorFecha.show(getSupportFragmentManager(), DialogSelectorFecha.SELECTED_DATE);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, day);

        bind.etFechaNacimiento.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT).format(
                mCalendar.getTimeInMillis()));
        mArtista.setFechaNacimiento(mCalendar.getTimeInMillis());
    }


    public void imageEvents(View view) {
        switch (view.getId()) {
            case R.id.imgDeleteFoto:
                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle(R.string.detalle_dialogDelete_title)
                        .setMessage(String.format(Locale.ROOT,
                                getString(R.string.detalle_dialogDelete_message),
                                mArtista.getNombreCompleto()))
                        .setPositiveButton(R.string.label_dialog_delete, (dialogInterface, i)-> configImageView(null))
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

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(R.string.addArtist_dialogUrl_title)
                .setPositiveButton(R.string.label_dialog_add, (dialogInterface, i)->
                        configImageView(etFotoUrl.getText().toString().trim()))
                .setNegativeButton(R.string.label_dialog_cancel, null);
        builder.setView(etFotoUrl);
        builder.show();
    }

    private void configImageView(String fotoUrl) {
        if (fotoUrl != null){
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

    @Override
    public void onClick(View view) {
        imageEvents(view);
    }
}
