package com.cutMonster.androidprojet.view.adaptateur;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cutMonster.androidprojet.R;

public class MonViewHolder extends RecyclerView.ViewHolder {

    /**
     * textView de type TextView
     */
    private TextView textView;

    /**
     * Constructeur publique MonViewHolder
     * @param itemView  l'itemView
     */
    public MonViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textViewJoueur);
    }

    /**
     * Méthode publique de type TextView permettant de récupérer le textView
     * @return
     */
    public TextView getTextView() {
        return textView;
    }


}
