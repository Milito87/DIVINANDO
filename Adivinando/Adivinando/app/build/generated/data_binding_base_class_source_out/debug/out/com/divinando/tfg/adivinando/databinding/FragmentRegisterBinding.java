// Generated by view binder compiler. Do not edit!
package com.divinando.tfg.adivinando.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.divinando.tfg.adivinando.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btRegister;

  @NonNull
  public final TextInputEditText etRegisterEmail;

  @NonNull
  public final TextInputEditText etRegisterPass;

  @NonNull
  public final TextInputEditText etRegisterPassRep;

  @NonNull
  public final TextInputEditText etRegisterUsername;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final Guideline guideline4;

  @NonNull
  public final ImageView registerLogo;

  @NonNull
  public final TextInputLayout tilRegisterEmail;

  @NonNull
  public final TextInputLayout tilRegisterPass;

  @NonNull
  public final TextInputLayout tilRegisterPassRep;

  @NonNull
  public final TextInputLayout tilRegisterUsername;

  private FragmentRegisterBinding(@NonNull ConstraintLayout rootView, @NonNull Button btRegister,
      @NonNull TextInputEditText etRegisterEmail, @NonNull TextInputEditText etRegisterPass,
      @NonNull TextInputEditText etRegisterPassRep, @NonNull TextInputEditText etRegisterUsername,
      @NonNull Guideline guideline3, @NonNull Guideline guideline4, @NonNull ImageView registerLogo,
      @NonNull TextInputLayout tilRegisterEmail, @NonNull TextInputLayout tilRegisterPass,
      @NonNull TextInputLayout tilRegisterPassRep, @NonNull TextInputLayout tilRegisterUsername) {
    this.rootView = rootView;
    this.btRegister = btRegister;
    this.etRegisterEmail = etRegisterEmail;
    this.etRegisterPass = etRegisterPass;
    this.etRegisterPassRep = etRegisterPassRep;
    this.etRegisterUsername = etRegisterUsername;
    this.guideline3 = guideline3;
    this.guideline4 = guideline4;
    this.registerLogo = registerLogo;
    this.tilRegisterEmail = tilRegisterEmail;
    this.tilRegisterPass = tilRegisterPass;
    this.tilRegisterPassRep = tilRegisterPassRep;
    this.tilRegisterUsername = tilRegisterUsername;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btRegister;
      Button btRegister = ViewBindings.findChildViewById(rootView, id);
      if (btRegister == null) {
        break missingId;
      }

      id = R.id.etRegisterEmail;
      TextInputEditText etRegisterEmail = ViewBindings.findChildViewById(rootView, id);
      if (etRegisterEmail == null) {
        break missingId;
      }

      id = R.id.etRegisterPass;
      TextInputEditText etRegisterPass = ViewBindings.findChildViewById(rootView, id);
      if (etRegisterPass == null) {
        break missingId;
      }

      id = R.id.etRegisterPassRep;
      TextInputEditText etRegisterPassRep = ViewBindings.findChildViewById(rootView, id);
      if (etRegisterPassRep == null) {
        break missingId;
      }

      id = R.id.etRegisterUsername;
      TextInputEditText etRegisterUsername = ViewBindings.findChildViewById(rootView, id);
      if (etRegisterUsername == null) {
        break missingId;
      }

      id = R.id.guideline3;
      Guideline guideline3 = ViewBindings.findChildViewById(rootView, id);
      if (guideline3 == null) {
        break missingId;
      }

      id = R.id.guideline4;
      Guideline guideline4 = ViewBindings.findChildViewById(rootView, id);
      if (guideline4 == null) {
        break missingId;
      }

      id = R.id.registerLogo;
      ImageView registerLogo = ViewBindings.findChildViewById(rootView, id);
      if (registerLogo == null) {
        break missingId;
      }

      id = R.id.tilRegisterEmail;
      TextInputLayout tilRegisterEmail = ViewBindings.findChildViewById(rootView, id);
      if (tilRegisterEmail == null) {
        break missingId;
      }

      id = R.id.tilRegisterPass;
      TextInputLayout tilRegisterPass = ViewBindings.findChildViewById(rootView, id);
      if (tilRegisterPass == null) {
        break missingId;
      }

      id = R.id.tilRegisterPassRep;
      TextInputLayout tilRegisterPassRep = ViewBindings.findChildViewById(rootView, id);
      if (tilRegisterPassRep == null) {
        break missingId;
      }

      id = R.id.tilRegisterUsername;
      TextInputLayout tilRegisterUsername = ViewBindings.findChildViewById(rootView, id);
      if (tilRegisterUsername == null) {
        break missingId;
      }

      return new FragmentRegisterBinding((ConstraintLayout) rootView, btRegister, etRegisterEmail,
          etRegisterPass, etRegisterPassRep, etRegisterUsername, guideline3, guideline4,
          registerLogo, tilRegisterEmail, tilRegisterPass, tilRegisterPassRep, tilRegisterUsername);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}