package com.cutMonster.androidprojet.view.adaptateur;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cutMonster.androidprojet.R;
import com.cutMonster.androidprojet.model.Joueur;

import java.util.List;

/**
 * Classe Adapateur qui hérite de RecyclerView
 */
public class Adaptateur extends RecyclerView.Adapter <MonViewHolder> {

    /**
     * liste lesJoueurs de type Joueur
     */
    private List<Joueur> lesJoueurs;

    /**
     * Constructeur publique Adapateur
     * @param lesJoueurs liste des joueurs
     */
    public Adaptateur(List<Joueur> lesJoueurs){
        this.lesJoueurs = lesJoueurs;
    }

    /**
     * Parse la cellule et crée le holder qui va contenir la cellule
     * @param parent parent qui va contenir la celulle
     * @param viewType type de la vue
     * @return ViewHolder
     */
    @NonNull
    @Override
    public MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout layoutJoueur = (LinearLayout)LayoutInflater.from(parent.getContext()).inflate(R.layout.cellule_joueur,parent, false);
        return new MonViewHolder(layoutJoueur);
    }

    /**
     * Permet de bind les informations de la cellule
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position) {
        holder.getTextView().setText(lesJoueurs.get(position).getPseudo()+ " " + lesJoueurs.get(position).getNbPoints());
    }

    /**
     * recupère le nombre d'item de la liste
     * @return le nombre d'item
     */
    @Override
    public int getItemCount() {
        return lesJoueurs.size();
    }


}
