// Generated by view binder compiler. Do not edit!
package com.alain.cursos.top.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.alain.cursos.top.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContentDetalleBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final NestedScrollView containerMain;

  @NonNull
  public final TextInputEditText etApellidos;

  @NonNull
  public final TextInputEditText etEdad;

  @NonNull
  public final TextInputEditText etEstatura;

  @NonNull
  public final TextInputEditText etFechaNacimiento;

  @NonNull
  public final TextInputEditText etLugarNacimiento;

  @NonNull
  public final TextInputEditText etNombre;

  @NonNull
  public final TextInputEditText etNotas;

  @NonNull
  public final TextInputEditText etOrden;

  @NonNull
  public final TextInputLayout tilHeight;

  @NonNull
  public final TextInputLayout tilLastNames;

  @NonNull
  public final TextInputLayout tilName;

  private ContentDetalleBinding(@NonNull NestedScrollView rootView,
      @NonNull NestedScrollView containerMain, @NonNull TextInputEditText etApellidos,
      @NonNull TextInputEditText etEdad, @NonNull TextInputEditText etEstatura,
      @NonNull TextInputEditText etFechaNacimiento, @NonNull TextInputEditText etLugarNacimiento,
      @NonNull TextInputEditText etNombre, @NonNull TextInputEditText etNotas,
      @NonNull TextInputEditText etOrden, @NonNull TextInputLayout tilHeight,
      @NonNull TextInputLayout tilLastNames, @NonNull TextInputLayout tilName) {
    this.rootView = rootView;
    this.containerMain = containerMain;
    this.etApellidos = etApellidos;
    this.etEdad = etEdad;
    this.etEstatura = etEstatura;
    this.etFechaNacimiento = etFechaNacimiento;
    this.etLugarNacimiento = etLugarNacimiento;
    this.etNombre = etNombre;
    this.etNotas = etNotas;
    this.etOrden = etOrden;
    this.tilHeight = tilHeight;
    this.tilLastNames = tilLastNames;
    this.tilName = tilName;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentDetalleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentDetalleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_detalle, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentDetalleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      NestedScrollView containerMain = (NestedScrollView) rootView;

      id = R.id.etApellidos;
      TextInputEditText etApellidos = ViewBindings.findChildViewById(rootView, id);
      if (etApellidos == null) {
        break missingId;
      }

      id = R.id.etEdad;
      TextInputEditText etEdad = ViewBindings.findChildViewById(rootView, id);
      if (etEdad == null) {
        break missingId;
      }

      id = R.id.etEstatura;
      TextInputEditText etEstatura = ViewBindings.findChildViewById(rootView, id);
      if (etEstatura == null) {
        break missingId;
      }

      id = R.id.etFechaNacimiento;
      TextInputEditText etFechaNacimiento = ViewBindings.findChildViewById(rootView, id);
      if (etFechaNacimiento == null) {
        break missingId;
      }

      id = R.id.etLugarNacimiento;
      TextInputEditText etLugarNacimiento = ViewBindings.findChildViewById(rootView, id);
      if (etLugarNacimiento == null) {
        break missingId;
      }

      id = R.id.etNombre;
      TextInputEditText etNombre = ViewBindings.findChildViewById(rootView, id);
      if (etNombre == null) {
        break missingId;
      }

      id = R.id.etNotas;
      TextInputEditText etNotas = ViewBindings.findChildViewById(rootView, id);
      if (etNotas == null) {
        break missingId;
      }

      id = R.id.etOrden;
      TextInputEditText etOrden = ViewBindings.findChildViewById(rootView, id);
      if (etOrden == null) {
        break missingId;
      }

      id = R.id.tilHeight;
      TextInputLayout tilHeight = ViewBindings.findChildViewById(rootView, id);
      if (tilHeight == null) {
        break missingId;
      }

      id = R.id.tilLastNames;
      TextInputLayout tilLastNames = ViewBindings.findChildViewById(rootView, id);
      if (tilLastNames == null) {
        break missingId;
      }

      id = R.id.tilName;
      TextInputLayout tilName = ViewBindings.findChildViewById(rootView, id);
      if (tilName == null) {
        break missingId;
      }

      return new ContentDetalleBinding((NestedScrollView) rootView, containerMain, etApellidos,
          etEdad, etEstatura, etFechaNacimiento, etLugarNacimiento, etNombre, etNotas, etOrden,
          tilHeight, tilLastNames, tilName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}