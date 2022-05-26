// Generated by view binder compiler. Do not edit!
package com.divinando.tfg.adivinando.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.divinando.tfg.adivinando.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentFourChooserBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btAnswerA;

  @NonNull
  public final Button btAnswerB;

  @NonNull
  public final Button btAnswerC;

  @NonNull
  public final Button btAnswerD;

  @NonNull
  public final CardView cardPeppo;

  @NonNull
  public final CardView cardWho;

  @NonNull
  public final ImageView iPeppo;

  @NonNull
  public final ImageView iWho;

  @NonNull
  public final TextView tvMsg;

  @NonNull
  public final TextView tvRoundWho;

  @NonNull
  public final ConstraintLayout type;

  private FragmentFourChooserBinding(@NonNull ConstraintLayout rootView, @NonNull Button btAnswerA,
      @NonNull Button btAnswerB, @NonNull Button btAnswerC, @NonNull Button btAnswerD,
      @NonNull CardView cardPeppo, @NonNull CardView cardWho, @NonNull ImageView iPeppo,
      @NonNull ImageView iWho, @NonNull TextView tvMsg, @NonNull TextView tvRoundWho,
      @NonNull ConstraintLayout type) {
    this.rootView = rootView;
    this.btAnswerA = btAnswerA;
    this.btAnswerB = btAnswerB;
    this.btAnswerC = btAnswerC;
    this.btAnswerD = btAnswerD;
    this.cardPeppo = cardPeppo;
    this.cardWho = cardWho;
    this.iPeppo = iPeppo;
    this.iWho = iWho;
    this.tvMsg = tvMsg;
    this.tvRoundWho = tvRoundWho;
    this.type = type;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFourChooserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFourChooserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_four_chooser, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFourChooserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btAnswerA;
      Button btAnswerA = ViewBindings.findChildViewById(rootView, id);
      if (btAnswerA == null) {
        break missingId;
      }

      id = R.id.btAnswerB;
      Button btAnswerB = ViewBindings.findChildViewById(rootView, id);
      if (btAnswerB == null) {
        break missingId;
      }

      id = R.id.btAnswerC;
      Button btAnswerC = ViewBindings.findChildViewById(rootView, id);
      if (btAnswerC == null) {
        break missingId;
      }

      id = R.id.btAnswerD;
      Button btAnswerD = ViewBindings.findChildViewById(rootView, id);
      if (btAnswerD == null) {
        break missingId;
      }

      id = R.id.cardPeppo;
      CardView cardPeppo = ViewBindings.findChildViewById(rootView, id);
      if (cardPeppo == null) {
        break missingId;
      }

      id = R.id.cardWho;
      CardView cardWho = ViewBindings.findChildViewById(rootView, id);
      if (cardWho == null) {
        break missingId;
      }

      id = R.id.iPeppo;
      ImageView iPeppo = ViewBindings.findChildViewById(rootView, id);
      if (iPeppo == null) {
        break missingId;
      }

      id = R.id.iWho;
      ImageView iWho = ViewBindings.findChildViewById(rootView, id);
      if (iWho == null) {
        break missingId;
      }

      id = R.id.tvMsg;
      TextView tvMsg = ViewBindings.findChildViewById(rootView, id);
      if (tvMsg == null) {
        break missingId;
      }

      id = R.id.tvRoundWho;
      TextView tvRoundWho = ViewBindings.findChildViewById(rootView, id);
      if (tvRoundWho == null) {
        break missingId;
      }

      ConstraintLayout type = (ConstraintLayout) rootView;

      return new FragmentFourChooserBinding((ConstraintLayout) rootView, btAnswerA, btAnswerB,
          btAnswerC, btAnswerD, cardPeppo, cardWho, iPeppo, iWho, tvMsg, tvRoundWho, type);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}