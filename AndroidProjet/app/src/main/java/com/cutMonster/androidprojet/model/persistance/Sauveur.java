package com.cutMonster.androidprojet.model.persistance;

import com.cutMonster.androidprojet.model.Joueur;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Gere la serialization d'une collection de joueurs
 */
public abstract class Sauveur {

    /**
     * Méthode abstract permettant de sauvegarder une collection de Partie
     * @param lesJoueurs La collection de joueurs à sauvegarder
     */
    public abstract void sauvegarderStats(List<Joueur> lesJoueurs, FileOutputStream file);

    /**
     * Méthode abstract permettant de charger une collection de joueurs
     * @return La collection de Partie
     */
    public abstract List<Joueur> chargerStats(FileInputStream file);
}

