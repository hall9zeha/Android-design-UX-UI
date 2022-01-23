// Generated by view binder compiler. Do not edit!
package com.alain.cursos.top.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.alain.cursos.top.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemArtistBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout containerMain;

  @NonNull
  public final CircleImageView imgFoto;

  @NonNull
  public final AppCompatTextView tvNombre;

  @NonNull
  public final AppCompatTextView tvNote;

  @NonNull
  public final AppCompatTextView tvOrden;

  private ItemArtistBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout containerMain, @NonNull CircleImageView imgFoto,
      @NonNull AppCompatTextView tvNombre, @NonNull AppCompatTextView tvNote,
      @NonNull AppCompatTextView tvOrden) {
    this.rootView = rootView;
    this.containerMain = containerMain;
    this.imgFoto = imgFoto;
    this.tvNombre = tvNombre;
    this.tvNote = tvNote;
    this.tvOrden = tvOrden;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemArtistBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemArtistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_artist, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemArtistBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout containerMain = (ConstraintLayout) rootView;

      id = R.id.imgFoto;
      CircleImageView imgFoto = ViewBindings.findChildViewById(rootView, id);
      if (imgFoto == null) {
        break missingId;
      }

      id = R.id.tvNombre;
      AppCompatTextView tvNombre = ViewBindings.findChildViewById(rootView, id);
      if (tvNombre == null) {
        break missingId;
      }

      id = R.id.tvNote;
      AppCompatTextView tvNote = ViewBindings.findChildViewById(rootView, id);
      if (tvNote == null) {
        break missingId;
      }

      id = R.id.tvOrden;
      AppCompatTextView tvOrden = ViewBindings.findChildViewById(rootView, id);
      if (tvOrden == null) {
        break missingId;
      }

      return new ItemArtistBinding((ConstraintLayout) rootView, containerMain, imgFoto, tvNombre,
          tvNote, tvOrden);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}